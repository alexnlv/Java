package br.com.senacrs.alp.aulas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MeuDepartamento implements Departamento{
	
	
	private String nome;
	private Empresa empresa;
	ArrayList<Funcionario> listaFunc = new ArrayList<Funcionario>();
	
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
		
		return this.empresa;
	}

	@Override
	public String getNome() {
		
		return this.nome;
	}

	@Override
	public List<Funcionario> listarFuncionariosPorOrdemAlfabetica() {
		
		ComparadorFuncionariosPorOrdemAlfabetica compFuncAlf = new ComparadorFuncionariosPorOrdemAlfabetica();
		
		Collections.sort(listaFunc, compFuncAlf);
		
		return listaFunc;
	}

	@Override
	public List<Funcionario> listarFuncionariosPorDecrescenteSalario() {
		
		ComparadorFuncionariosPorDecrescenteSalario compFuncSalario = new ComparadorFuncionariosPorDecrescenteSalario();
		Collections.sort(listaFunc, compFuncSalario);
			
		return listaFunc;
	}

	@Override
	public int quantidadeFuncionarios() {
		
		return listaFunc.size();
	}

	@Override
	public void adicionarFuncionario(Funcionario funcionario) {
		
		if (funcionario == null){
			
			throw new IllegalArgumentException();	
		}
		
		listaFunc.add(funcionario);
		
	}

}
