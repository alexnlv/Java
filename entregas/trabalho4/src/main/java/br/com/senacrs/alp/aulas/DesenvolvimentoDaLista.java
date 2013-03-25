package br.com.senacrs.alp.aulas;

import org.junit.rules.ExpectedException;

public class DesenvolvimentoDaLista<T> implements Lista<T> {
	
	private Nodo<T> inicio = new Nodo<T>();
	

	@Override
	public void adicionarFinal(T valor) {
		
		Nodo<T> nodo = null;
		
		nodo.conteudo = obterUltimo();
		
		nodo.conteudo = valor;
		
		
		
	}

	@Override
	public void adicionarInicio(T valor) {
		
		Nodo<T> nodo = null;
		
		nodo.conteudo = obterPrimeiro();
		
		nodo.conteudo = valor;
		
	}

	@Override
	public void adicionarPosicao(int posicao, T valor) {
		
		Nodo<T> anterior = null;
		Nodo<T> novo = new Nodo<T>();
		novo.conteudo = valor;
		
		if (posicao < 0){
			
			exception.expect(IllegalArgumentException.class);
			
			System.out.println("negativa");
		}
		
		
		else {
			
			anterior = obterNodoPosicao(posicao);
			novo.proximo = anterior.proximo;
			anterior.proximo = novo;
			System.out.println("ok");
		}
		
		
	}

	public ExpectedException exception = ExpectedException.none();
	
	@Override
	public T obterPrimeiro() {
		
		Nodo <T> nodo = null;
		nodo.conteudo = obterPosicao(0);
		
		return nodo.conteudo;
	}

	@Override
	public T obterUltimo() {
		
		int tamanho = obterTamanho();
		
		Nodo <T> nodo = null;
		
		nodo = obterNodoPosicao (tamanho);
		
		T resultado = nodo.conteudo;
				
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
		
		Nodo<T> nodo = inicio;
		int indice = -1;
		
		int pos = posicao;
		
		if (pos < -1) {
			
			pos = -1;
		}
		
		while(pos != indice){
			
			nodo = nodo.proximo;
			indice ++;
		}
		
		T resultado = nodo.conteudo;
		
		return resultado;
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
		
		Nodo<T> nodoRemover = null;
		
		Nodo<T> nodo = null;
		

		nodoRemover.conteudo = obterPosicao(posicao);
		
		nodo.proximo = nodoRemover.proximo; 
		nodoRemover.proximo = null;
		
		T resultado = nodo.conteudo;
		 
		return resultado;
	}

	@Override
	public void esvaziar() {
		
		Nodo<T> nodo = inicio;
		nodo.proximo = null;
		
	}

}
