package br.com.senacrs.alp.aulas;

import java.util.ArrayList;
import java.util.List;

public class MinhaEmpresa implements Empresa{

	private String nome;
	ArrayList<Departamento> lista = new ArrayList<Departamento>();
	
	public MinhaEmpresa(String nome){
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		this.nome = nome;
		
		
	}
	
		
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public List<Departamento> listaDepartamentoOrdemCrescentePorQtdFuncionarios() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void adicionarDepartamento(Departamento departamento) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int quantidadeFuncionarios() {
		// TODO Auto-generated method stub
		return 0;
	}
	

}
