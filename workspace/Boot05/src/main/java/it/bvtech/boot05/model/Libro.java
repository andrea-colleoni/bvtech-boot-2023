package it.bvtech.boot05.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {
	
	@Id	
	private String titolo;
	
	@ManyToOne(cascade =  { CascadeType.PERSIST, CascadeType.MERGE })
	private Autore autore;
	
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Autore getAutore() {
		return autore;
	}
	public void setAutore(Autore autore) {
		this.autore = autore;
	}
}
