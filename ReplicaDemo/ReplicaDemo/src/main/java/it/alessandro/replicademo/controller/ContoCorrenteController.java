package it.alessandro.replicademo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import it.alessandro.replicademo.service.ContoCorrenteService;
import it.alessandro.replicademo.service.CorrentistaService;
import it.alessandro.replicademo.model.ContoCorrente;

@Controller
public class ContoCorrenteController {
	
	@Autowired
	private ContoCorrenteService contoCorrenteService;
	@Autowired
	private CorrentistaService correntistaService;
	
	@GetMapping ("/showNewContoCorrenteForm")
	public String showNewContoCorrenteForm(Model model) {
		
			ContoCorrente contoCorrente = new ContoCorrente();
			model.addAttribute("ContoCorrente", contoCorrente);
			
			model.addAttribute("listaContiCorrenti", contoCorrenteService.getAllContiCorrenti());
			model.addAttribute("listaCorrentisti", correntistaService.getAllCorrentisti());
			return "nuovo_conto_corrente";
	}
	
	@PostMapping("/salvaContoCorrente")
	public String salvaContoCorrente(@ModelAttribute("ContoCorrente") ContoCorrente ContoCorrente) {
	
		contoCorrenteService.salvaContoCorrente(ContoCorrente);
	    return "redirect:/";
	}
	
	@GetMapping ("/showPrelievoContoCorrenteForm/{id}")
	public String showPrelievoContoCorrenteForm(@PathVariable ( value = "id") long id , Model model) {
		
		ContoCorrente contoCorrente = contoCorrenteService.getContoCorrenteById(id);
		
		model.addAttribute("contoCorrente" , contoCorrente);
		
		return "prelievo_conto_corrente";
		
		
	}
	
	
	
	@GetMapping ("/cancellazioneContoCorrente/{id}")
	public String cancellaContoCorrente(@PathVariable ( value = "id" ) long id , Model model) {
		
		this.contoCorrenteService.cancellaContoCorrenteById(id);
		return "redirect:/";
	}
}
