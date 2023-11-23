package it.bvtech.boot06.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Studente {

	@Id
	@Column(length = 20)
	private String matricola;
	@Column(length = 50)
	private String nome;
	@Column(length = 50)
	private String cognome;
	
	@ManyToMany(mappedBy = "iscritti")
	private List<Corso> pianoDiStudi;

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
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

	public List<Corso> getPianoDiStudi() {
		return pianoDiStudi;
	}

	public void setPianoDiStudi(List<Corso> pianoDiStudi) {
		this.pianoDiStudi = pianoDiStudi;
	}

}
