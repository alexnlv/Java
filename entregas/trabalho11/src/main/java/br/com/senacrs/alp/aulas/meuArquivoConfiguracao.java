package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class meuArquivoConfiguracao implements ArquivoConfiguracao {
	
	private String arquivoEntrada = null;
	private Map<String, String> mapa = new HashMap<String, String>();
	
	public meuArquivoConfiguracao(String arquivoEntrada) {
		
		this.arquivoEntrada = arquivoEntrada;
		
		testarArquivo(arquivoEntrada);
		
		leitura(arquivoEntrada);
	}

	private void leitura(String arquivoEntrada) {
		
		File file = new File(arquivoEntrada);
		String[] resultado = new String[3];
		FileReader reader = null;
		BufferedReader leitor = null;
		String linha = null;
		
	
		
		try {
			
		 	reader = new FileReader(file);
			leitor = new BufferedReader(reader);
			
			linha = leitor.readLine();
			while (linha != null) {
				
					if(ehComentario(linha)){
						
					}else{
						contemComentario(linha);				
					}
					
			}
		

			
		leitor.close();	
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e){
			throw new IllegalArgumentException(e);
		}
		
		
	}

	private void contemComentario(String linha) {
		if(linha.contains("#")){
			String l[] = linha.split("#");
		}
	}

	private boolean ehComentario(String linha) {
		boolean resultado = false;
		if(!linha.startsWith("#")){
			resultado = false;
		}else{
			resultado = true;
		}
		return resultado;
	}

	private void armazenaChaveValor(String chave, String valor) {
		
		mapa.put(chave, valor);
		
	}

	private void testarArquivo(String arquivoEntrada) {
		
		File file = new File(arquivoEntrada);
		
		if (!file.exists()){
			
			throw new IllegalArgumentException();
		}
		
		if (!file.isFile()){
			
			throw new IllegalArgumentException();
		}
	}

	@Override
	public String getRootDir() {
		
		
		return null;
	}

	@Override
	public String getErrorDir() {
		return null;
	}

	@Override
	public int getPort() {
		
		return 0;
	}

}
