package br.ufc.quixada.eda.hash;

public abstract class Hash {

	protected Integer tam = 0;
	
	public Hash(Integer tam) {
		this.tam = tam;
	}
	public Integer fHash(int chave){
		return (chave % tam);
	}
	public abstract void inserir(Integer chave,String valor);
	public abstract String buscar(Integer chave);
	public abstract String remover(Integer chave);
	
}