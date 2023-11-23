package it.bvtech.esercizio03.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.bvtech.esercizio03.model.Studente;

@Repository
public interface StudenteRepository extends CrudRepository<Studente, String> {

}
