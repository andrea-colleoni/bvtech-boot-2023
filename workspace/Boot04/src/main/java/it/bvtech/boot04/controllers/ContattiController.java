package it.bvtech.boot04.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.bvtech.boot04.model.CacheContatti;
import it.bvtech.boot04.model.Contatto;

@RestController
@RequestMapping(value = { "/contatti", "/contacts" })
public class ContattiController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContattiController.class);
	
	@Value("${app.nome:Sconosciuto}")
	private String nomeApplicazione;
	
	@GetMapping
	public List<Contatto> elencoContatti() {
		logger.info(nomeApplicazione + ": GET elenco contatti");
		return CacheContatti.all();
	}

	@PutMapping("/{email}")
	public ResponseEntity<Object> aggiorna(@PathVariable String email, @RequestBody Contatto contatto) {
		logger.info(nomeApplicazione + ": PUT modifica contatto " + email);
		Contatto elemento = CacheContatti.all().stream()
				.filter(c -> c.getEmail().equalsIgnoreCase(email))
				.findFirst()
				.orElse(null);
		// verifica se presente
		if(elemento == null) {
			return new ResponseEntity<>("Contatto non trovato", HttpStatus.NOT_FOUND);
		}
		// modifica
		CacheContatti.all().remove(elemento);
		CacheContatti.all().add(contatto);
		return new ResponseEntity<>(contatto, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Object> crea(@RequestBody Contatto contatto) {
		logger.info("POST inserimento nuovo contatto");
		Contatto elemento = CacheContatti.all().stream()
				.filter(c -> c.getEmail().equalsIgnoreCase(contatto.getEmail()))
				.findFirst()
				.orElse(null);
		// verifica se presente
		if(elemento != null) {
			return new ResponseEntity<>("Il contatto esiste già", HttpStatus.BAD_REQUEST);
		}
		// aggiunta
		CacheContatti.all().add(contatto);
		return new ResponseEntity<>(contatto, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{email}")
	public ResponseEntity<Object> aggiorna(@PathVariable String email) {
		logger.info("DELETE eliminazione contatto " + email);
		Contatto elemento = CacheContatti.all().stream()
				.filter(c -> c.getEmail().equalsIgnoreCase(email))
				.findFirst()
				.orElse(null);
		// verifica se presente
		if(elemento == null) {
			return new ResponseEntity<>("Contatto non trovato", HttpStatus.NOT_FOUND);
		}
		// modifica
		CacheContatti.all().remove(elemento);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
