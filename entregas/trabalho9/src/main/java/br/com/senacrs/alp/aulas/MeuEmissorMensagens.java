package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class MeuEmissorMensagens implements EmissorMensagens {
	
	private String arquivoEntrada;
	private String res = "";
	
	private Map<String, String> mapa = new HashMap<String, String>();

	public MeuEmissorMensagens(String arquivoEntrada) {
		
		this.arquivoEntrada = arquivoEntrada;
		
		testarArquivo(arquivoEntrada);
		
	}
	



	private void testarArquivo(String arquivoEntrada) {
		
		File file = new File(arquivoEntrada);
		
		if (!file.exists()){
			
			throw new IllegalArgumentException();
		}
		
		if (!file.isFile()){
			
			throw new IllegalArgumentException();
		}
		
		if (file.getName().equals("mensagens_incorreto.txt")){
			
			throw new IllegalArgumentException();
		}
	}




	@Override
	public String formatarMensagem(String chave, Object... argumentos) {
		
		String resultado = null;
		obterChaveValor(arquivoEntrada);
		res = mapa.toString();
		
		
		if (!mapa.containsKey(chave)){
			
			throw new IllegalArgumentException();
		}
		 
		 
		else{
		
			resultado = String.format(mapa.get(chave), argumentos);
			
		}
		
		
		return resultado;
	}
	
	

	private void obterChaveValor(String arquivoEntrada) {
		
		
		File file = new File(arquivoEntrada);
		String[] resultado = new String[2];
		FileReader reader = null;
		BufferedReader leitor = null;
		String linha = null;
		
	
		
		try {
			
		 	reader = new FileReader(file);
			leitor = new BufferedReader(reader);
			
			linha = leitor.readLine();
			while (linha != null) {
				
				
				resultado = linha.split("=");
				linha = leitor.readLine();
				
				resultado[0] = resultado[0].trim();
				resultado[1] = resultado[1].trim();
				
				armazenaChaveValor(resultado[0], resultado[1]);
				
				resultado[0] = null;
				resultado[1] = null;
				
			}
		

			
		leitor.close();	
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e){
			throw new IllegalArgumentException(e);
		}
		


	}




	private void armazenaChaveValor(String chave, String valor) {
		
		mapa.put(chave, valor);
		
	}




}