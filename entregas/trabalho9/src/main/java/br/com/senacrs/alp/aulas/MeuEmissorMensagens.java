package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

public class MeuEmissorMensagens implements EmissorMensagens {

	@Override
	public String formatarMensagem(String chave, Object... argumentos) {
		
		String resultado = null;
		testeChave(chave);
		
		Map<String, String> mapa = new HashMap<String, String>();
		
		mapa.put(chave);
		
		if (mapa.containsKey(chave)){
			
			throw new IllegalArgumentException();
		}
		
		
		
		
		
		return resultado;
	}

	private void testeChave(String str) {
		
		if (str == null) {
			
			throw new IllegalArgumentException();
			
		} else if (existeString(str)) {
			
			throw new IllegalArgumentException();
		}
		
	}

	private boolean existeString(String str) {
		
		boolean resultado = false;
		
		resultado = (str != null) && !str.trim().isEmpty();
		
		return resultado;
		
	}

}
