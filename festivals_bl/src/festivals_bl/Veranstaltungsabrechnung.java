package festivals_bl;


import java.util.ArrayList;

public class Veranstaltungsabrechnung {
	
	private ArrayList<Einzelabrechnung> abrechnungsliste;
	
	public Veranstaltungsabrechnung(){
		abrechnungsliste = new ArrayList<Einzelabrechnung>();
	}
	
	public String[] abrechnungErstellen(){
		int i = abrechnungsliste.size();
		String[] erg= new String[i];
		int count=0;
		for(Einzelabrechnung ea : abrechnungsliste){
			erg[count]=ea.getMitarbeiter().getVorname() +"_"+ ea.getMitarbeiter().getNachname() +"_";
			for(Arbeit arbeit : ea.getArbeitsliste()){
				erg[count]+= (arbeit.getArbeitsende().getTimeInMillis()-arbeit.getArbeitsbeginn().getTimeInMillis())/1000/60/60+"_stundenAmStand_"+arbeit.getStandnummer()+"_";
			}
			count++;
		}
		return erg;
	}
	public ArrayList<Einzelabrechnung> getAbrechnungsliste() {
		return abrechnungsliste;
	}
	public void setAbrechnungsliste(ArrayList<Einzelabrechnung> abrechnungsliste) {
		this.abrechnungsliste = abrechnungsliste;
	}
}
