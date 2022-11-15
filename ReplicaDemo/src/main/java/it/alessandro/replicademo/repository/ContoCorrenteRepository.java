package it.alessandro.replicademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.alessandro.replicademo.model.ContoCorrente;
import it.alessandro.replicademo.model.Correntista;

@Repository
public interface ContoCorrenteRepository extends JpaRepository<ContoCorrente, Long> {
	List<ContoCorrente> findAllByCorrentista(Correntista correntista);
}
