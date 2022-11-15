 package it.alessandro.replicademo.service;

import java.util.List;

import it.alessandro.replicademo.model.ContoCorrente;
import it.alessandro.replicademo.model.Correntista;

public interface ContoCorrenteService {
	
	List<ContoCorrente> getAllContiCorrenti();
	void salvaContoCorrente(ContoCorrente contoCorrente);
	ContoCorrente getContoCorrenteById(long id);
	void cancellaContoCorrenteById(long id);
	
	
}