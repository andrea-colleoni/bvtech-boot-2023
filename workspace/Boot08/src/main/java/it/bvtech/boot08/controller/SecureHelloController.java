package it.bvtech.boot08.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/secure/hello")
@CrossOrigin(origins = "*", maxAge = 360000)
public class SecureHelloController {

	@GetMapping
	public ResponseEntity<String> hello() {
		return ResponseEntity.ok("hello");
	}
}
