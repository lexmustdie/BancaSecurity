package it.alessandro.replicademo.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.alessandro.replicademo.service.ContoCorrenteService;
import it.alessandro.replicademo.service.ContoCorrenteServiceImpl;
import it.alessandro.replicademo.service.CorrentistaService;

import it.alessandro.replicademo.model.ContoCorrente;
import it.alessandro.replicademo.model.Correntista;

@Controller
public class ContoCorrenteController {
	
	private double prelievo;
	private double versamento;
	
	@Autowired
	private ContoCorrenteService contoCorrenteService;
	@Autowired
	private CorrentistaService correntistaService;
	
	@GetMapping ("/showContiCorrenti/{id}")
	public String showContiCorrenti (@PathVariable (value= "id") long id_correntista, Model model) {
		
		Correntista correntista = correntistaService.getCorrentistaById(id_correntista);
		model.addAttribute("listaContiCorrenti", contoCorrenteService.findAllByCorrentista(correntista));

		model.addAttribute("listaCorrentisti", correntistaService.getAllCorrentisti());
		return "mostra_conti_correnti";
		
	}
	
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
		
		model.addAttribute("ContoCorrente" , contoCorrente);
		return "prelievo";
		
	}
	
	@PostMapping("/prelievoContoCorrente")
	public String prelievoContoCorrente(@ModelAttribute("ContoCorrente") ContoCorrente ContoCorrente, HttpServletRequest request, double saldo){
	
	double prelievo=Double.parseDouble(request.getParameter("prelievo"));
	
	  double saldoagg=saldo-prelievo;
		
		ContoCorrente.setSaldo(saldoagg);
		contoCorrenteService.salvaContoCorrente(ContoCorrente);
		return "redirect:/";
	}
	
	@GetMapping ("/showVersamentoContoCorrenteForm/{id}")
	public String showVersamentoContoCorrenteForm(@PathVariable ( value = "id") long id , Model model) {
		
		ContoCorrente contoCorrente = contoCorrenteService.getContoCorrenteById(id);
		
		model.addAttribute("ContoCorrente" , contoCorrente);
		return "versamento";
		
	}
	
	@PostMapping("/versamentoContoCorrente")
	public String versamentoContoCorrente(@ModelAttribute("ContoCorrente") ContoCorrente ContoCorrente, HttpServletRequest request, double saldo){
	
	double versamento=Double.parseDouble(request.getParameter("versamento"));
	
	  double saldoagg=saldo+versamento;
		
		ContoCorrente.setSaldo(saldoagg);
		contoCorrenteService.salvaContoCorrente(ContoCorrente);
		return "redirect:/";
	}
	
	@GetMapping ("/cancellazioneContoCorrente/{id}")
	public String cancellaContoCorrente(@PathVariable ( value = "id" ) long id , Model model) {
		
		this.contoCorrenteService.cancellaContoCorrenteById(id);
		return "redirect:/";
	}
}
