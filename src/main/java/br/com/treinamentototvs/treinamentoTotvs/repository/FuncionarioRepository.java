package br.com.treinamentototvs.treinamentoTotvs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.treinamentototvs.treinamentoTotvs.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> { 

	@Query("SELECT f FROM Funcionario f where f.id = :idFuncionario")
	Funcionario detalhesFuncionario(@Param("idFuncionario") Long idFuncionario);
	
}
