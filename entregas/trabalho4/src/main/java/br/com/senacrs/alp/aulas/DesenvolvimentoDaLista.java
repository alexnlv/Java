package br.com.senacrs.alp.aulas;

import org.junit.rules.ExpectedException;

public class DesenvolvimentoDaLista<T> implements Lista<T> {
	
	private Nodo<T> inicio = new Nodo<T>();
	

	@Override
	public void adicionarFinal(T valor) {
		
		adicionarPosicao(obterTamanho(), valor);
		
		
	}

	@Override
	public void adicionarInicio(T valor) {
		
		adicionarPosicao(0, valor);
		
	}

	@Override
	public void adicionarPosicao(int posicao, T valor) {
		
		Nodo<T> anterior = null;
		Nodo<T> novo = new Nodo<T>();
		novo.conteudo = valor;
	
		anterior = obterNodoPosicao(posicao-1);
		novo.proximo = anterior.proximo;
		anterior.proximo = novo;
		novo.conteudo = valor;
		
	}

	
	@Override
	public T obterPrimeiro() {
		
		Nodo <T> nodo = null;
		nodo = obterNodoPosicao(0);
		
		return nodo.conteudo;
	}

	@Override
	public T obterUltimo() {
		
		int tamanho = obterTamanho();
	
		T resultado = obterPosicao (tamanho - 1);
						
		return resultado;
	}

	private Nodo<T> obterNodoPosicao (int posicao){
		
		Nodo<T> nodo = inicio;
		int indice = -1;
		
		while(posicao != indice) {
			
			nodo = nodo.proximo;
			indice ++;			
		}
		
		return nodo;
	}
	
	@Override
	public T obterPosicao(int posicao) {
		
		  Nodo<T> nodo = null;
	        nodo = obterNodoPosicao(posicao);
	        return nodo.conteudo;

	}

	@Override 
	public int obterTamanho() {
		
		int tamanho = 0;
		Nodo<T> nodo = null;
		nodo = inicio;
				
		while(nodo.proximo != null){

			tamanho++;
			
		}
				
		return tamanho;
	}

	@Override
	public T removerPosicao(int posicao) {
		
		Nodo<T> nodoRemover = new Nodo<T>();
		Nodo<T> nodo = null;
		
		nodoRemover = obterNodoPosicao(posicao);
		nodo = obterNodoPosicao(posicao - 1);
		
		nodo.proximo = nodoRemover.proximo; 
		nodoRemover.proximo = null;
		
		T resultado = nodo.conteudo;
		 
		return resultado;
	}

	@Override
	public void esvaziar() {
		
		inicio.proximo = null;
		
	}

}
