package it.bvtech.boot05.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.bvtech.boot05.model.Libro;

@Repository
public interface LibroRepository extends CrudRepository<Libro, String> {

}
