package br.com.senacrs.alp.aulas;

public class MinhaPilha<T> implements Pilha<T>{
	
	private Pilha<T> Pilha = 
			PilhaFactory.getInstancia().criarPilha();
	
	

	@Override
	public void insercao(T valor) {
		
		Pilha.insercao(valor);
		
	}

	@Override
	public T obter() {
		
		return Pilha.obter();
	}

	@Override
	public T remocao() {
		
			
		return Pilha.remocao();
	}

	@Override
	public boolean vazia() {
		
		boolean flag = false;
		
		if (Pilha != null) {
			
			flag = true;
		}
		
		
		if (Pilha.tamanho() > 0) {
			
			flag = false;
		}
		
		return flag;
	}

	@Override
	public int tamanho() {
		
		return Pilha.tamanho();
	}

	@Override
	public void esvaziar() {
		
		Pilha.esvaziar();
		
	}

}
