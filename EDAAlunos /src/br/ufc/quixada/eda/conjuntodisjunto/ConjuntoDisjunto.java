package br.ufc.quixada.eda.conjuntodisjunto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.print.attribute.standard.Finishings;

public class ConjuntoDisjunto implements ConjuntoDisjuntoI{
	int maximo = 0;
	//int x = 0;
	int pai[] = null;
	int rank[] = null;
	public ConjuntoDisjunto(int maximo) {
		this.maximo =  maximo;
		pai = new int[maximo];
		rank = new int[maximo];
	}
	
	public void makeSet(List<Integer> entrada) {
		int i = 0;
		if(entrada.size() > maximo) {
			System.err.println("ERRO: Entrada maior que a permitida!!");
			return;
		}
		for (Integer x : entrada) {
			pai[x] = x;
			rank[x] = 0;
			i++;
		}
	}
	private void link(int x, int y) {
		if(rank[x] > rank[y])
			pai[y] = x;		
		else 
			pai[x] = y;
			if (rank[x] == rank[y]) 
				rank[y]++;
		
	}
		
	public int findSet(int x) {
		if(x != pai[x]){
			pai[x] = findSet(pai[x]);
		}
		
		return pai[x];
	}
	
	public void union(int x, int y) {
		link(findSet(x),findSet(y));
	}
	@Override
	public String toString() {
		return "ConjuntoDisjunto [pai=" + Arrays.toString(pai)
				+ ", rank=" + Arrays.toString(rank) + "]";
	}

}
