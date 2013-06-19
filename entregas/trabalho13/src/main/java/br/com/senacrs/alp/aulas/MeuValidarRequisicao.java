package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class MeuValidarRequisicao implements ValidarRequisicaoGet {
	
	private static String PWD = System.getProperty("user.dir");
	private static final String GET = "GET";
	private static final String HOST = "Host:"; 
	private static final String LINHA_BRANCO = " ";
	private static final Object BARRA = "/";
	
	
	@Override
	public boolean ehRequisicaoGetValida(Reader requisicao) {
		
		boolean resultado = false;
		StringBuilder builder = new StringBuilder();
		String texto = null;
		String [] linhas;
		
		if (requisicao == null){
			
			throw new IllegalArgumentException();
		} else {
			
			resultado = false;
			
		}
	
		
		
		
		try {
			texto = lerReader(requisicao);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
		
		linhas = texto.split(NOVA_LINHA);
		
		if(linhas != null){
		
			if(linhas.length == 2){
			
				resultado = testarGetHost(linhas[0], linhas[1]);
			
			}
		}
					
		return resultado;
	}

	private boolean testarGetHost(String get, String host) {
		
		boolean resultado = false;
		int contador = 0;
		boolean parcial1 = false;
		boolean parcial2 = false;
	
		
		
		String[] testaGet = get.split(LINHA_BRANCO);
			
		if (testaGet.length == 3){
			
			if(testaGet[0].startsWith(GET)){
				
				if(testaGet[1].trim().equals(BARRA)) {
									
					parcial1 = true;
				}
			}	
		}
		
		
		if (host.startsWith(HOST)){
			
			if(host.contains("www")){
				
				parcial2 = true;
			}
						
				
		}
		
		if(parcial1 && parcial2){
			
			resultado = true;
		}
		
		return resultado;
	}

	private String lerReader(Reader requisicao) throws IOException {
		
		//String [] resultado = new String[2];
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
		
		return resultado;
	}

}

