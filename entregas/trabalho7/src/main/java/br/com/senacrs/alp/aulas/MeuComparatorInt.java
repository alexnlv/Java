package br.com.senacrs.alp.aulas;

import java.lang.reflect.Array;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.omg.CORBA.ARG_IN;

public class MeuComparatorInt implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		
		int resultado = 0;
		
		if (par(arg0) == par(arg1)) {
			resultado = compareMesmaParidade(arg0, arg1);
		} else{
			resultado = compareParidadeDistinta(arg0, arg1);
		}
		
		
		
		
		return resultado;
	 
	}
	
	
	public boolean par (Integer a){
		
		boolean resultado = false;
		
		resultado = a.intValue() %2 ==0;
		
		return resultado;
		
			
	}
	
	private int compareMesmaParidade( Integer arg0, Integer arg1) {
		
		int resultado = 0;
		
		resultado = arg0.intValue() - arg1.intValue();
		
		return resultado;
	}
	
	
private int compareParidadeDistinta( Integer arg0, Integer arg1) {
		
		int resultado = 0;
		
		if(par(arg0)) {
			resultado = -1;
		} else {
			resultado = 1;
		}
		
		return resultado;
	}

}
