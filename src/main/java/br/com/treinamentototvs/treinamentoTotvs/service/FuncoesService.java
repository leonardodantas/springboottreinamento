package br.com.treinamentototvs.treinamentoTotvs.service;

import br.com.treinamentototvs.treinamentoTotvs.model.Funcoes;
import br.com.treinamentototvs.treinamentoTotvs.model.dto.FuncoesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.treinamentototvs.treinamentoTotvs.repository.FuncoesRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FuncoesService {

	@Autowired
	private FuncoesRepository funcoesRepository;
	
	public List<FuncoesDTO> listarFuncoes(){
		List<Funcoes> funcoes = this.funcoesRepository.findAll();
		return funcoes.stream().map(FuncoesDTO::new).collect(Collectors.toList());
	}
}
