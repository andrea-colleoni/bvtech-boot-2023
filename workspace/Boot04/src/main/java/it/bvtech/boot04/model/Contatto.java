package it.bvtech.boot04.model;

public class Contatto {
	
	private String email;
	private String nome;
	private String cognome;
	private String numeroTelefono;
	
	public Contatto(String email, String nome, String cognome, String numeroTelefono) {
		super();
		this.email = email;
		this.nome = nome;
		this.cognome = cognome;
		this.numeroTelefono = numeroTelefono;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
}
