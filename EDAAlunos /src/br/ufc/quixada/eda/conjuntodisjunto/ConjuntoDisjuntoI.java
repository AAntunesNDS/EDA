package br.ufc.quixada.eda.conjuntodisjunto;

import java.util.List;

public interface ConjuntoDisjuntoI {
	
	
	public void makeSet(List<Integer> entrada);	
	public int findSet(int x);
	
	public void union(int x, int y);

	public String toString();


	
}
