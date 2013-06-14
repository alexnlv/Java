package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

public class MeuValidarRequisicao implements ValidarRequisicaoGet {
		
	private static final String GET = "GET / http/1.1";// + MeuValidarRequisicao.NOVA_LINHA;
	private static final String HOST = "Host: www."; 
	private static final char[] get = GET.toCharArray();
	private static String[] REQUISICAO = new String[] {
		"GET / http/1.1" + ValidarRequisicaoGet.NOVA_LINHA,
		"Host: www.google.com" + ValidarRequisicaoGet.NOVA_LINHA, };
	
	@Override
	public boolean ehRequisicaoGetValida(Reader requisicao) {
		
		boolean resultado = false;
		String[] linhas = new String[2];
		
		if (requisicao == null){
			
			throw new IllegalArgumentException();
		
		} else if (requisicao.equals("")){
			
			resultado = false;
		}
		
		
		
		linhas = lerReader(requisicao);
		
		if (linhas.equals(REQUISICAO)){//(linhas[0].toString().equals(GET) && linhas[1].toString().startsWith(HOST)){
			
			resultado = true;
			System.out.println("entrou");
			
		}
		
		/*else if (linhas[0].toString().equals(GET) && linhas[1].toString().startsWith(HOST)){
			
			resultado = true;
		}*/
		
	
		
		
		
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

