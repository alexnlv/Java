package br.com.senacrs.alp.aulas;

public class meuArquivoConfiguracao implements ArquivoConfiguracao {
	
	private String arquivoEntrada = null;
	
	public meuArquivoConfiguracao(String arquivoEntrada) {
		
		this.arquivoEntrada = arquivoEntrada;
		
		
		
	}

	@Override
	public String getRootDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getErrorDir() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPort() {
		// TODO Auto-generated method stub
		return 0;
	}

}
