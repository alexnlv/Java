package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class MinhaListaConteudoDiretorio implements ListaConteudoDiretorio {

	@Override
	public String[] listarConteudo(File diretorio) {
		
		
		
		testarDiretorio(diretorio);
		String[] resultado = lerDiretorio(diretorio);
		
		
		
		return resultado;
	}

	private void testarDiretorio(File diretorio) {
		
		if (diretorio == null){
			
			throw new IllegalArgumentException();
		}
		
		if (!diretorio.exists()){
			
			throw new IllegalArgumentException();
		}
	
		if (diretorio.isFile()){
			
			throw new IllegalArgumentException();
		}
		
		if ((lerDiretorio(diretorio)).length == 0 ){
			
			throw new IllegalArgumentException();
			
		}
		
		if ((lerDiretorio(diretorio)).equals(null) ){
			
			throw new IllegalArgumentException();
			
		}
	}

	private String[] lerDiretorio(File diretorio) {
		
		String[] resultado = new String[8];
		int cont = 0;
		
		try {
			BufferedReader in = new BufferedReader(new FileReader(diretorio));
			while (in.ready()) {
			resultado[cont] = in.readLine();
			cont++;
			}
			in.close();
		} catch (IOException e) {
			
			}

			
		
		
		return resultado;
	}



}
