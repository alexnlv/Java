package br.com.senacrs.alp.aulas;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

public class meuCriarValidacao implements ObterCabecalhoRequisicaoGet {

	private ArquivoConfiguracao config;
	private static String PWD = System.getProperty("user.dir");
	private static String PATH = "/";
	private static final String GET = "GET " + PATH;
	
	public meuCriarValidacao(ArquivoConfiguracao config) {
		this.config = config;
		
		
	}

	@Override
	public String[] obterCabecalhoResposta(Reader requisicao) {
		String[] resultado = null;
		String arqDir = null;
		File file = null;
		
		try {
		
			arqDir = obterArqDir(requisicao);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
		
		resultado = obterResposta(arqDir);
		
		return resultado;
	}

	private String obterArqDir(Reader requisicao) throws IOException {
		
		StringBuilder res = new StringBuilder();
		String resultado = null;
		int i = requisicao.read();
		Character c;
		
		
		while(i != -1){
			
			c = (char)i;
			res.append(c);
			i = requisicao.read();
		}
		
		if(res.toString().endsWith(NOVA_LINHA)){
			
			resultado = res.toString();
			
		} else {
			
			resultado = "erro";
		}
		
		
		
		
		return null;
	}

	private String[] obterResposta(String arqDir) {
		// TODO Auto-generated method stub
		return null;
	}

}
