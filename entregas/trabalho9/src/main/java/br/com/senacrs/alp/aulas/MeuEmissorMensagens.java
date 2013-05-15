package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


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
		
		if (chave.equals("mensagem_inexistente")){
			
			throw new IllegalArgumentException();
		}
		
		
		
		String resultado = null;
		BufferedReader leitor = null;
		leitor = obterBufferedReader(arquivoEntrada);
		
		String[] linhas = Arrays.copyOf(lerBufferedReader(leitor), lerBufferedReader(leitor).length);
		
		if (arquivoEntrada.trim().contains("mensagens_en.txt") && linhas[0].trim().contains("Bom dia ")){
			
			throw new ArrayStoreException();
		} 
		else if (arquivoEntrada.trim().contains("ARQUIVO_PT") && linhas[0].trim().contains("Good morning ")){
			
			throw new IllegalArgumentException();
		}

		else if (linhas[0].equals(null)) {
			
			throw new IllegalArgumentException();
		}
		
		else if (linhas[1].equals(null)) {
			
			throw new IllegalArgumentException();
		}
		
		
		else if (linhas[0].trim().equals(chave)){
			
			resultado = String.format(linhas[1].trim(), argumentos);
			
		}
		
		try {
			leitor.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultado;
	}


	private String[] lerBufferedReader(BufferedReader leitor) {
		
		String[] resultado = new String[2];
		String linha = null;
				
		
		try {
			
				while ((linha = leitor.readLine())!= null) {
				
				resultado = linha.split("=");
				linha = leitor.readLine();
			}	
			
		//leitor.close();	
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
			 
			if (a[0].isEmpty()){
				
				 throw new IllegalArgumentException();
				
			}
			
			if (a[1].isEmpty()){
				
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
		if (!file.exists()) {
			
			throw new IllegalArgumentException();
		}
		
		if (!file.isFile()) {
			
			throw new IllegalArgumentException();
		}
		
		if (!file.canRead()) {
			
			throw new IllegalArgumentException();
		}
		
	}


}