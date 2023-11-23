package it.bvtech.esercizio03.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.bvtech.esercizio03.model.Corso;
import it.bvtech.esercizio03.repository.CorsoRepository;

@Service
public class CorsoService {

	@Autowired
	CorsoRepository repository;
	
	public List<Corso> elencoCorsi() {
		List<Corso> corsi = new ArrayList<>();
		repository.findAll().forEach(c -> corsi.add(c));		
		return corsi;
	}
}
