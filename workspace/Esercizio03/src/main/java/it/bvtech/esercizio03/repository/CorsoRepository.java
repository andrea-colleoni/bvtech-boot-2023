package it.bvtech.esercizio03.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import it.bvtech.esercizio03.model.Corso;

@Repository
public interface CorsoRepository extends CrudRepository<Corso, Integer> {
	
	List<Corso> findByTitolo(String titolo);
	
	// jpql
	@Query("select c from Corso c where c.idCorso = :id")
	Corso corsoPerId(@Param("id") Integer id);
	
	// mysql
	@Query(value = "select * from corso limit 1", nativeQuery = true)
	Corso primoCorso();
	
	// modifca di dati
	@Transactional
	@Query("update c from Corso c set c.titolo = ?2 where c.idCorso = ?1")
	void modificaTitolo(Integer id, String nuovoTitolo);

}
