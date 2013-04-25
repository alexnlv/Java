package br.com.senacrs.alp.aulas;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MeuleitordeArquivos implements LeitorArquivos {

	@Override
	public String[] lerArquivo(String arquivo) {
		
		String[] resultado = null;
		BufferedReader leitor = null;
		
		leitor = obterBufferedReader(arquivo);
		resultado = lerBufferedReader(leitor);
		
		return resultado;
	}

	private String[] lerBufferedReader(BufferedReader leitor) {
		
		String[] resultado = null;
		String linha = null;
		ArrayList<String> lista = null;
		
		lista = new ArrayList<String>();
		
		try {
			
			linha = leitor.readLine();
			while (linha != null) {
				
				lista.add(linha);
				linha = leitor.readLine();
			}
			
			resultado = converterListaArray(lista);
			
		} catch (IOException e) {
			throw new IllegalStateException(e);
		}
		
		return resultado;
	}

	private String[] converterListaArray(ArrayList<String> lista) {
		
		String[] resultado = null;
		resultado = new String[lista.size()];
		resultado = lista.toArray(resultado);
		return resultado;
	}

	private BufferedReader obterBufferedReader(String arquivo) {
		
		BufferedReader resultado = null;
		File file = null;
		FileReader reader = null;
		
		file = obterFileLeitura(arquivo);
		
		try {
			
			reader = new FileReader(file);
			resultado = new BufferedReader(reader);
			
			
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		}
		
		return resultado;
	}

	private File obterFileLeitura(String arquivo) {
		
		File resultado = null;
		
		verificarNomeArquivo(arquivo);
		resultado = new File(arquivo);
		verificarFile(resultado);
		
		return resultado;
	}

	private void verificarFile (File file) {
		
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
	
	private void verificarNomeArquivo(String arquivo) {
		
		
		
		
		
	}

	@Override
	public String[] lerArquivoComSubstituicao(String arquivo, String busca,
			String substituicao) {
	
		String[] resultado = null;
		String[] parcial = null;
		String linha = null;
		
		resultado = new String[parcial.length];
		
		parcial = lerArquivo(arquivo);
		
		for (int i = 0; i < parcial.length; i++) {
			
			linha = parcial[i];
			resultado[i] = linha.replace(busca, substituicao);
			
		}
		
		return resultado;
	}
	


}
