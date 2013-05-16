package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class MinhaListaConteudoDiretorio implements ListaConteudoDiretorio {

	@Override
	public String[] listarConteudo(File diretorio) {
		
		
		
		File[] files = diretorio.listFiles();
		String[] resultado = new String[files.length];
		
		for (int i = 0; i < files.length; i++) {
			
			File f = files[i];
			
			String res = ""
					+ (f.isDirectory() ? ListaConteudoDiretorio.IDENTIFICA_DIRETORIO :ListaConteudoDiretorio.NADA_CONSTA)
					+ ListaConteudoDiretorio.SEPARADOR
					+ (f.canRead() ? ListaConteudoDiretorio.PERMISSAO_LEITURA : ListaConteudoDiretorio.NADA_CONSTA)
					+ (f.canWrite() ? ListaConteudoDiretorio.PERMISSAO_ESCRITA : ListaConteudoDiretorio.NADA_CONSTA)
					+ (f.canExecute() ? ListaConteudoDiretorio.PERMISSAO_EXECUCAO : ListaConteudoDiretorio.NADA_CONSTA);
			
			
			
		
					
			
		}
		
		
		
		
		
		
		/*testarDiretorio(diretorio);
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
		
		File[] dir = diretorio.listFiles();
		
		String[] resultado = new String[dir.length];
		
		for (int i = 0; i < dir.length; i++) {
			
			resultado[i] = dir[i].toString();
		}*/
		
		return resultado;
	}



}
