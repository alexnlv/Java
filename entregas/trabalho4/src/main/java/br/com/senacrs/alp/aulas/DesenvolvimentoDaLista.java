package br.com.senacrs.alp.aulas;

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
        Nodo<T> nodo = null;
        Nodo<T> nodoNovo = new Nodo<T>();
        nodo = obterNodoPosicao(posicao -1);
        nodoNovo.proximo = nodo.proximo;
        nodo.proximo = nodoNovo;
        nodoNovo.conteudo = valor;
    }

    @Override
    public T obterPrimeiro() {
        Nodo<T> nodo = null;
        nodo = obterNodoPosicao(0);
        return nodo.conteudo;
    }

    @Override
    public T obterUltimo() {
        int tamanho = obterTamanho();
        T resultado = obterPosicao(tamanho -1);
        return resultado;
    }

    
    @Override
    public T obterPosicao(int posicao) {
        Nodo<T> nodo = null;
        nodo = obterNodoPosicao(posicao);
        return nodo.conteudo;
    }

    @Override
    public int obterTamanho() {
        int resultado = 0;
        Nodo<T> nodo = null;
        nodo = inicio;
        while(nodo.proximo != null){
            nodo = nodo.proximo;
            resultado++;
        }
        
        return resultado;
    }

    @Override
    public T removerPosicao(int posicao) {
        Nodo<T> nodo = null;
        Nodo<T> nodoAnterior = new Nodo<T>();
        nodo = obterNodoPosicao(posicao);
        nodoAnterior = obterNodoPosicao(posicao -1);
        nodoAnterior.proximo = nodo.proximo;
        nodo.proximo = null;
        T resultado = nodo.conteudo;
        return resultado;
    }

    @Override
    public void esvaziar() {
        inicio.proximo = null;
    }
    
    private Nodo<T> obterNodoPosicao(int posicao){
        Nodo<T> nodo = inicio;
        int indice = -1;
        while(posicao != indice){
            nodo = nodo.proximo;
            indice++;
        }
        return nodo;
    }

}