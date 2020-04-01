package br.com.treinamentototvs.treinamentoTotvs.model;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Funcionario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotNull @NotEmpty @Size(min=10)
	private String nome;
	
	@NotNull @NotEmpty @Size(min=10)
	private String email;
	
	@NotNull @NotEmpty @Size(min=10)
	private String cpf;
	
	
	private Calendar dataNascimento;
	
	public Funcionario() {
		// TODO Auto-generated constructor stub
	}
	
	@ManyToOne  
	@JoinColumn(name="funcao_id")
	private Funcoes funcoes;
	
	
	public Funcionario(String nome,String email, String cpf,Calendar dataNascimento,
			Funcoes funcoes) {
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.funcoes = funcoes;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public Funcoes getFuncoes() {
		return funcoes;
	}
	public void setFuncoes(Funcoes funcoes) {
		this.funcoes = funcoes;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public Calendar getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	
}
