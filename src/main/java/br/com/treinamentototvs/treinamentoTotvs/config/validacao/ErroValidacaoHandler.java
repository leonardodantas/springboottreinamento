package br.com.treinamentototvs.treinamentoTotvs.config.validacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
 
@RestControllerAdvice
public class ErroValidacaoHandler {

	@Autowired
	private MessageSource messageSource;
	
	@ResponseStatus(code = HttpStatus.BAD_REQUEST )
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public List<ErroFormularioDTO> handler(MethodArgumentNotValidException exception){
		
		List<ErroFormularioDTO> erros = new ArrayList<ErroFormularioDTO>();
		List<FieldError> errors = exception.getBindingResult().getFieldErrors();
		
		errors.forEach((fieldErro)->{ 
			String mensagem = messageSource.getMessage(fieldErro, LocaleContextHolder.getLocale());
			ErroFormularioDTO erro = new ErroFormularioDTO(fieldErro.getField() ,mensagem);
			erros.add(erro);
		});
		
		return erros;
	}
 }
