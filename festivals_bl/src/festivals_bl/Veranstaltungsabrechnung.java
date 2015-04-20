package festivals_bl;


import java.util.ArrayList;

public class Veranstaltungsabrechnung {
	private ArrayList<Einzelabrechnung> abrechnungsliste;
	public String[] abrechnungErstellen(){
		int i = abrechnungsliste.size();
		String[] erg= new String[i];
		int count=0;
		for(Einzelabrechnung ea : abrechnungsliste){
			for(Arbeit arbeit : ea.getArbeitsliste()){
				erg[count]=ea.getMitarbeiter().getVorname() +"_"+ ea.getMitarbeiter().getNachname() +"_"+ "";
			}
		}
		return new String[1];
	}
}
