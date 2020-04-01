package br.com.treinamentototvs.treinamentoTotvs.model.dto;

import java.util.Calendar;

import br.com.treinamentototvs.treinamentoTotvs.model.Funcionario;

public class FuncionarioDTO {

	private Long id;
	private String nome;
	private Calendar dataNascimento;
	private String funcao;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	private String email;
	 
	public FuncionarioDTO(Funcionario funcionario) {
		// TODO Auto-generated constructor stub
		this.nome = funcionario.getNome();
		this.dataNascimento = funcionario.getDataNascimento();
		this.funcao = funcionario.getFuncoes().getNomeFuncao();
		this.email = funcionario.getEmail();
	}

	public String getNome() {
		return nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public String getFuncao() {
		return funcao;
	}



}
