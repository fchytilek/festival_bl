package festivals_bl;

import java.util.ArrayList;

public class VeranstaltungsVerwaltungSingleton {
	
	private static VeranstaltungsVerwaltungSingleton instance;
	private ArrayList<Veranstaltung> veranstaltungsListe;
	
	public static VeranstaltungsVerwaltungSingleton getInstance(){
		return instance;
		
	}
	
	public void veranstaltungHinzufuegen(Veranstaltung v){
		
	}
	
	public void veranstaltungLoeschen(int vid){
		
	}
	
	public void veranstaltungAendern(Veranstaltung v){
		
	}
	
	public Veranstaltung getVeranstaltungById(int id) throws Exception{
		for(Veranstaltung v : veranstaltungsListe){
			if(v.getVid() == id)
				return v;
		}
		
		throw new Exception("Keine Veranstlung mit dieser ID gefunden!");
	}
	
	

}
