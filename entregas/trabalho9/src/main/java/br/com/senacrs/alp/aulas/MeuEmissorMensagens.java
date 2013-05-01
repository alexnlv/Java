package br.com.senacrs.alp.aulas;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class MeuEmissorMensagens implements EmissorMensagens {

	@Override
	public String formatarMensagem(String chave, Object... argumentos) {
		
		String resultado = null;
		testeDeString(chave);
		
		
		
		
		
		
		
		
		return resultado;
	}

	private void testeDeString(String str) {
		
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
