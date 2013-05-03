package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MeuEmissorMensagens implements EmissorMensagens {
	
	
	String arquivoEntrada;


	public MeuEmissorMensagens(String arquivoEntrada) {
		
		this.arquivoEntrada = arquivoEntrada;
		File file = obterFile(arquivoEntrada);
		verificaFormato(file);
	}

	private File obterFile(String arquivo) {
		
		File resultado = null;

		if(arquivo == null){

			 throw new IllegalArgumentException();
 
		}else{

			 resultado = new File(arquivo);

			 verificarFile(resultado);
 
		}

		 return resultado;
	}

	@Override
	public String formatarMensagem(String chave, Object... argumentos) {
		
		String resultado = null;
		BufferedReader leitor = null;
		String[] linhas = null;
		leitor = obterBufferedReader(arquivoEntrada);
		linhas = lerBufferedReader(leitor);
		
		
		if (linhas[0].trim().equals(chave)){
			
			resultado = String.format(linhas[1].trim(), argumentos);
			
		}
		
		else {
			
			throw new IllegalArgumentException();
		}
		
	
		return resultado;
	}


	private String[] lerBufferedReader(BufferedReader leitor) {
		
		String[] resultado = null;
		String linha = null;
				
		
		try {
			
			linha = leitor.readLine();
			while (linha != null) {
				
				resultado = linha.split("=");
				linha = leitor.readLine();
			}	
			
		leitor.close();	
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		
		
		
		return resultado;
	}


	private BufferedReader obterBufferedReader(String arquivoEntrada) {
		
		BufferedReader resultado = null;
		File file = null;
		FileReader reader = null;
		
		file = obterFile(arquivoEntrada);
		
		try {
			
			reader = new FileReader(file);
			resultado = new BufferedReader(reader);
			
			
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		}
		
		
		return resultado;
	
	}


	private void verificaFormato(File resultado) {
		
		try{
			 
			FileReader fr = new FileReader(resultado);

			 BufferedReader br = new BufferedReader(fr);

			
 
			String a[] = br.readLine().split("=");

			 if(a.length != 2){

				 throw new IllegalArgumentException();
 
			}
			 
			br.close(); 
			 
		 }catch(IOException e){

			 e.printStackTrace();
 
		}
		
	}

	private void verificarFile(File file) {
		
				
		if (file == null) {
			
			throw new IllegalArgumentException();
			
		}
		if (file.exists()) {
			
			throw new IllegalArgumentException();
		}
		
		if (file.isFile()) {
			
			throw new IllegalArgumentException();
		}
		
		if (file.canRead()) {
			
			throw new IllegalArgumentException();
		}
		
	}


}
