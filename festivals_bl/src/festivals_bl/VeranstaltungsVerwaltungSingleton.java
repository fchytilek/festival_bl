package festivals_bl;

import java.util.ArrayList;

public class VeranstaltungsVerwaltungSingleton {
	
	private static VeranstaltungsVerwaltungSingleton instance;
	private ArrayList<Veranstaltung> veranstaltungsListe;
	
	public static VeranstaltungsVerwaltungSingleton getInstance(){
		return instance;
		
	}
	
	public void veranstaltungHinzufuegen(Veranstaltung va){
		this.veranstaltungsListe.add(va);
		
	}
	
	public void veranstaltungLoeschen(Veranstaltung va){
		this.veranstaltungsListe.remove(va);
		
	}
	
	public void veranstaltungAendern(Veranstaltung vaNeu) throws Exception{
		for(Veranstaltung vaAlt : this.veranstaltungsListe){
			if( vaAlt.getVid()==vaNeu.getVid() ){
				this.veranstaltungsListe.remove(vaAlt);
				this.veranstaltungsListe.add(vaNeu);
			}	
		}
		
		throw new Exception("Veranstaltung wurde nicht in der Liste gefunden");
	}
	
	public Veranstaltung getVeranstaltungById(int id) throws Exception{
		for(Veranstaltung v : veranstaltungsListe){
			if(v.getVid() == id)
				return v;
		}
		
		throw new Exception("Keine Veranstlung mit dieser ID gefunden!");
	}
	
	

}
