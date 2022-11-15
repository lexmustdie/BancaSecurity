package it.alessandro.replicademo.service;


import java.util.List;

import it.alessandro.replicademo.model.Correntista;

public interface CorrentistaService {
	
	List<Correntista> getAllCorrentisti();
	void salvaCorrentista(Correntista correntista);
	Correntista getCorrentistaById(long id);
	void cancellaCorrentistaById(long id);
	
}
