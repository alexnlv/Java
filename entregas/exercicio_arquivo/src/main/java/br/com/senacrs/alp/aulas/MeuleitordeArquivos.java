package br.com.senacrs.alp.aulas;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MeuleitordeArquivos implements LeitorArquivos {

	@Override
	public String[] lerArquivo(String arquivo) {
		
		ArrayList<String> lista = new ArrayList<String>();
		String str;
		String[] resultado;
		
		
		try {
			 BufferedReader in = new BufferedReader(new FileReader(arquivo));
			 
			 while (in.ready()) {
			 str = in.readLine();
			 lista.add(str);
			 
			 }
			 in.close();
			 } catch (IOException e) {
			 }

		for (int i = 0; i < lista.size(); i++) {
			
			resultado = lista.subList(fromIndex, toIndex);
			
			
		}		
		
				
		return null;
	}

	@Override
	public String[] lerArquivoComSubstituicao(String arquivo, String busca,
			String substituicao) {
		// TODO Auto-generated method stub
		return null;
	}

}
