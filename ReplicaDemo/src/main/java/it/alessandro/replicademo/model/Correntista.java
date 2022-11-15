package it.alessandro.replicademo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;





@Entity
@Table( name =  "correntista")

public class Correntista {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column ( name = "nome")
	private String nome;
	@Column ( name = "cognome")
	private String cognome;
	@Column ( name = "cf")
	private String cf;
	
	@OneToMany(mappedBy = "correntista")
	//@JoinColumn(name="id_correntista")
	private Set<ContoCorrente> contoCorrente = new HashSet<ContoCorrente>();
	
	public Set<ContoCorrente> getContoCorrente() {
		return contoCorrente;
	}

	public void setContoCorrente(Set<ContoCorrente> contoCorrente) {
		this.contoCorrente = contoCorrente;
	}
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCf() {
		return cf;
	}

	public void setCf(String cf) {
		this.cf = cf;
	}

	
	
	
	
	
}
