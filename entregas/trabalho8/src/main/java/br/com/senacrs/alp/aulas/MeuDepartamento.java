package br.com.senacrs.alp.aulas;

import java.util.List;

public class MeuDepartamento implements Departamento{

	private String nome;
	private Empresa empresa;
	
	
	public MeuDepartamento(Empresa empresa, String nome){
		
		this.empresa = empresa;
		this.nome = nome;
		
	}
	
	
	@Override
	public Empresa getEmpresa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> listarFuncionariosPorOrdemAlfabetica() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Funcionario> listarFuncionariosPorDecrescenteSalario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int quantidadeFuncionarios() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void adicionarFuncionario(Funcionario funcionario) {
		// TODO Auto-generated method stub
		
	}

}
