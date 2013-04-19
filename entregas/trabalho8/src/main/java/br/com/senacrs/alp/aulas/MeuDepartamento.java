package br.com.senacrs.alp.aulas;

import java.util.ArrayList;
import java.util.List;

public class MeuDepartamento implements Departamento{
	
	
	private String nome;
	private Empresa empresa;
	ArrayList<Funcionario> lista = new ArrayList<Funcionario>();
	
	public MeuDepartamento(Empresa empresa, String nome){
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		if(empresa == null){
			throw new IllegalArgumentException();
		}
		
		this.empresa = empresa;
		this.nome = nome;
		
	}
	
	
	@Override
	public Empresa getEmpresa() {
		// TODO Auto-generated method stub
		return this.empresa;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
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
