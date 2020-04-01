package br.com.treinamentototvs.treinamentoTotvs;

import com.totvs.tjf.api.context.stereotype.ApiGuideline;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@ApiGuideline(ApiGuideline.ApiGuidelineVersion.v1)
public class TreinamentoTotvsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TreinamentoTotvsApplication.class, args);
	}

}
