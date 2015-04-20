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
//	public void standHinzufügen(Stand stand){
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
}
