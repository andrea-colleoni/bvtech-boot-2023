package it.bvtech.esercizio03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bvtech.esercizio03.model.Studente;
import it.bvtech.esercizio03.repository.StudenteRepository;

@Service
public class StudenteService {

	@Autowired
	StudenteRepository repository;
	
	public List<Studente> elencoStudenti() {
		List<Studente> studenti = new ArrayList<>();
		repository.findAll().forEach(s -> studenti.add(s));
		return studenti;
	}
}
