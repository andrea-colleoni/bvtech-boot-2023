package it.bvtech.boot05;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import it.bvtech.boot05.model.Autore;
import it.bvtech.boot05.model.Libro;
import it.bvtech.boot05.service.LibroService;

@SpringBootTest
public class LibroServiceTest {
	
	@Autowired
	LibroService service;
	
	@Test
	public void testElencoLibri() {
		List<Libro> libri = service.elenco();
	}
	
	@Test
	public void testAutoreLibro() {
		Libro libro = new Libro();
		libro.setTitolo("IT");
		service.aggiungi(libro);
		
		Autore autore = new Autore();
		autore.setNome("Stephen");
		autore.setCognome("King");
		
		service.aggiungiAutoreALibro(autore, libro);
	}

}
