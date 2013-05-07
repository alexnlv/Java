package br.com.senacrs.alp.aulas;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class MeuEmissorMensagens implements EmissorMensagens {
	String arquivoE;
	@Override
	public String formatarMensagem(String chave, Object... argumentos) {
		String resultado = null;
		
		try{
			FileReader fr=new FileReader(arquivoE);
			BufferedReader br = new BufferedReader(fr);
			boolean arctem = false;
			String linha;
			while((linha=br.readLine())!=null){
				String l[] = linha.split("=");
				if(l[0].trim().equals(chave)){
					resultado = String.format(l[1].trim(), argumentos);
					arctem = true;
				}
			}
			if(arctem == false){
				throw new IllegalArgumentException();
			}
			fr.close();
			br.close();
		}catch(IOException ex){
			ex.printStackTrace();
		}
		
		return resultado;
	}
	
	public MeuEmissorMensagens(String arquivoE){
		this.arquivoE = arquivoE;
		File arquivo = oblerArquivo(arquivoE);
		verificaFormato(arquivo);
	}
	
	private File oblerArquivo(String arquivo){
		File resultado = null;
		
		if(arquivo == null){
			throw new IllegalArgumentException();
		}else{
			resultado = new File(arquivo);
			verificarArquivo(resultado);
		}
		return resultado;
	}

	private void verificarArquivo(File arquivo){
		if(arquivo == null){
			throw new IllegalArgumentException();
		}
		if(!arquivo.exists()){
			throw new IllegalArgumentException();
		}
		if(!arquivo.isFile()){
			throw new IllegalArgumentException();
		}
		if(!arquivo.canRead()){
			throw new IllegalArgumentException();
		}
	}
	
	private void verificaFormato(File arc){
		try{
			FileReader fr = new FileReader(arc);
			BufferedReader br = new BufferedReader(fr);
			
			String a[] = br.readLine().split("=");
			if(a.length != 2){
				throw new IllegalArgumentException();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}