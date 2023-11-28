package it.bvtech.esercizio04.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import it.bvtech.esercizio04.model.Commento;

@RestController
@RequestMapping("/json-test")
@CrossOrigin(origins = { "http://google.com", "http://localhost:4200" })
public class JsonPlaceholderController {

	@Autowired
	RestTemplate rest;
	
	@GetMapping("commenti")
	public ResponseEntity<Commento[]> getCommenti() {
		HttpStatusCode status;
		try {
			ResponseEntity<Commento[]> commenti = rest.getForEntity("https://jsonplaceholder.typicode.com/comments", Commento[].class);
			status = commenti.getStatusCode();
			if (status.is2xxSuccessful()) {
				return ResponseEntity.ok(commenti.getBody());
			} else {
				return ResponseEntity.status(status).build();	
			}
		} catch (RestClientException ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
}
