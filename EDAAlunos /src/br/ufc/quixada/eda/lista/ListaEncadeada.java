package br.ufc.quixada.eda.lista;

public class ListaEncadeada {
	private No inicio;

	public int size() {
		No no = this.inicio;
		int cont = 0;
		while(no != null){
			cont++;
			no = no.getProx();
		}
		return cont;
	}
	public void criarLista(Integer chave, String valor) {
		No inicio = new No(chave, valor);
		this.inicio = inicio;
	}
	
	public void add(Integer chave, String valor) {
		if(this.inicio == null) {
			criarLista(chave, valor);
			return;
		}
		No no = new No(chave, valor);
		no.setProx(this.inicio);
		this.inicio = no;		
	}
	
	public String remover(Integer chave) {
		No ant = null;
		No atual = this.inicio;
		if(this.inicio == null) return null; // Caso seja o primeiro da lista
		if(atual.getChave() == chave) {
			this.inicio = atual.getProx();
			return atual.getValor();
		}
		while(atual != null && atual.getChave() != chave) {
			ant = atual;
			atual = atual.getProx();
		}
		if(atual != null){ 
			ant.setProx(atual.getProx());
			//free no Nó
			return atual.getValor();
		}
		return null;
	}
	public String buscar(Integer chave) {
		No ant = null;
		No atual = this.inicio;
		if(this.inicio == null) return null;
		while(atual != null && atual.getChave() != chave) {
			ant = atual;
			atual = atual.getProx();
		}
		if(atual != null){ 
			return atual.getValor();
		}
		return null;
	}
	public String toString(){
		No no = this.inicio;
		String saida = "{ ";
		while(no != null){
			saida += "["+no.getChave() +": "+no.getValor()+"],";  
			no = no.getProx();
		}
		//retirar a ultima virgula
		saida = saida.substring(0, saida.length() - 1);
		saida += " }";
		return saida;
	}
	
	
}