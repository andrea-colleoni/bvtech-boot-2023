package it.bvtech.esercizio03.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bvtech.esercizio03.model.Corso;
import it.bvtech.esercizio03.service.CorsoService;

@RestController
@RequestMapping("/corsi")
public class CorsoController {
	
	@Autowired
	CorsoService service;

	@GetMapping
	public ResponseEntity<List<Corso>> elenco() {
		return ResponseEntity.ok(service.elencoCorsi());
	}
}
