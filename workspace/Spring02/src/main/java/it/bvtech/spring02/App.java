package it.bvtech.spring02;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext( "it.bvtech.spring02" ) ;
		
		AltraClasse ac = ctx.getBean(AltraClasse.class);
		ac.metodo();
		
		// ricerca nel contexxt per interfaccia
		Messaggero ms = ctx.getBean(Messaggero.class);
		ms.stampareMessaggio("programma principale");
	}
}
