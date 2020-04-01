package br.com.treinamentototvs.treinamentoTotvs.model.form;

import java.util.Calendar;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.treinamentototvs.treinamentoTotvs.model.Funcionario;
import br.com.treinamentototvs.treinamentoTotvs.model.Funcoes;

public class FuncionarioForm {

	@NotEmpty @NotNull @Length(min=5)
	private String nome; 
	
	private Calendar dataNascimento = Calendar.getInstance();
	@NotEmpty @NotNull @Length(min=5)
	private String email;

	private Long idFuncao;
	@NotEmpty @NotNull @Length(min=11)
	private String cpf;

	
	
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
	public Long getIdFuncao() {
		return idFuncao;
	}
	public void setIdFuncao(Long idFuncao) {
		this.idFuncao = idFuncao;
	}
	
	public Funcionario converter(Funcoes funcao) {
		// TODO Auto-generated method stub
		return new Funcionario(nome, email, cpf, dataNascimento, funcao);
	}
	
	
}
