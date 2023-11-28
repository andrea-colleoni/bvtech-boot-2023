package it.bvtech.boot08.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import it.bvtech.boot08.model.User;
import it.bvtech.boot08.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = repository.findUserByEmail(username);
		List<String> ruoli = new ArrayList<>();
		ruoli.add("USER");
		UserDetails details = org.springframework.security.core.userdetails.User.builder()
				.username(username).password(user.getPassword())
				.roles(ruoli.toArray(new String[0]))
				.build();
		return details;
	}

}
