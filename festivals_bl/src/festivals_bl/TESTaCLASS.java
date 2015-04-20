package festivals_bl;

import java.util.GregorianCalendar;

public class TESTaCLASS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//VeranstaltungsVerwaltungSingleton.getInstance().veranstaltungHinzufuegen(new);
		MitarbeiterVerwaltungSingleton mv= new MitarbeiterVerwaltungSingleton().getInstance();
		mv.mitarbeiterHinzufuegen(new Mitarbeiter("Wolfi", "Erler", "pw1"));
		mv.mitarbeiterHinzufuegen(new Mitarbeiter("Fla", "Chytilex", "pw1"));
		
		VeranstaltungsVerwaltungSingleton vv=new VeranstaltungsVerwaltungSingleton().getInstance();
		
	}

}
