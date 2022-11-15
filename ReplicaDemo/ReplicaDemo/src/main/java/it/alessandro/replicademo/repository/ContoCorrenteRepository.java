package it.alessandro.replicademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.alessandro.replicademo.model.ContoCorrente;

@Repository
public interface ContoCorrenteRepository extends JpaRepository<ContoCorrente, Long> {

}
