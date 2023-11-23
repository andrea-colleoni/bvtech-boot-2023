package it.bvtech.esercizio03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bvtech.esercizio03.model.Studente;
import it.bvtech.esercizio03.service.StudenteService;

@RestController
@RequestMapping("/studenti")
public class StudenteController {

	@Autowired
	StudenteService service;

	@GetMapping
	public ResponseEntity<List<Studente>> elenco() {
		return ResponseEntity.ok(service.elencoStudenti());
	}
}
