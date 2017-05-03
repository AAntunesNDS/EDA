package br.ufc.quixada.eda.hash;

import br.ufc.quixada.eda.lista.No;

public class EnderecamentoInterno extends Hash{

	private int conflito;
	private No tabelaHash[];
	public EnderecamentoInterno(Integer tam) {
		super(tam);
		tabelaHash = new No[tam];
		conflito = (int) (tam *0.7); 
	}

	@Override
	public  Integer fHash(int chave) {
		return (chave % conflito-1);
	}
	@Override
	public void inserir(Integer chave, String valor) {
		Integer posicao = fHash(chave);
		if(tabelaHash[posicao] == null) {
			tabelaHash[posicao] = new No(chave, valor);
			tabelaHash[posicao].setProxInt(-1);
		}
		else {
			if(tabelaHash[posicao].getProxInt() == -1) {
				int i = inserirConflito(chave, valor);
				tabelaHash[posicao].setProxInt(i);
			}
			else {
				int i = inserirConflito(chave, valor);
				int ant = tabelaHash[posicao].getProxInt();
				tabelaHash[posicao].setProxInt(i);
				tabelaHash[i].setProxInt(ant);
				int prox;
				while(tabelaHash[i].getProxInt() != -1) {
					prox = tabelaHash[i].getProxInt(); 
					tabelaHash[i].setProxInt(ant);
					i = prox;
				}
			}
			
		}
			
	}
	
	//Retorna o indice 
	private int inserirConflito(Integer chave, String valor) {
		int i = conflito;
		while(tabelaHash[i] != null);
		if(i == tam-1) System.out.println("Lista Cheia");
		else {
			tabelaHash[i] = new No(chave, valor);
			tabelaHash[i].setProxInt(-1);
			return i;
		}
		return -1;
		
	}
	@Override
	public String buscar(Integer chave) {
		int posicao = fHash(chave);
		while(tabelaHash[posicao].getChave() != chave){
			int i = posicao;
			int prox;
			int ant = tabelaHash[posicao].getProxInt();
			while(tabelaHash[i].getProxInt() != -1) {
				prox = tabelaHash[i].getProxInt(); 
				tabelaHash[i].setProxInt(ant);
				tabelaHash[posicao].setChave(prox);
			}
		}
		return tabelaHash[posicao].getValor();
	}

	@Override
	public String remover(Integer chave) {
		String removido = null;
		int posicao = fHash(chave);
		if(tabelaHash[posicao].getChave() == chave){
			removido = tabelaHash[posicao].getValor();
			int i = posicao;
			int prox;
			int ant = tabelaHash[posicao].getProxInt();
			while(tabelaHash[i].getProxInt() != -1) {
				prox = tabelaHash[i].getProxInt(); 
				tabelaHash[i].setProxInt(ant);
				tabelaHash[posicao].setChave(prox);
			}
			if(tabelaHash[posicao].getChave() != -1){
				int proxIndice = tabelaHash[posicao].getChave();
				tabelaHash[posicao].setChave(tabelaHash[proxIndice].getChave());
				tabelaHash[posicao].setChave(tabelaHash[proxIndice].getChave());
				tabelaHash[posicao].setValor(tabelaHash[proxIndice].getValor());
				tabelaHash[proxIndice].setChave(-1);
				tabelaHash[proxIndice].setChave(posicao);
			}else{
				tabelaHash[posicao].setChave(-1);

			}
		}else{
			int ant = -1;
			while(tabelaHash[posicao].getChave() != chave){
				ant = posicao;
				posicao = tabelaHash[posicao].getChave();
			}
			tabelaHash[ant].setChave(tabelaHash[posicao].getChave());
			removido = tabelaHash[posicao].getValor();
			tabelaHash[posicao].setChave(-1);
			tabelaHash[posicao].setChave(-1);
		}
		return removido;

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