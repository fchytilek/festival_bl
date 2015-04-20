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
		standleiter = maNeu;
	}
	
	public void stellvertreterAendern(Mitarbeiter maNeu) throws Exception{
		Veranstaltung veranstaltung = vv.getVeranstaltungById(vid);
		veranstaltung.statusAendern(maNeu, "stellvertreter");
		stellvertreter = maNeu;
	}
	
	public void mitarbeiterHinzufuegen(Mitarbeiter ma){ 
		if(!mitarbeiterListe.contains(ma))
			mitarbeiterListe.add(ma);
	}
	
	public void mitarbeiterLoeschen(Mitarbeiter ma){
		if(mitarbeiterListe.contains(ma))
			mitarbeiterListe.remove(ma);
	}
}
