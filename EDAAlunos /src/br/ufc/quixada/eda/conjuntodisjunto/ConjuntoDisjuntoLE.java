package br.ufc.quixada.eda.conjuntodisjunto;

import java.util.ArrayList;
import java.util.List;

public class ConjuntoDisjuntoLE implements ConjuntoDisjuntoI{

	List<List<Integer>> conjunto;
	
	public ConjuntoDisjuntoLE() {
		conjunto = new ArrayList<List<Integer>>();
	}
	@Override
	public void makeSet(List<Integer> entrada) {
		for (Integer x : entrada) {
			List<Integer> novo = new ArrayList<Integer>();
			novo.add(x);
			conjunto.add(novo);			
		}
		
	}
	@Override
	public int findSet(int x) {
		for (List<Integer> list : conjunto) {
			for (Integer elemento : list) {
				if(x == elemento) return list.get(0);
			}
		}
		return -1;
	}

	@Override
	public void union(int x, int y) {		
		link(findSet(x), findSet(y));
	}
	
	private void link(int x, int y) {
		conjunto.get(getConjunto(x)).addAll(conjunto.get(getConjunto(y)) );
		conjunto.remove(getConjunto(y));
		
	}

	//Recebe por paramento o representante do conjunto e retorna o indice na lista 
	private int getConjunto(int x) {
		int i = 0;
		for (List<Integer> list : conjunto) {
			if(list.get(0) == x) {
				return i;
			}
			i++;
		}
		return -1;
	}
	@Override
	public String toString() {
		return "ConjuntoDisjuntoLE [conjunto=" + conjunto + "]";
	}
	
	
}
