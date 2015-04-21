package festivals_bl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class Veranstaltung {

	private static int vidCounter = 0;
	private int vid;
	private String name;
	private GregorianCalendar anfangsDatum;
	private GregorianCalendar endDatum;
	private Mitarbeiter erstelltVon;
	
	private ArrayList<Stand> standliste;
	private ArrayList<Mitarbeiter> mitarbeiterGesamt;
	private ArrayList<Mitarbeiter> mitarbeiterAbgeschlossen;
	private ArrayList<Mitarbeiter> mitarbeiterAusbezahlt;
	
	private Veranstaltungsabrechnung abrechnung;
	private Hashtable<Mitarbeiter, String> statusliste;
	private Hashtable<String, Double> verdienstliste;

	public Veranstaltung(String name, GregorianCalendar anfangsDatum, GregorianCalendar endDatum, Mitarbeiter erstelltVon) {
		super();
		this.name = name;
		this.anfangsDatum = anfangsDatum;
		this.endDatum = endDatum;
		this.erstelltVon = erstelltVon;
		
		vid = vidCounter;
		vidCounter++;
		
		standliste = new ArrayList<Stand>();
		mitarbeiterGesamt = new ArrayList<Mitarbeiter>() ;
		mitarbeiterAbgeschlossen = new ArrayList<Mitarbeiter>() ;
		mitarbeiterAusbezahlt = new ArrayList<Mitarbeiter>() ;
		statusliste = new Hashtable<Mitarbeiter, String>() ;
		verdienstliste = new Hashtable<String, Double>();
		verdienstliste.put("teamleiter", 10.00);
		verdienstliste.put("standleiter", 10.00);
		verdienstliste.put("mitarbeiter", 8.50);
		verdienstliste.put("schlepper", 9.00);
		
		
		
	}

	public void standHinzufügen(Stand stand) throws Exception {
		if(!standliste.contains(stand))
			standliste.add(stand);
		else
			throw new Exception("Stand existiert bereits in der Liste");
	}

	public boolean standLoeschen(Stand stand) {
		for (Stand s : standliste) {
			if (stand == s) {
				standliste.remove(stand);
				return true;
			}

		}
		return false;
	}

	public void mitarbeiterHinzufuegen(Mitarbeiter ma, String status){
		mitarbeiterGesamt.add(ma);
		statusliste.put(ma, status);
		ma.getAbrechnungsListe().add(new Einzelabrechnung(ma,this.vid));
	}
	
	public void mitarbeiterStandZuteilen(int standnummer, ArrayList<Mitarbeiter> mitarbeiterliste) throws Exception {
		for (Mitarbeiter maNeu : mitarbeiterliste) {	
			for (Stand stand : standliste) {
				
				for(Mitarbeiter maAlt : stand.getMitarbeiterListe())
					if( maNeu.getVorname().equals(maAlt.getVorname()) && maNeu.getNachname().equals(maAlt.getNachname() ) )
						throw new Exception("Der Mitarbeiter ist bereits einem Stand zugewießen");
				
				if (stand.getStandnummer() == standnummer) {				
					stand.mitarbeiterHinzufuegen(maNeu);
				}
			}
		}

	}

	public boolean mitarbeiterVerschieben(Mitarbeiter ma, int standVon,	int standZu, String abrechnungsStatus) throws Exception {
		for (Stand s : standliste) {
			if (s.getStandnummer() == standVon) {
				
				s.mitarbeiterLoeschen(ma);
				
				for (Einzelabrechnung ea : ma.getAbrechnungsListe()) {
					
					ArrayList<Mitarbeiter> mitarbeiterListe = new ArrayList<Mitarbeiter>();
					mitarbeiterListe.add(ma);
					
					if (ea.getVid() == vid) {
						if(ea.isAktiv()){
					
							this.arbeitBeenden(mitarbeiterListe, new GregorianCalendar());			
						}
					
						this.arbeitBeginnen(standZu, mitarbeiterListe, new GregorianCalendar() , abrechnungsStatus);

						for (Stand s2 : standliste) {
							if (s2.getStandnummer() == standZu) {
								s2.mitarbeiterHinzufuegen(ma);
								
							}
						}
					}
				}
			}
		}
		
		for (Stand s : standliste) {
			if (s.getStandnummer() == standZu) {

				s.mitarbeiterHinzufuegen(ma);
			}
		}

		return true;
	}

	public void statusAendern(Mitarbeiter ma, String status) {
		statusliste.remove(ma);
		statusliste.put(ma, status);
	}

	public boolean arbeitBeginnen(int standnummer, ArrayList<Mitarbeiter> mitarbeiterliste,	GregorianCalendar arbeitsbeginn, String abrechnungsStatus) throws Exception {
		
		if(!arbeitsbeginn.after(this.anfangsDatum) || !arbeitsbeginn.before(this.endDatum))
			throw new Exception("Arbeitsbeginn liegt nicht im Zeitaum der Veranstaltung");
		
		for( Mitarbeiter ma: mitarbeiterliste) {
			for (Einzelabrechnung ea : ma.getAbrechnungsListe()) {
				if (ea.getVid() == vid)
					if(ea.isAktiv())
						throw new Exception("Es ist noch eine Arbeit offen");
					else{
						
						Arbeit arb = new Arbeit(standnummer, ma, arbeitsbeginn, abrechnungsStatus, false);//false für: geplant = false
						arb.setAktiv(true);
						ea.getArbeitsliste().add(arb);
						ea.setAktiv(true);
					}
				}
		}
		
		return true;
	}

	public void pauseHinzufuegen(ArrayList<Mitarbeiter> mitarbeiterliste, GregorianCalendar pausenbeginn, GregorianCalendar pausenende) {
		for( Mitarbeiter ma: mitarbeiterliste) {
			for (Einzelabrechnung ea : ma.getAbrechnungsListe()) {
				if (ea.getVid() == vid)
					for(Arbeit arb : ea.getArbeitsliste()){
						if(arb.getArbeitsende()==null){
							
							ArrayList<GregorianCalendar> pausenListe = arb.getPausenListe();
							pausenListe.add(pausenbeginn);
							pausenListe.add(pausenende);
							arb.setPausenListe(pausenListe);
					}
				}
			}
		}
	}

	public void arbeitHinzufuegen(int standnummer, ArrayList<Mitarbeiter> mitarbeiterliste, GregorianCalendar arbeitsbeginn, GregorianCalendar arbeitsende, ArrayList<GregorianCalendar> pausenliste, String abrechnungsStatus, boolean geplant) {
		for( Mitarbeiter ma: mitarbeiterliste) {
			for (Einzelabrechnung ea : ma.getAbrechnungsListe()) {
				if (ea.getVid() == vid){
					
					Arbeit arbeit = new Arbeit(standnummer, ma, arbeitsbeginn, abrechnungsStatus, geplant);
					arbeit.setArbeitsende(arbeitsende);
					arbeit.setPausenListe(pausenliste);
					ea.getArbeitsliste().add(arbeit);//false für: geplant = false
				}	
			}
		}

	}

	public boolean arbeitBeenden(ArrayList<Mitarbeiter> mitarbeiterliste, GregorianCalendar arbeitsende) throws Exception {
		
		for( Mitarbeiter ma: mitarbeiterliste) {
			for (Einzelabrechnung ea : ma.getAbrechnungsListe()) {
				if (ea.getVid() == vid){
					if(!ea.isAktiv())
						throw new Exception("Es ist keine Arbeit offen");
					else{
						for(Arbeit arb : ea.getArbeitsliste()){
							if(arb.isAktiv()){
								arb.setArbeitsende(arbeitsende);
								arb.setAktiv(false);
								ea.setAktiv(false);
							}
						}
					}
				}	
			}
		}
		
		return true;
	}

	public boolean mitarbeiterAbschliessen(Mitarbeiter ma) throws Exception {
			
		for(Einzelabrechnung abr : ma.getAbrechnungsListe())
				if(abr.getVid()==vid)
					if(abr.isAktiv())
						throw new Exception("Der Mitarbeiter ist noch aktiv");
					else{
						abrechnung.getAbrechnungsliste().add(abr);
						abr.setAbgeschlossen(true);
					}	
		
		return true;
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public GregorianCalendar getAnfangsDatum() {
		return anfangsDatum;
	}

	public void setAnfangsDatum(GregorianCalendar anfangsDatum) {
		this.anfangsDatum = anfangsDatum;
	}

	public GregorianCalendar getEndDatum() {
		return endDatum;
	}

	public void setEndDatum(GregorianCalendar endDatum) {
		this.endDatum = endDatum;
	}

	public Mitarbeiter getErstelltVon() {
		return erstelltVon;
	}

	public void setErstelltVon(Mitarbeiter erstelltVon) {
		this.erstelltVon = erstelltVon;
	}

	public ArrayList<Mitarbeiter> getMitarbeiterGesamt() {
		return mitarbeiterGesamt;
	}

	public void setMitarbeiterGesamt(ArrayList<Mitarbeiter> mitarbeiterGesamt) {
		this.mitarbeiterGesamt = mitarbeiterGesamt;
	}

	public ArrayList<Mitarbeiter> getMitarbeiterAbgeschlossen() {
		return mitarbeiterAbgeschlossen;
	}

	public void setMitarbeiterAbgeschlossen(
			ArrayList<Mitarbeiter> mitarbeiterAbgeschlossen) {
		this.mitarbeiterAbgeschlossen = mitarbeiterAbgeschlossen;
	}

	public ArrayList<Mitarbeiter> getMitarbeiterAusbezahlt() {
		return mitarbeiterAusbezahlt;
	}

	public void setMitarbeiterAusbezahlt(
			ArrayList<Mitarbeiter> mitarbeiterAusbezahlt) {
		this.mitarbeiterAusbezahlt = mitarbeiterAusbezahlt;
	}

	public Hashtable<Mitarbeiter, String> getStatusliste() {
		return statusliste;
	}

	public void setStatusliste(Hashtable<Mitarbeiter, String> statusliste) {
		this.statusliste = statusliste;
	}

	public Hashtable<String, Double> getVerdienstliste() {
		return verdienstliste;
	}

	public void setVerdienstliste(Hashtable<String, Double> verdienstliste) {
		this.verdienstliste = verdienstliste;
	}

	public ArrayList<Stand> getStandliste() {
		return standliste;
	}

	public void setStandliste(ArrayList<Stand> standliste) {
		this.standliste = standliste;
	}

	public Veranstaltungsabrechnung getAbrechnung() {
		return abrechnung;
	}

	public void setAbrechnung(Veranstaltungsabrechnung abrechnung) {
		this.abrechnung = abrechnung;
	}
}
