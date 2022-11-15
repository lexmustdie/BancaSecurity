package it.alessandro.replicademo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import it.alessandro.replicademo.model.Correntista;
import it.alessandro.replicademo.service.ContoCorrenteService;
import it.alessandro.replicademo.service.CorrentistaService;



@Controller
public class CorrentistaController {

	@Autowired
	private CorrentistaService correntistaService;
	@Autowired
	private ContoCorrenteService contoCorrenteService;
	
	@GetMapping ( "/" )
	public String viewHomePage (Model model) {
		
		model.addAttribute("listaContiCorrenti", contoCorrenteService.getAllContiCorrenti());

		model.addAttribute("listaCorrentisti", correntistaService.getAllCorrentisti());
		return "index";
		
	}
	
	@GetMapping ("/showNewCorrentistaForm")
	public String showNewCorrentistaForm(Model model) {
		
			Correntista correntista = new Correntista ();
			model.addAttribute("correntista", correntista);
			return "nuovo_correntista";
	}
	
	@PostMapping("/salvaCorrentista")
	public String salvaCorrentista(@ModelAttribute("Correntista") Correntista correntista) {
	
		correntistaService.salvaCorrentista(correntista);
	    return "redirect:/";
	}
	
	@GetMapping ("/showModificaCorrentistaForm/{id}")
	public String showModificaCorrentistaForm(@PathVariable ( value = "id") long id , Model model) {
		
		Correntista correntista = correntistaService.getCorrentistaById(id);
		
		model.addAttribute("correntista" , correntista);
		return "modifica_correntista";
		
		
	}
	
	@GetMapping ("/cancellazioneCorrentista/{id}")
	public String cancellaCorrentista(@PathVariable ( value = "id" ) long id , Model model) {
		
		this.correntistaService.cancellaCorrentistaById(id);
		return "redirect:/";
	}
	
}
