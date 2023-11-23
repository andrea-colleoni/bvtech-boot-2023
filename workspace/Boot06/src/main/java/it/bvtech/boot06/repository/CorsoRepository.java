package it.bvtech.boot06.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import it.bvtech.boot06.model.Corso;

@Repository
public interface CorsoRepository extends CrudRepository<Corso, Integer> {

}
