package br.com.treinamentototvs.treinamentoTotvs.model.dto;

import br.com.treinamentototvs.treinamentoTotvs.model.Funcionario;

public class DetalhesFuncionarioDTO {

	private String nome;
	private String email;
	private String funcao;
	private double salario;
	
	public DetalhesFuncionarioDTO(Funcionario funcionario) {
		// TODO Auto-generated constructor stub
		this.nome = funcionario.getNome();
		this.email = funcionario.getEmail();
		this.funcao = funcionario.getFuncoes().getNomeFuncao();
		this.salario = funcionario.getFuncoes().getSalarioBase();
	}
	
	public String getNome() {
		return nome;
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
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	
	
}
