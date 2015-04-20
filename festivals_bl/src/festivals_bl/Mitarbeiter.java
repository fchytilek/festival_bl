package festivals_bl;

import java.util.ArrayList;

public class Mitarbeiter {
	
	private String vorname;
	private String nachname;
	private String username;
	private String passwort;
	
	public Mitarbeiter(String vorname, String nachname, String passwort){
		this.vorname=vorname;
		this.nachname=nachname;
		this.username = vorname.substring(0,1) + nachname;
		this.passwort=passwort;
	}
	
	private ArrayList<Einzelabrechnung> abrechnungsListe = new ArrayList<Einzelabrechnung>();
	
	public ArrayList<Einzelabrechnung> getAbrechnungsListe() {
		return abrechnungsListe;
	}
	public void setAbrechnungsListe(ArrayList<Einzelabrechnung> abrechnungsListe) {
		this.abrechnungsListe = abrechnungsListe;
	}
	
	public String getVorname() {
		return vorname;
	}
	public void setVorname(String vorname) {
		this.vorname = vorname;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswort() {
		return passwort;
	}
	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}
}
