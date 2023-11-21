package it.bvtech.boot05.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bvtech.boot05.model.Autore;
import it.bvtech.boot05.model.Libro;
import it.bvtech.boot05.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	LibroRepository repository;

	public List<Libro> elenco() {
		List<Libro> libri = new ArrayList<>();
		repository.findAll().forEach(l -> libri.add(l));
		return libri;
	}
	
	public void aggiungi(Libro libro) {
		repository.save(libro);
	}
	
	public void aggiungiAutoreALibro(Autore autore, Libro libro) {
		libro.setAutore(autore);
		//autore.getLibri().add(libro);
		repository.save(libro);
	}
}
