package br.com.senacrs.alp.aulas;

import java.util.List;

public class MinhaEmpresa implements Empresa{

	private String nome;
	
	
	public MinhaEmpresa(String nome){
		
		this.nome = nome;
	}
		
	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
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
