package br.com.treinamentototvs.treinamentoTotvs.controller;


import br.com.treinamentototvs.treinamentoTotvs.model.dto.FuncoesDTO;
import br.com.treinamentototvs.treinamentoTotvs.service.FuncoesService;
import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@ApiGuideline(ApiGuideline.ApiGuidelineVersion.v1)
@RequestMapping(path = "/funcoes", produces = { MediaType.APPLICATION_JSON_VALUE })
public class FuncoesController {

    @Autowired
    private FuncoesService funcoesService;

    @GetMapping
    public List<FuncoesDTO> listar(){
        return funcoesService.listarFuncoes();
    }
}
