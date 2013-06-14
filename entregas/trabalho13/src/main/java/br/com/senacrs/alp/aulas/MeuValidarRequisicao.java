package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MeuValidarRequisicao implements ValidarRequisicaoGet {
		
	private static final String GET = "GET / http/1.1";
	private static final String HOST = "Host: www.google.com"; 
	
	@Override
	public boolean ehRequisicaoGetValida(Reader requisicao) {
		
		String[] linhas = new String[2];
		
		if (requisicao == null){
			
			throw new IllegalArgumentException();
		}
		
		boolean resultado = false;
		
		linhas = lerReader(requisicao);
		
		if(linhas[1] == null){
			
			resultado = false;
		}
		
		else if(linhas[0].equals(GET) && linhas[1].equals(HOST)){
			
			resultado = true;
		} 
		
	
		
		
		
		return resultado;
	}

	private String[] lerReader(Reader requisicao) {
		
		String [] resultado = new String[2];
		BufferedReader buffer = new BufferedReader(requisicao);
		
		try {
		
			resultado[0] = buffer.readLine();
			resultado[1] = buffer.readLine();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new IllegalArgumentException(e);
		}
		
		
		return resultado;
	}

}

