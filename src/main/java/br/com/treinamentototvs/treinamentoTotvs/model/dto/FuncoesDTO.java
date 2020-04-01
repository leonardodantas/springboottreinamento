package br.com.treinamentototvs.treinamentoTotvs.model.dto;

import br.com.treinamentototvs.treinamentoTotvs.model.Funcoes;

public class FuncoesDTO {

	Long id;
	String nomeFuncao;
	double salarioBase;

	public Long getId(){ return id;}
	public String getNomeFuncao() {
		return nomeFuncao;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public FuncoesDTO(Funcoes funcoes) {
		// TODO Auto-generated constructor stub
		this.id = funcoes.getId();
		this.nomeFuncao = funcoes.getNomeFuncao();
		this.salarioBase = funcoes.getSalarioBase();
	}
	
	
}
