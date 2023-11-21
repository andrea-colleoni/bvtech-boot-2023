package it.bvtech.esercizio02.model;

import java.util.ArrayList;
import java.util.List;

public class Cache {
	
	private static List<Studente> studenti;
	private static List<Corso> corsi;
	
	static {
		studenti = new ArrayList<>();
		corsi = new ArrayList<>();
		
		studenti.add(new Studente("Anna", "Verdi"));
		studenti.add(new Studente("Luigi", "Bianci"));
		studenti.add(new Studente("Maria", "Rossi"));
		
		corsi.add(new Corso("Spring"));
		corsi.add(new Corso("C#"));
	}

	public static List<Studente> getStudenti() {
		return studenti;
	}
	
	public static List<Corso> getCorsi() {
		return corsi;
	}	
}
