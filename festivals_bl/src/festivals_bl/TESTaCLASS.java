package festivals_bl;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class TESTaCLASS {

	public static void main(String[] args) throws Exception {
		
		//MitarbeiterVerwaltungSingleton
		MitarbeiterVerwaltungSingleton mv = MitarbeiterVerwaltungSingleton.getInstance();
			System.out.println(" MitarbeiterVerwaltungSingleton erzeugt ");
		
		//2 Mitarbeiter zum testen hinzufügen
		Mitarbeiter wolfi = new Mitarbeiter("Wolfgang", "Erler", "pw1");
		Mitarbeiter flo = new Mitarbeiter("Florian", "Chytilek", "pw1");
			ArrayList<Mitarbeiter> wolfiUndFlo = new ArrayList<Mitarbeiter>();
			wolfiUndFlo.add(wolfi);
			wolfiUndFlo.add(flo);
			System.out.println(" Wolfi und Flo erzeugt ");
		
		mv.mitarbeiterHinzufuegen(wolfi);
		mv.mitarbeiterHinzufuegen(flo);
			System.out.println(" Wolfi und Flo zu Mitarbeiterverwaltung hinzugefügt ");
			System.out.println(" Verifizierung von " + mv.mitarbeiterVerifizieren("FChytilek", "pw1").getVorname() + " erfolgreich");
		
		//VeranstaltungsVerwaltungSingleton
		VeranstaltungsVerwaltungSingleton vv = VeranstaltungsVerwaltungSingleton.getInstance();
			System.out.println(" VeranstaltungsVerwaltungSingleton erzeugt ");
		
		//Anfangsdatum für TestVeranstaltung 
		GregorianCalendar anfangsDatum = new GregorianCalendar();
		anfangsDatum.set(2015, 7, 22, 0, 0);
			System.out.println(" anfangsDatum gesetzt auf: " + anfangsDatum.getTime());
		
		//Enddatum für TestVeranstaltung
		GregorianCalendar endDatum = new GregorianCalendar();
		endDatum.set(2015, 7, 25, 0, 0);
			System.out.println(" endDatum gesetzt auf: " + endDatum.getTime());
		
		//TestVeranstaltung erstellen
		Veranstaltung testVeranstaltung = new Veranstaltung("Frequency", anfangsDatum, endDatum, flo);
			System.out.println(" testVeranstaltung erzeugt" );
			
		//TestVeranstaltung zur VeranstaltungsVerwaltung hinzufügen
		vv.veranstaltungHinzufuegen(testVeranstaltung);
			System.out.println(" testVeranstaltung zu Veranstaltungsverwaltung hinzugefügt");
		
		//Wolfi und Flo zur Veranstaltung hinzufügen
		vv.getVeranstaltungById(testVeranstaltung.getVid()).mitarbeiterHinzufuegen(wolfi, "mitarbeiter");
		vv.getVeranstaltungById(testVeranstaltung.getVid()).mitarbeiterHinzufuegen(flo, "mitarbeiter");
			System.out.println(" Wolfi und Flo zur Veranstaltung hinzugefügt. Liste");
		for(Mitarbeiter ma : vv.getVeranstaltungById(testVeranstaltung.getVid()).getMitarbeiterGesamt())
			System.out.println(' '+ma.getVorname()+' '+ma.getNachname()+' '+ma.getUsername()+' '+ma.getPasswort()+' '+vv.getVeranstaltungById(testVeranstaltung.getVid()).getStatusliste().get(ma));
		
		//Status ändern -> Flo auf Teamleiter
		vv.getVeranstaltungById(testVeranstaltung.getVid()).statusAendern(flo, "teamleiter");
			System.out.println(" Status geändert Wolfi und Flo ");
		for(Mitarbeiter ma : vv.getVeranstaltungById(testVeranstaltung.getVid()).getMitarbeiterGesamt())
			System.out.println(' '+ma.getVorname()+' '+ma.getNachname()+' '+ma.getUsername()+' '+ma.getPasswort()+' '+vv.getVeranstaltungById(testVeranstaltung.getVid()).getStatusliste().get(ma));
			
		//Stand erstellen und zur Veranstaltung hinzufügen
		Stand stand = new Stand(1,testVeranstaltung.getVid());
		vv.getVeranstaltungById(testVeranstaltung.getVid()).standHinzufügen(stand);
			System.out.println(" Stand hinzugefügt zu testVeranstaltung. Standliste:");
		//Ausgabe der Standliste für testVeranstaltung
		for(Stand st : vv.getVeranstaltungById(testVeranstaltung.getVid()).getStandliste()){
			System.out.println(" Standnummer: "+st.getStandnummer()+" Standleiter: "+st.getStandleiter().getVorname()+' '+st.getStandleiter().getNachname()+" Stellverteter: "+st.getStellvertreter().getVorname()+' '+st.getStellvertreter().getNachname()+" MaListe: ");
				for(Mitarbeiter ma : st.getMitarbeiterListe())
					System.out.println(' '+ma.getVorname()+' '+ma.getNachname()+' '+ma.getUsername()+' '+ma.getPasswort()+' '+vv.getVeranstaltungById(testVeranstaltung.getVid()).getStatusliste().get(ma));		
		}
		
		//Wolfi und Flo zum erstellten Stand hinzufügen
		vv.getVeranstaltungById(testVeranstaltung.getVid()).mitarbeiterStandZuteilen(stand.getStandnummer(), wolfiUndFlo);
			System.out.println(" Wolfi und Flo zu Stand hinzugefügt ");
		
		//Nochmalige Ausgabe der Standliste für testVeranstaltung
				for(Stand st : vv.getVeranstaltungById(testVeranstaltung.getVid()).getStandliste()){
					System.out.println(" Standnummer: "+st.getStandnummer()+" Standleiter: "+st.getStandleiter().getVorname()+' '+st.getStandleiter().getNachname()+" Stellverteter: "+st.getStellvertreter().getVorname()+' '+st.getStellvertreter().getNachname()+" MaListe: ");
						for(Mitarbeiter ma : st.getMitarbeiterListe())
							System.out.println(' '+ma.getVorname()+' '+ma.getNachname()+' '+ma.getUsername()+' '+ma.getPasswort()+' '+vv.getVeranstaltungById(testVeranstaltung.getVid()).getStatusliste().get(ma));		
	
				}
		
		//Arbeit für wolfi beginnen
		int standnummer = 5; // Standnummer für Wolfi herraussuchen p.S. 5 nur damit unten nicht steht es wäre nicht initialisiert
		for(Stand st : vv.getVeranstaltungById(testVeranstaltung.getVid()).getStandliste())
			for(Mitarbeiter ma : st.getMitarbeiterListe())
					if( ma.getVorname().equals(wolfi.getVorname()) && ma.getNachname().equals(wolfi.getNachname() ) )
						standnummer=st.getStandnummer();
			System.out.println("Wolfi befindet sich auf Stand "+ standnummer);
		
		//Arbeitsbeginn erstellen
		GregorianCalendar arbeitsbeginn = new GregorianCalendar();
		arbeitsbeginn.set(2015, 7, 22, 13, 30);
			System.out.println("Arbeitsbeginn wurde gesetzt: "+arbeitsbeginn.getTime());
		
		//Abrechnungsstatus für wolfi herraussuchen
		String abrechnungsStatus = vv.getVeranstaltungById(testVeranstaltung.getVid()).getStatusliste().get(wolfi);
		
		ArrayList<Mitarbeiter> wolfisList = new ArrayList<Mitarbeiter>();
		wolfisList.add(wolfi);
		// Arbeit tatsächlich beginnen
		vv.getVeranstaltungById(testVeranstaltung.getVid()).arbeitBeginnen(standnummer, wolfisList, arbeitsbeginn, abrechnungsStatus);
		
		//Arbeiten von Wolfi ausgeben
			System.out.println("Wolfis arbeiten: ");
		for(Einzelabrechnung ea : wolfi.getAbrechnungsListe())
			if(ea.getVid() == testVeranstaltung.getVid())
				for(Arbeit arb : ea.getArbeitsliste())
					System.out.println("Beginn: "+arb.getArbeitsbeginn().getTime()+" Ende: "+arb.getArbeitsende().getTime());
		
		//Wolfis arbeit wieder beenden
		
		//Arbeitsende erstellen
				GregorianCalendar arbeitsende = new GregorianCalendar();
				arbeitsende.set(2015, 7, 22, 18, 30);
					System.out.println("Arbeitsende wurde gesetzt: "+arbeitsbeginn.getTime());
							
	}
}
