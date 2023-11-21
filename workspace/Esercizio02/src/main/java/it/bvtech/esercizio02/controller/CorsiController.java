package it.bvtech.esercizio02.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bvtech.esercizio02.model.Cache;
import it.bvtech.esercizio02.model.Corso;
import it.bvtech.esercizio02.model.Studente;

@RestController
@RequestMapping("/corsi")
public class CorsiController {
	
	@GetMapping
	public ResponseEntity<List<Corso>> all() {
		return ResponseEntity.ok(Cache.getCorsi());
	}
	
	@PostMapping("{titolo}/studenti")
	public ResponseEntity<?> aggiungiStudenteACorso(
			@PathVariable("titolo") String titolo, 
			@RequestBody Studente studente
			) {
		Corso corso = Cache.getCorsi().stream()
				.filter(c -> c.getTitolo().equalsIgnoreCase(titolo))
				.findFirst()
				.orElse(null);
		corso.getIscritti().add(studente);
		return ResponseEntity.ok(null);
	}

}
