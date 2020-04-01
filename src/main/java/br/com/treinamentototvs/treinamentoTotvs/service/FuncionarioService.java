package br.com.treinamentototvs.treinamentoTotvs.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamentototvs.treinamentoTotvs.model.Funcionario;
import br.com.treinamentototvs.treinamentoTotvs.model.Funcoes;
import br.com.treinamentototvs.treinamentoTotvs.model.dto.DetalhesFuncionarioDTO;
import br.com.treinamentototvs.treinamentoTotvs.model.dto.FuncionarioDTO;
import br.com.treinamentototvs.treinamentoTotvs.model.form.FuncionarioForm;
import br.com.treinamentototvs.treinamentoTotvs.repository.FuncionarioRepository;
import br.com.treinamentototvs.treinamentoTotvs.repository.FuncoesRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;
	
	@Autowired
	private FuncoesRepository funcoesRepository;
	
	public List<FuncionarioDTO> getAll() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		return funcionarios.stream().map(FuncionarioDTO::new).collect(Collectors.toList());
	}
	
	@Transactional
	public Funcionario inserir(FuncionarioForm funcionarioForm) {
		
		Funcoes funcao = funcoesRepository.getOne(funcionarioForm.getIdFuncao());
		System.out.println(funcao);
		if(funcao != null) {
			Funcionario funcionario = funcionarioForm.converter(funcao);
			funcionarioRepository.save(funcionario);
			return funcionario;
		}
		return null;
	}
	
	public Funcionario getOne(Long id) {
		Optional<Funcionario> funcionario = funcionarioRepository.findById(id);
		if(funcionario.isPresent())
				return funcionario.get();
		return null;
		
	}
	
	@Transactional
	public boolean atualizar(FuncionarioForm form, Long id) {
		try {
			Funcionario funcionario = this.getOne(id);
			funcionario.setEmail(form.getEmail());
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	@Transactional
	public void deletar(Long id) {
		Funcionario funcionario = this.getOne(id);
		if(funcionario != null) 
			funcionarioRepository.delete(funcionario);		
	}
	
	public DetalhesFuncionarioDTO detalhesFuncionario(Long id) {
		Funcionario funcionario = funcionarioRepository.detalhesFuncionario(id);
		DetalhesFuncionarioDTO detalhesFuncionarioDTO = new DetalhesFuncionarioDTO(funcionario);
		return detalhesFuncionarioDTO;
	}
	
	
}
