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
	
	public boolean isAktiv() {
		return aktiv;
	}
	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}
	public Arbeit(int sn,Mitarbeiter ma, GregorianCalendar ab, String aS, boolean g){
		standnummer=sn;
		mitarbeiter=ma;
		arbeitsbeginn=ab;
		abrechnungsStatus=aS;
		geplant=g;
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
		return arbeitsende;
	}
	public void setArbeitsende(GregorianCalendar arbeitsende) {
		this.arbeitsende = arbeitsende;
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
