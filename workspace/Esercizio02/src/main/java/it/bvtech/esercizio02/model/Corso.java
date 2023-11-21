package it.bvtech.esercizio02.model;

import java.util.ArrayList;
import java.util.List;

public class Corso {

	private String titolo;
	
	private List<Studente> iscritti;

	public Corso(String titolo) {
		super();
		this.titolo = titolo;
		this.iscritti = new ArrayList<>();
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public List<Studente> getIscritti() {
		return iscritti;
	}

	public void setIscritti(List<Studente> iscritti) {
		this.iscritti = iscritti;
	}
	
}
