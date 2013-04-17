package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class MeuComparatorString implements Comparator<String>{

	@Override
	public int compare(String o1, String o2) {
		
		int resultado = 0;
		
		resultado = o2.compareTo(o1);
		
		return resultado;
	
	}

}
