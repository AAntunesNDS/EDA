
package br.ufc.quixada.eda.hash;

import br.ufc.quixada.eda.lista.No;

public class EnderecamentoInterno<T> extends Hash<T>{

	private int conflito;
	private No tabelaHash[];
	public EnderecamentoInterno(Integer tam) {
		super(tam);
		tabelaHash = new No[tam];
		conflito = (int) (tam *0.7); 
	}

	@Override
	public  Integer fHash(int chave) {
		return (chave % (conflito-1));
	}
	@Override
	public void inserir(Integer chave, T valor) {
		Integer posicao = fHash(chave);
		if(tabelaHash[posicao] == null) {
			tabelaHash[posicao] = new No(chave, valor);
			tabelaHash[posicao].setProxInt(-1);
		}
		else {
			if(tabelaHash[posicao].getProxInt() == -1) {
				int i = inserirConflito(chave, valor);
				tabelaHash[posicao].setProxInt(i);
				return;
			}
			//Inserir conflito 
			int i = inserirConflito(chave, valor);
			if(i == -1) {
				return; 
			}
			int prox = i;
			int atual = tabelaHash[posicao].getProxInt();
			while(tabelaHash[atual].getProxInt() != -1) {
				atual = tabelaHash[atual].getProxInt();
			}
			tabelaHash[atual].setProxInt(prox);
		}
	}
	
	//Retorna o indice 
	private int inserirConflito(Integer chave, T valor) {
		int i = conflito;
		while(tabelaHash[i] != null) i++;
		
		if(i == tam) System.out.println("Lista Cheia");
		else {
			tabelaHash[i] = new No(chave, valor);
			tabelaHash[i].setProxInt(-1);
			return i;
		}
		return -1;
		
	}
	@Override
	public T buscar(Integer chave) {
		Integer posicao = fHash(chave);
		if(tabelaHash[posicao] == null) {
			return null;
		}
		if(tabelaHash[posicao].getChave() == chave) return (T) tabelaHash[posicao].getValor(); 
		else if(tabelaHash[posicao].getProxInt() != -1){
			int atual = tabelaHash[posicao].getProxInt();
			while(tabelaHash[atual].getProxInt() != -1 &&
					tabelaHash[atual].getChave() != chave) {				
				atual = tabelaHash[atual].getProxInt();
			}			
			if(tabelaHash[atual].getChave() == chave) return (T) tabelaHash[atual].getValor();
		}
		return null;
	}

	@Override
	public T remover(Integer chave) {
		Integer posicao = fHash(chave);
		int ant = 0;
		if(tabelaHash[posicao] == null) {
			return null;
		}
		if(tabelaHash[posicao].getChave() == chave && tabelaHash[posicao].getProxInt() == -1){
			T retorno = (T) tabelaHash[posicao].getValor();
			tabelaHash[posicao] = null;
			return retorno;
		}
		else if(tabelaHash[posicao].getProxInt() != -1){
			if(tabelaHash[posicao].getChave() == chave){
				T retorno = (T) tabelaHash[posicao].getValor(); 
				Integer prox = tabelaHash[posicao].getProxInt();
				tabelaHash[posicao] = buscarUltimo(chave);
				tabelaHash[posicao].setProxInt(prox);
				return retorno;
			}
			int atual = tabelaHash[posicao].getProxInt();
			while(tabelaHash[atual].getProxInt() != -1 &&
					tabelaHash[atual].getChave() != chave) {				
				ant = atual;
				atual = tabelaHash[atual].getProxInt();
			}			
			if(tabelaHash[atual].getChave() == chave) {				
				tabelaHash[ant].setProxInt(tabelaHash[atual].getProxInt());
				T retorno =(T) tabelaHash[atual].getValor();
				tabelaHash[atual] = null;
				return retorno;
			}
		}
		return null;
	}
	private No buscarUltimo(Integer chave) {
		Integer posicao = fHash(chave);
		int atual = tabelaHash[posicao].getProxInt();
		while(tabelaHash[atual].getProxInt() != -1 &&
				tabelaHash[atual].getChave() != chave) {				
			atual = tabelaHash[atual].getProxInt();
		}			
		No retorno;
		retorno = tabelaHash[atual];
		tabelaHash[atual] = null;
		return retorno;
	}
	
	public String toString() {
		String saida = "";
		for(int i = 0;i < super.tam;i++) {
			if(tabelaHash[i] == null) saida += i+ " []\n";
			else 
				saida +=i+" ["+ tabelaHash[i].toString() +"]\n";			
		}
		return saida;
	}

	
	
}