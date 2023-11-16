package it.bvtech.corsospring;

public class App {

	public static void main(String[] args) {
		
		// di queste cose si occupa l'ApplicationContext di spring
		
		// fase di creazione degli oggetti
		var a = new A(); // var si può usare da Java 11
		var b = new B();
		
		// wiring (o injection)
		a.b = b; 
		
		// fino a qui
		
		a.faiQualcosa();
	}
}
