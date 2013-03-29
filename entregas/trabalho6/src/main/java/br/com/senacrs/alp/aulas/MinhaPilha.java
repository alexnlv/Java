package br.com.senacrs.alp.aulas;

public class MinhaPilha<T> implements Pilha<T>{
	
	private Lista<T> Lista = 
			ListaFactory.getInstancia().criarLista();
	
	

	@Override
	public void insercao(T valor) {
		
		Lista.adicionarFinal(valor);
		
	}

	@Override
	public T obter() {
		
		return Lista.obterPrimeiro();
	}

	@Override
	public T remocao() {
		
			
		return Lista.removerPosicao(tamanho() - 1);
	}

	@Override
	public boolean vazia() {
		
		boolean flag = false;
		
		if (Lista != null) {
			
			flag = true;
		}
		
		
		if (Lista.obterTamanho() > 0) {
			
			flag = false;
		}
		
		return flag;
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
