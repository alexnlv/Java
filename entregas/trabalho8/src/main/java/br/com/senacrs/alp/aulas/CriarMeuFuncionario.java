package br.com.senacrs.alp.aulas;

import java.io.ObjectInputStream.GetField;

public class CriarMeuFuncionario implements Funcionario{

	private String nome;
	private Departamento Departamento;
	private Empresa empresa;
	private double salario;
	
	public CriarMeuFuncionario(Departamento departamento, String nome, double salario){
		
		
	}
	@Override
	public Empresa getEmpresa() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento getDepartamento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNome() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSalario() {
		// TODO Auto-generated method stub
		return 0;
	}

}
