package br.ufc.quixada.eda.hash;

public abstract class Hash<T> {

	protected Integer tam = 0;
	
	public Hash(Integer tam) {
		this.tam = tam;
	}
	public Integer fHash(int chave){
		return (chave % tam);
	}
	public abstract void inserir(Integer chave,T valor);
	public abstract T buscar(Integer chave);
	public abstract T remover(Integer chave);
	
}