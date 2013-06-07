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
		FileReader reader = null;
		BufferedReader leitor = null;
		String linha, chave, valor = null;
		String[] chaveValor = new String[2];
		
	
		
		try {
			
		 	reader = new FileReader(file);
			leitor = new BufferedReader(reader);
			
			linha = leitor.readLine();
			while (linha != null) {
					
				while(linha.contains("#")){
					
					linha = tratarComentarios(linha);
					
				} 
				
				if(linha.contains("=")){
				
					chaveValor = linha.split("=");
				
					if (chaveValor.length == 2){
					
						chave = chaveValor[0].trim();
						valor = chaveValor[1].trim();
		
						mapa.put(chave, valor);
						
						testarMapa(mapa);
						
					} else {
					
						throw new IllegalArgumentException();
					}
				}
					
				linha = leitor.readLine();
				
				
			}
		
			if(mapa.size() < 3){
				
				throw new IllegalArgumentException();
			}
			
			leitor.close();
			
			
		} catch (FileNotFoundException e) {
			throw new IllegalArgumentException(e);
		} catch (IOException e){
			throw new IllegalArgumentException(e);
		}
		
		
	}

	private void testarMapa(Map<String, String> mapa) {
		
		if(mapa.containsKey("root_dir")){
			
			if (mapa.get("root_dir").startsWith("./"));
			else {
				
				throw new IllegalArgumentException();
			}
		}
		
		if(mapa.containsKey("error_dir")){
			
			if (mapa.get("error_dir").startsWith("./"));
			else {
				
				throw new IllegalArgumentException();
			}
			
		}
		
		if(mapa.containsKey("port")){
			
			if (Integer.parseInt(mapa.get("port")) >= 1000 );
			else {
				
				throw new IllegalArgumentException();
			}
			
		}
		
		
	}

	private String tratarComentarios(String linha) {
		
		String resultado = null;
		
		if(linha.startsWith("#")){
			resultado = "";
			
		} else {
			
			String[] aux = linha.split("#");
			
			if (aux.length == 2){
				
				resultado = aux[0].trim();
		
			} else {
				
				throw new IllegalArgumentException();
			}
				
			
		}
		
		return resultado;
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
		
		String resultado = null;
		
		if (mapa.containsKey("root_dir")){
			
			if (mapa.get("root_dir").startsWith("./")){
				
				resultado = mapa.get("root_dir");
			
			} else {
				
				throw new IllegalArgumentException();
			}
			
		}
		
		
		return resultado;
	}

	@Override
	public String getErrorDir() {
		
		String resultado = null;
		
		if (mapa.containsKey("error_dir")){
			
			resultado = mapa.get("error_dir");
		}
		
		return resultado;
	}

	@Override
	public int getPort() {
		
		int resultado = 0;
		
		if (mapa.containsKey("port")){
			
			resultado = Integer.parseInt(mapa.get("port"));
		}
		
		
		
		return resultado;
	}

}
