package br.com.senacrs.alp.aulas;

public class minhaConfiguracao implements Configuracao {

	private ArquivoConfiguracao config;
	
	public minhaConfiguracao(ArquivoConfiguracao config){
		
		this.config = config;
		try {
			meuArquivoConfiguracao obj = meuArquivoConfiguracao.class.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}			
				
	@Override
	public ArquivoConfiguracao getArquivoConfiguracao() {
		
		ArquivoConfiguracao resultado = null;
		
		resultado = ArquivoConfiguracao.class.cast(config);
		
		
		return resultado;
	}

	@Override
	public boolean valido() {
		
		boolean resultado = false;
		
		if((ArquivoConfiguracao.class.cast(config).getPort() >= 1024) 
				&& (ArquivoConfiguracao.class.cast(config).getPort()<= 65535)
				&& (ArquivoConfiguracao.class.cast(config).getRootDir().equals("./html"))
				&& (ArquivoConfiguracao.class.cast(config).getErrorDir().equals("./html/error/"))) {
			
			resultado = true;
		}
		
		
		return resultado;
	}

}
