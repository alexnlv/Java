package br.com.senacrs.alp.aulas;

import br.com.senacrs.alp.aulas.Departamento;
import br.com.senacrs.alp.aulas.Empresa;
import br.com.senacrs.alp.aulas.Funcionario;

public class CriarMeuFuncionario implements Funcionario{

	private String nome;
	private Departamento departamento;
	private Empresa empresa;
	private double salario;
	
	public CriarMeuFuncionario(Empresa empresa, Departamento departamento, String nome, double salario){
		
		if(nome == null){
			throw new IllegalArgumentException();
		}
		if(departamento == null){
			throw new IllegalArgumentException();
		}
		if(salario<0){
			throw new IllegalArgumentException();
		}
		
		this.empresa = empresa;
		this.departamento = departamento;
		this.nome = nome;
		this.salario = salario;
	}
	@Override
	public Empresa getEmpresa() {
		// TODO Auto-generated method stub
		return this.empresa;
	}

	@Override
	public Departamento getDepartamento() {
		// TODO Auto-generated method stub
		return this.departamento;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	@Override
	public double getSalario() {
		// TODO Auto-generated method stub
		return this.salario;
	}

}
