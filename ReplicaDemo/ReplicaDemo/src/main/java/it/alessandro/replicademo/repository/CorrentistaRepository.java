package it.alessandro.replicademo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import it.alessandro.replicademo.model.Correntista;
@Repository
public interface CorrentistaRepository extends JpaRepository<Correntista, Long>{

}
