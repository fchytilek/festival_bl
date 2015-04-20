package festivals_bl;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Hashtable;

public class Veranstaltung {
	private int vid;
	private String name;
	private GregorianCalendar anfangsDatum;
	private GregorianCalendar endDatum;
	private Mitarbeiter erstelltVon;
//	private ArrayList<Stand> standliste;
	private ArrayList<Mitarbeiter> mitarbeiterGesamt;
	private ArrayList<Mitarbeiter> mitarbeiterAbgeschlossen;
	private ArrayList<Mitarbeiter> mitarbeiterAusbezahlt;
//	private Veranstaltungsabrechnung abrechnung;
	private Hashtable<Mitarbeiter, String> statusliste;
	private Hashtable<String, Double> verdienstliste;
//	public void standHinzuf�gen(Stand stand){
/*	public boolean standLoeschen(Stand stand){
		
	}*/
	public void mitarbeiterStandZuteilen(int standnummer,ArrayList<Mitarbeiter> mitarbeiterliste){
		
		
	}
	public boolean mitarbeiterVerschieben(Mitarbeiter ma, int standVon, int standZu){
		return true;
	}
	public void statusAendern(Mitarbeiter ma, String status){
		
	}
	public boolean arbeitBeginnen(int standnummer,ArrayList<Mitarbeiter> mitarbeiterliste,GregorianCalendar arbeitsbeginn, String abrechnungsStatus){
		return true;
	}
	public void pauseHinzufuegen(ArrayList<Mitarbeiter> mitarbeiterliste,GregorianCalendar pausenbeginn, GregorianCalendar pausenende){
		
	}
	
	public void arbeitHinzufuegen(int standnummer,ArrayList<Mitarbeiter> mitarbeiterliste, GregorianCalendar arbeitsbeginn, GregorianCalendar arbeitsende, ArrayList<GregorianCalendar> pausenliste, String abrechnungsStatus, boolean geplant){
		
	}
	
	public boolean arbeitBeenden(ArrayList<Mitarbeiter> mitarbeiterliste, GregorianCalendar arbeitsende){
		return true;
	}
	public boolean mitarbeiterAbschliessen(Mitarbeiter ma){
		return true;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public GregorianCalendar getAnfangsDatum() {
		return anfangsDatum;
	}
	public void setAnfangsDatum(GregorianCalendar anfangsDatum) {
		this.anfangsDatum = anfangsDatum;
	}
	public GregorianCalendar getEndDatum() {
		return endDatum;
	}
	public void setEndDatum(GregorianCalendar endDatum) {
		this.endDatum = endDatum;
	}
	public Mitarbeiter getErstelltVon() {
		return erstelltVon;
	}
	public void setErstelltVon(Mitarbeiter erstelltVon) {
		this.erstelltVon = erstelltVon;
	}
	public ArrayList<Mitarbeiter> getMitarbeiterGesamt() {
		return mitarbeiterGesamt;
	}
	public void setMitarbeiterGesamt(ArrayList<Mitarbeiter> mitarbeiterGesamt) {
		this.mitarbeiterGesamt = mitarbeiterGesamt;
	}
	public ArrayList<Mitarbeiter> getMitarbeiterAbgeschlossen() {
		return mitarbeiterAbgeschlossen;
	}
	public void setMitarbeiterAbgeschlossen(
			ArrayList<Mitarbeiter> mitarbeiterAbgeschlossen) {
		this.mitarbeiterAbgeschlossen = mitarbeiterAbgeschlossen;
	}
	public ArrayList<Mitarbeiter> getMitarbeiterAusbezahlt() {
		return mitarbeiterAusbezahlt;
	}
	public void setMitarbeiterAusbezahlt(
			ArrayList<Mitarbeiter> mitarbeiterAusbezahlt) {
		this.mitarbeiterAusbezahlt = mitarbeiterAusbezahlt;
	}
	public Hashtable<Mitarbeiter, String> getStatusliste() {
		return statusliste;
	}
	public void setStatusliste(Hashtable<Mitarbeiter, String> statusliste) {
		this.statusliste = statusliste;
	}
	public Hashtable<String, Double> getVerdienstliste() {
		return verdienstliste;
	}
	public void setVerdienstliste(Hashtable<String, Double> verdienstliste) {
		this.verdienstliste = verdienstliste;
	}
}
