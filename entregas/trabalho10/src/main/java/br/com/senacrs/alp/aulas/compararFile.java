package br.com.senacrs.alp.aulas;

import java.io.File;
import java.util.Comparator;

public class compararFile implements Comparator<File>{

	@Override
	public int compare(File f1, File f2) {
		
		int resultado = 0;
		
		
		if (f1.isDirectory() && f2.isFile()){
			
			resultado = -1;
		}
		
		if (f1.isFile() && f2.isDirectory()){
			
			resultado = 1;
		} 
		
		if (f1.isFile() && f2.isFile()){
			
			resultado = 1;
		}
		
		
		
		return resultado;
	}

}
