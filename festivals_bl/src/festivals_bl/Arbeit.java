package festivals_bl;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Arbeit {

	private int standnummer;
	private Mitarbeiter mitarbeiter;
	private GregorianCalendar arbeitsbeginn;
	private GregorianCalendar arbeitsende;
	private ArrayList<GregorianCalendar> pausenListe;
	private ArrayList<GregorianCalendar> pausenWunschListe;
	private double arbeitszeit;
	private String abrechnungsStatus;
	private boolean geplant;
	private boolean aktiv=false;
	
	public Arbeit(int sn,Mitarbeiter ma, GregorianCalendar ab, String aS, boolean g){
		standnummer=sn;
		mitarbeiter=ma;
		arbeitsbeginn=ab;
		abrechnungsStatus=aS;
		geplant=g;
		
		
		arbeitsende=null;
		pausenListe=new ArrayList<GregorianCalendar>();
		pausenWunschListe=new ArrayList<GregorianCalendar>();
	}

	public void pauseWuenschen(GregorianCalendar pausenbeginn,GregorianCalendar pausenende){
		pausenWunschListe.add(pausenbeginn);
		pausenWunschListe.add(pausenende);
	}
	
	public void arbeitBearbeiten(int sn, GregorianCalendar ab, GregorianCalendar ae, ArrayList<GregorianCalendar> pL, String aS, boolean g){
		standnummer=sn;
		arbeitsbeginn=ab;
		arbeitsende= ae;
		pausenListe=pL;
		abrechnungsStatus=aS;
		geplant=g;
	}
	
	public boolean isAktiv() {
		return aktiv;
	}
	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}

	public int getStandnummer() {
		return standnummer;
	}
	public void setStandnummer(int standnummer) {
		this.standnummer = standnummer;
	}
	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}
	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
	public GregorianCalendar getArbeitsbeginn() {
		return arbeitsbeginn;
	}
	public void setArbeitsbeginn(GregorianCalendar arbeitsbeginn) {
		this.arbeitsbeginn = arbeitsbeginn;
	}
	public GregorianCalendar getArbeitsende() {
		if(arbeitsende==null)
			return new GregorianCalendar();
		
		return arbeitsende;
	}
	//Wichtig!
	public void setArbeitsende(GregorianCalendar arbeitsende) {
		this.arbeitsende = arbeitsende;
		
		long arbeitszeit = this.arbeitsbeginn.getTimeInMillis()-this.arbeitsende.getTimeInMillis();
		long pausen=0;
		
		for(GregorianCalendar pause : this.pausenListe)
			if( (pausenListe.indexOf(pause)%2) == 0)
				pausen = pausen + pause.getTimeInMillis();
			else
				pausen = pausen - pause.getTimeInMillis();
				
		this.setArbeitszeit((arbeitszeit-pausen)/1000/60);
	}
	public ArrayList<GregorianCalendar> getPausenListe() {
		return pausenListe;
	}
	public void setPausenListe(ArrayList<GregorianCalendar> pausenListe) {
		this.pausenListe = pausenListe;
	}
	public ArrayList<GregorianCalendar> getPausenWunschListe() {
		return pausenWunschListe;
	}
	public void setPausenWunschListe(ArrayList<GregorianCalendar> pausenWunschListe) {
		this.pausenWunschListe = pausenWunschListe;
	}
	public double getArbeitszeit() {
		return arbeitszeit;
	}
	public void setArbeitszeit(double arbeitszeit) {
		this.arbeitszeit = arbeitszeit;
	}
	public String getAbrechnungsStatus() {
		return abrechnungsStatus;
	}
	public void setAbrechnungsStatus(String abrechnungsStatus) {
		this.abrechnungsStatus = abrechnungsStatus;
	}
	public boolean isGeplant() {
		return geplant;
	}
	public void setGeplant(boolean geplant) {
		this.geplant = geplant;
	}
}
