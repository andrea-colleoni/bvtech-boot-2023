package it.bvtech.boot08.repository;

import org.springframework.stereotype.Repository;

import it.bvtech.boot08.model.User;

@Repository
public class UserRepository {

	public User findUserByEmail(String email){
        User user = new User(email, "123456");
        user.setFirstName("Mario");
        user.setLastName("Rossi");
        return user;
    }
}
