package it.alessandro.replicademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.alessandro.replicademo.model.ContoCorrente;
import it.alessandro.replicademo.model.Correntista;
import it.alessandro.replicademo.repository.ContoCorrenteRepository;
import it.alessandro.replicademo.repository.CorrentistaRepository;

@Service
public class ContoCorrenteServiceImpl implements ContoCorrenteService{

	@Autowired
	private ContoCorrenteRepository contoCorrenteRepository;
	
//	@Autowired 
//	private CorrentistaRepository correntistaRepository;

	@Override
	public void salvaContoCorrente(ContoCorrente contoCorrente) {
		// TODO Auto-generated method stub
		this.contoCorrenteRepository.save(contoCorrente);
	}

	@Override
	public ContoCorrente getContoCorrenteById(long id) {
		// TODO Auto-generated method stub
		Optional<ContoCorrente> optional = contoCorrenteRepository.findById(id);
		ContoCorrente contoCorrente= null;
		contoCorrente=optional.get();
		return contoCorrente;
	}

	@Override
	public void cancellaContoCorrenteById(long id) {
		// TODO Auto-generated method stub
		this.contoCorrenteRepository.deleteById(id);
	}

	@Override
	public List<ContoCorrente> getAllContiCorrenti() {
		// TODO Auto-generated method stub
		return contoCorrenteRepository.findAll();
	}

	
	

	
}
