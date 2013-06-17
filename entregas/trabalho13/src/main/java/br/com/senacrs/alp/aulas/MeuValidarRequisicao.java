package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;

public class MeuValidarRequisicao implements ValidarRequisicaoGet {
		
	private static final String GET = "GET / http/1.1\r\n";//+ MeuValidarRequisicao.NOVA_LINHA;
	private static final String HOST = "Host: www.google.com\r\n";//+ MeuValidarRequisicao.NOVA_LINHA; 
	private static String[] REQUISICAO = new String[] {
		"GET / http/1.1" + ValidarRequisicaoGet.NOVA_LINHA,
		"Host: www.google.com"+ ValidarRequisicaoGet.NOVA_LINHA};
	
	@Override
	public boolean ehRequisicaoGetValida(Reader requisicao) {
		
		boolean resultado = false;
		String[] linhas = new String[2];
		String get = null;
		String host = null;
		
		if (requisicao == null){
			
			throw new IllegalArgumentException();
		}
	
		
		linhas = lerReader(requisicao);
		
		get = linhas[0];
		host = linhas[1];
		
		if( (get != null) && (host != null)){
			
		  resultado = testarGetHost(get, host);
		
		}
		
		/*if (linhas.length > 1){
		
			if ( (linhas[0].equals(GET) && linhas[1].equals(HOST))/*&&(REQUISICAO.length == linhas.length)){
			
				resultado = true;
				System.out.println("entrou");
			
			} 
		}
		
		else {
				
				resultado = false;
		}*/
			
		return resultado;
	}

	private boolean testarGetHost(String get, String host) {
		
		boolean resultado = false;
		int contador = 0;
		boolean parcial1 = false;
		boolean parcial2 = false;
		int teste1, teste2 = 0;
		
	
		for(int i = 0; i < get.length(); i++){ 
			
			if((GET.length() >= get.length()) && (get.charAt(i) == GET.charAt(i))){
				
				teste1 = get.length();
				teste2 = GET.length();
				contador++;
			}			
		}
		
		if (contador == GET.length()){
			
			parcial1 = true;
		}
		
		contador = 0;
		
		for(int x = 0; x < host.length(); x++){ 
			
			if((HOST.length() >= get.length())&&(host.charAt(x) == HOST.charAt(x))){
				
				teste1 = host.length();
				teste2 = HOST.length();
				
				
				
				contador++;
			}		
		}
		
		if (contador == HOST.length()){
			
			parcial2 = true;
		}
		
		
		if(parcial1 && parcial2){ /*&& ((get.indexOf("\r") > -1) || (get.indexOf("\n") > -1) ) && ((host.indexOf("\r") > -1) || (host.indexOf("\n") > -1) )){
			*/
			resultado  = true;
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

