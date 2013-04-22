package br.com.senacrs.alp.aulas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinhaEmpresa implements Empresa{

	private String nome;
	ArrayList<Departamento> listaDep = new ArrayList<Departamento>();
	
	
	public MinhaEmpresa(String nome){
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
				
		this.nome = nome;		
	}
	
		
	@Override
	public String getNome() {
		
		return this.nome;
	}

	@Override
	public List<Departamento> listaDepartamentoOrdemCrescentePorQtdFuncionarios() {
		
		ComparadorDepartamentoOrdemCrescentePorQtdFuncionarios CompCresQtdFunc = new ComparadorDepartamentoOrdemCrescentePorQtdFuncionarios();
		
		Collections.sort(listaDep, CompCresQtdFunc);
		
		return listaDep;
	}

	@Override
	public void adicionarDepartamento(Departamento departamento) {
		
		if(departamento == null) {
			throw new IllegalArgumentException();
		}
		
		listaDep.add(departamento);
	}

	@Override
	public int quantidadeFuncionarios() {
		
		int i = 0;
		int soma = 0;
		while(i < listaDep.size()) {
			soma = soma + listaDep.get(i).quantidadeFuncionarios();
			i++;
		}
	
		return soma;
	}
	

}
