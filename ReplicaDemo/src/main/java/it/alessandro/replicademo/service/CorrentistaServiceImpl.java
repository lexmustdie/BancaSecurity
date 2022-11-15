package it.alessandro.replicademo.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.alessandro.replicademo.repository.CorrentistaRepository;

import it.alessandro.replicademo.model.Correntista;

@Service
public class CorrentistaServiceImpl implements CorrentistaService{

	@Autowired
	private CorrentistaRepository correntistaRepository;
	
	
	

	@Override
	public Correntista getCorrentistaById(long id) {
		// TODO Auto-generated method stub
		Optional<Correntista> optional = correntistaRepository.findById(id);
		Correntista correntista= null;
		correntista=optional.get();
		return correntista;
		
	}

	@Override
	public void cancellaCorrentistaById(long id) {
		// TODO Auto-generated method stub
		this.correntistaRepository.deleteById(id);
	}


	@Override
	public List<Correntista> getAllCorrentisti() {
		// TODO Auto-generated method stub
		return correntistaRepository.findAll();
	}

	@Override
	public void salvaCorrentista(Correntista correntista) {
		// TODO Auto-generated method stub
		this.correntistaRepository.save(correntista);
	}

}
