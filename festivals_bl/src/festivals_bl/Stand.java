package festivals_bl;

import java.util.ArrayList;

public class Stand {
	
	private int vid;
	private int standnummer;
	private Mitarbeiter standleiter;
	private Mitarbeiter stellvertreter;
	private ArrayList<Mitarbeiter> mitarbeiterListe;
	VeranstaltungsVerwaltungSingleton vv = VeranstaltungsVerwaltungSingleton.getInstance();
	
	public void standleiterAendern(Mitarbeiter maNeu) throws Exception{
		Veranstaltung veranstaltung = vv.getVeranstaltungById(vid);
		veranstaltung.statusAendern(maNeu, "standleiter");
		this.setStandleiter(maNeu);
	}
	
	public void stellvertreterAendern(Mitarbeiter maNeu) throws Exception{
		Veranstaltung veranstaltung = vv.getVeranstaltungById(vid);
		veranstaltung.statusAendern(maNeu, "stellvertreter");
		this.setStellvertreter(maNeu);
	}
	
	public void mitarbeiterHinzufuegen(Mitarbeiter ma){ 
		if(!mitarbeiterListe.contains(ma))
			mitarbeiterListe.add(ma);
	}
	
	public void mitarbeiterLoeschen(Mitarbeiter ma){
		if(mitarbeiterListe.contains(ma))
			mitarbeiterListe.remove(ma);
	}

	public int getVid() {
		return vid;
	}

	public void setVid(int vid) {
		this.vid = vid;
	}

	public int getStandnummer() {
		return standnummer;
	}

	public void setStandnummer(int standnummer) {
		this.standnummer = standnummer;
	}

	public Mitarbeiter getStandleiter() {
		return standleiter;
	}

	public void setStandleiter(Mitarbeiter standleiter) {
		this.standleiter = standleiter;
	}

	public Mitarbeiter getStellvertreter() {
		return stellvertreter;
	}

	public void setStellvertreter(Mitarbeiter stellvertreter) {
		this.stellvertreter = stellvertreter;
	}

	public ArrayList<Mitarbeiter> getMitarbeiterListe() {
		return mitarbeiterListe;
	}

	public void setMitarbeiterListe(ArrayList<Mitarbeiter> mitarbeiterListe) {
		this.mitarbeiterListe = mitarbeiterListe;
	}
}
