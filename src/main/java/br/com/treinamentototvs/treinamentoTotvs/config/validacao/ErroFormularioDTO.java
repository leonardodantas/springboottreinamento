package br.com.treinamentototvs.treinamentoTotvs.config.validacao;

public class ErroFormularioDTO {

	private String campo;
	private String erro;
	
	public ErroFormularioDTO(String campo, String erro) {
		super();
		this.campo = campo;
		this.erro = erro;
	}

	public String getCampo() {
		return campo;
	}

	public String getErro() {
		return erro;
	}
	
	
	
	
}
