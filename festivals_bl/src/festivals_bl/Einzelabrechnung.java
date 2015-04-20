package festivals_bl;

import java.util.ArrayList;

public class Einzelabrechnung {
	
	private Mitarbeiter mitarbeiter;
	private int vid;
	private ArrayList<Arbeit> arbeitsListe;
	private double anreisekosten;
	private String anreiseKommentar;
	private boolean aktiv;
	private boolean anreiseBestaetigt;
	
	public void arbeitHinzufuegen(Arbeit arb){
		this.arbeitsListe.add(arb);
		
	}
	public void arbeitLoeschen(Arbeit arb){
		this.arbeitsListe.remove(arb);
	}
	public void anreisekostenAngeben(double kosten, String kommentar){
		anreisekosten=kosten;
		anreiseKommentar=kommentar;
		anreiseBestaetigt=false;
		
	}
	public void anreisekostenBestaetigen(){
		anreiseBestaetigt=true;
		
	}
	public void anreisekostenKorrigieren(double kosten, String kommentar){
		anreisekosten=kosten;
		anreiseKommentar=kommentar;
		anreiseBestaetigt=true;
	}
	public Mitarbeiter getMitarbeiter() {
		return mitarbeiter;
	}
	public void setMitarbeiter(Mitarbeiter mitarbeiter) {
		this.mitarbeiter = mitarbeiter;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public ArrayList<Arbeit> getArbeitsliste() {
		return arbeitsListe;
	}
	public void setArbeitsliste(ArrayList<Arbeit> arbeitsliste) {
		this.arbeitsListe = arbeitsliste;
	}
	public double getAnreisekosten() {
		return anreisekosten;
	}
	public void setAnreisekosten(double anreisekosten) {
		this.anreisekosten = anreisekosten;
	}
	public String getAnreiseKommentar() {
		return anreiseKommentar;
	}
	public void setAnreiseKommentar(String anreiseKommentar) {
		this.anreiseKommentar = anreiseKommentar;
	}
	public boolean isAktiv() {
		return aktiv;
	}
	public void setAktiv(boolean aktiv) {
		this.aktiv = aktiv;
	}
	public boolean isAnreiseBestaetigt() {
		return anreiseBestaetigt;
	}
	public void setAnreiseBestaetigt(boolean anreiseBestaetigt) {
		this.anreiseBestaetigt = anreiseBestaetigt;
	}
}
