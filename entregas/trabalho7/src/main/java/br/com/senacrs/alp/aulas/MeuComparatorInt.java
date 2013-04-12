package br.com.senacrs.alp.aulas;

import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeuComparatorInt implements Comparator<Integer>{

	@Override
	public int compare(Integer arg0, Integer arg1) {
		
		//Integer.valueOf(arg1).compareTo(Integer.valueOf(arg0));
		
		
	 return arg0-arg1;	 
	}

}
