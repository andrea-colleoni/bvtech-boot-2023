package it.bvtech.boot05.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Autore {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAutore;
	@Column(length = 50)
	private String nome;
	@Column(length = 50, name = "altroNome")
	private String cognome;
	
	@Column(nullable = true)
	private Integer numeroDiLibri;
	
	@OneToMany(mappedBy = "autore")
	private List<Libro> libri;

	public Autore() {
		super();
		libri = new ArrayList<>();
	}

	public int getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(int idAutore) {
		this.idAutore = idAutore;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Integer getNumeroDiLibri() {
		return numeroDiLibri;
	}

	public void setNumeroDiLibri(Integer numeroDiLibri) {
		this.numeroDiLibri = numeroDiLibri;
	}

	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
}
