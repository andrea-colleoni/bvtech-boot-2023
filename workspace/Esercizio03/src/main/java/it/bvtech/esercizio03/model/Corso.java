package it.bvtech.esercizio03.model;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Corso {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCorso;
	@Column(length = 100)
	private String titolo;
	@Temporal(TemporalType.DATE)
	private Date dataInizio;

	@ManyToMany
	@JsonIgnore
	private List<Studente> iscritti;
	
	public Integer getIdCorso() {
		return idCorso;
	}

	public void setIdCorso(Integer idStudente) {
		this.idCorso = idStudente;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public List<Studente> getIscritti() {
		return iscritti;
	}

	public void setIscritti(List<Studente> iscritti) {
		this.iscritti = iscritti;
	}

}
