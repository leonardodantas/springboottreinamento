package br.com.treinamentototvs.treinamentoTotvs.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.treinamentototvs.treinamentoTotvs.model.Funcionario;
import br.com.treinamentototvs.treinamentoTotvs.model.dto.DetalhesFuncionarioDTO;
import br.com.treinamentototvs.treinamentoTotvs.model.dto.FuncionarioDTO;
import br.com.treinamentototvs.treinamentoTotvs.model.form.FuncionarioForm;
import br.com.treinamentototvs.treinamentoTotvs.service.FuncionarioService;

@RestController
@ApiGuideline(ApiGuideline.ApiGuidelineVersion.v1)
@RequestMapping(path = "/funcionarios", produces = { MediaType.APPLICATION_JSON_VALUE })
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;
	
	@GetMapping
	public List<FuncionarioDTO> listar(){
		return funcionarioService.getAll();
	}
	
	@PostMapping
	public ResponseEntity<FuncionarioDTO> inserirFuncionario(@RequestBody @Valid  FuncionarioForm form, UriComponentsBuilder uriComponentsBuilder){
		Funcionario funcionario = funcionarioService.inserir(form);
		URI uri = uriComponentsBuilder.path("/funcionarios/{id}").buildAndExpand(funcionario.getId()).toUri();
		return ResponseEntity.created(uri).body(new FuncionarioDTO(funcionario));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getOne(@PathVariable Long id){
		
		try {
		
			FuncionarioDTO funcionarioDTO = new FuncionarioDTO(funcionarioService.getOne(id));
			return ResponseEntity.ok(funcionarioDTO);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}
		
	}
	
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		funcionarioService.deletar(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<FuncionarioForm> atualizar(@PathVariable Long id,@RequestBody FuncionarioForm form){
		
		if(funcionarioService.atualizar(form, id))
			return ResponseEntity.ok(form);
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping("/detalhes/{id}")
	public ResponseEntity<?> getDetalhes(@PathVariable Long id){
		
		try {
		
			DetalhesFuncionarioDTO detalhesFuncionario = funcionarioService.detalhesFuncionario(id);
			return ResponseEntity.ok(detalhesFuncionario);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
}
