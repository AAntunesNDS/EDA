package br.ufc.quixada.eda.hash;

import br.ufc.quixada.eda.lista.ListaEncadeada;

public class EnderecamentoExterno extends Hash{

	private ListaEncadeada lista[];
	public EnderecamentoExterno(Integer tam) {
		super(tam);
		lista = new ListaEncadeada[tam];
	}

	@Override
	public void inserir(Integer chave,String valor) {
		Integer posicao = fHash(chave);
		if(lista[posicao] == null) {
			lista[posicao] = new ListaEncadeada();
		}
		String retorno = lista[posicao].buscar(chave);
		if( retorno == null) 
			lista[posicao].add(chave, valor);
		else
			System.out.println("Conflito de chave"); 
	}

	@Override
	public String buscar(Integer chave) {
		Integer posicao = fHash(chave);
		String retorno = lista[posicao].buscar(chave);
		return retorno;
	}

	@Override
	public String remover(Integer chave) {
		Integer posicao = fHash(chave);
		String retorno = lista[posicao].remover(chave);
		return retorno;
	}
	public String toString(){
		String saida = "";
		for(int i = 0;i < super.tam;i++) {
			if(lista[i] == null) saida += "["+i+"] = { }\n";
			else {
				saida += "["+i+"] = " +lista[i].toString()+"\n";
			}			
		}		
		return saida;
	}

}