package br.com.senacrs.alp.aulas;

import java.util.Comparator;

public class ComparadorFuncionariosPorOrdemAlfabetica 
implements Comparator<Funcionario> {

	@Override
	public int compare(Funcionario nome1, Funcionario nome2) {
		
		return nome1.getNome().compareTo(nome2.getNome());
	}
	
	

}
