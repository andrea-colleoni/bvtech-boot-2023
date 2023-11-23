package it.bvtech.boot07.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import it.bvtech.boot07.model.Post;

@RestController
@RequestMapping("/client")
public class RestClientController {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<Post[]> getElencoPost() {
		try {
			ResponseEntity<Post[]> posts = restTemplate.getForEntity(new URI("https://jsonplaceholder.typicode.com/posts"), Post[].class);
			
			return ResponseEntity.ok(posts.getBody());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
}
