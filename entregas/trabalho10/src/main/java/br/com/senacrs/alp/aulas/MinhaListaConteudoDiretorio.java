package br.com.senacrs.alp.aulas;

import java.io.File;
import java.util.Arrays;

public class MinhaListaConteudoDiretorio implements ListaConteudoDiretorio {

	@Override
	public String[] listarConteudo(File diretorio) {
		
		testarDiretorio(diretorio);
		File[] files = diretorio.listFiles();
		String[] resultado = new String[files.length];
		compararFile cf = new compararFile();
		Arrays.sort(files, cf);
		
		
		
		for (int i = 0; i < files.length; i++) {
			
			File f = files[i];
			
			String res = ""
					+ (f.isDirectory() ? ListaConteudoDiretorio.IDENTIFICA_DIRETORIO :ListaConteudoDiretorio.NADA_CONSTA)
					+ ListaConteudoDiretorio.SEPARADOR
					+ (f.canRead() ? ListaConteudoDiretorio.PERMISSAO_LEITURA : ListaConteudoDiretorio.NADA_CONSTA)
					+ (f.canWrite() ? ListaConteudoDiretorio.PERMISSAO_ESCRITA : ListaConteudoDiretorio.NADA_CONSTA)
					+ (f.canExecute() ? ListaConteudoDiretorio.PERMISSAO_EXECUCAO : ListaConteudoDiretorio.NADA_CONSTA)
					+ ListaConteudoDiretorio.SEPARADOR
					+ f.length() + ListaConteudoDiretorio.SEPARADOR
					+ f.getName();
			
			
			resultado[i] = res;
		
					
			
		}
		
		
		
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
		
		
	
	}




}
