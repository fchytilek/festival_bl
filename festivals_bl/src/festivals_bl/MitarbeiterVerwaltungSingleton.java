package festivals_bl;

import java.util.ArrayList;

public class MitarbeiterVerwaltungSingleton {
	
	private static MitarbeiterVerwaltungSingleton instance;
	private ArrayList<Mitarbeiter> mitarbeiterListe;
	
	public static MitarbeiterVerwaltungSingleton getInstance(){
		return instance;
	}
	
	public void mitarbeiterHinzufuegen(Mitarbeiter ma){
		mitarbeiterListe.add(ma);
	}
	
	public void mitarbeiterLoeschen(Mitarbeiter ma){
		mitarbeiterListe.remove(ma);
	}
	
	public void mitarbeiterAendern(Mitarbeiter maNeu) throws Exception{
		for(Mitarbeiter maAlt : mitarbeiterListe){
			if( maAlt.getVorname().equals( maNeu.getVorname() ) && maAlt.getNachname().equals( maNeu.getNachname() ) ){
				this.mitarbeiterLoeschen(maAlt);
				this.mitarbeiterHinzufuegen(maNeu);
			}
		}
		
		throw new Exception("Keine Veranstlung mit dieser ID gefunden!");
	}
	
	public Mitarbeiter mitarbeiterVerifizieren(String username, String passwort) throws Exception{
		for(Mitarbeiter ma : mitarbeiterListe){
			if( ma.getUsername().equals(username) && ma.getPasswort().equals(passwort) )
				return ma;
		}
		
		throw new Exception("Username oder Passwort wurden nicht richtig eingegeben");
	}
}
