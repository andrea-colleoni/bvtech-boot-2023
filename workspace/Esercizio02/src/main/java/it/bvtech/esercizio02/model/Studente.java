package it.bvtech.esercizio02.model;

public class Studente {
	
	private String nome;
	private String cognnome;
	
	
	public Studente(String nome, String cognnome) {
		super();
		this.nome = nome;
		this.cognnome = cognnome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCognnome() {
		return cognnome;
	}
	public void setCognnome(String cognnome) {
		this.cognnome = cognnome;
	}
	
	

}
