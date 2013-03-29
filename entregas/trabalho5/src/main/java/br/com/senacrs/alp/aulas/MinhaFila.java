package br.com.senacrs.alp.aulas;

public class MinhaFila<T> implements Fila<T> {
	
	private Lista<T> Lista =
			ListaFactory.getInstancia().criarLista();

	@Override
	public void insercao(T valor) {
		
		Lista.adicionarFinal(valor);
		
	}

	@Override
	public T obter() {
		
		return Lista.obterUltimo();
	}

	@Override
	public T remocao() {
		
		
		return Lista.removerPosicao(tamanho()-1);
	}

	@Override
	public boolean vazia() {
		
		
		return false;
	}

	@Override
	public int tamanho() {
		
		return Lista.obterTamanho();
		
	}

	@Override
	public void esvaziar() {
		
		
		Lista.esvaziar();
	}
	
	
}