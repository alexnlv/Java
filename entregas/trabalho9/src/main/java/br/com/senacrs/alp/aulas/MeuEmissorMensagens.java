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
	
	
	private String arquivoEntrada;


	public MeuEmissorMensagens(String arquivoEntrada) {
		
		this.arquivoEntrada = arquivoEntrada;
		
	}

	@Override
	public String formatarMensagem(String chave, Object... argumentos) {
		
		String resultado = null;
		BufferedReader leitor = null;
		String[] linhas = null;
		leitor = obterBufferedReader(arquivoEntrada);
		linhas = lerBufferedReader(leitor);
		
		Map<String, String> mapa = null;
		
		for (int i = 0; i < linhas.length; i++) {
			
			if(linhas[i].equals(chave)){
				
				mapa.put(chave, linhas[i].trim());
			}
			
			
		}
		
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


	private BufferedReader obterBufferedReader(String arquivoEntrada) {
		
		BufferedReader resultado = null;
		File file = null;
		FileReader reader = null;
		
		file = obterFileLeitura(arquivoEntrada);
		
		try {
			
			reader = new FileReader(file);
			resultado = new BufferedReader(reader);
			
			
		} catch (FileNotFoundException e) {
			throw new IllegalStateException(e);
		}
		
		return resultado;
	
	}


	private File obterFileLeitura(String arquivoEntrada) {
		
		File resultado = null;
		
		resultado = new File(arquivoEntrada);
		verificarFile(resultado);
		
		return resultado;
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
