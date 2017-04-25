package br.ufc.quixada.eda.algoritmo;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.grafo.ListaAdjacencia;
import br.ufc.quixada.eda.listaprioridades.HeapMinimo;

public class Dijkstra {
	private int pai[] = null;
	private int custo[] = null;
	
	
	public Dijkstra(Grafo vetor, int origem) {
		pai = new int[vetor.getQtdVertice()];
		custo = new int[vetor.getQtdVertice()];
		for (int i = 0; i < vetor.getQtdVertice(); i++) {
			custo[i] = Integer.MAX_VALUE;
			pai[i] = -1;
		}
		custo[origem] = 0;
		pai[origem] = origem;
	}
	public void executar(Grafo g){
		//Inicializao Integer.MAX_VALUE
		
		HeapMinimo Q = new HeapMinimo(g.getQtdVertice());
		Q.contruir(custo);
		
		while(!Q.vazia()){
			int u = Q.remove();
			ListaAdjacencia adj = g.getAdj()[u];
			adj.inicializarIterator();
			while(adj.hasNext()){
				Aresta a = adj.next();
				//int v = (a.getU() == u ? a.getV() : a.getU());
				
				Relaxamento(a, Q);
			}
		}
	}
	public void Relaxamento(Aresta a, HeapMinimo h){
		if(custo[a.getU()] > custo[a.getV()] + a.getPeso()){
			pai[a.getU()] = a.getV();
			custo[a.getU()] = (int) (custo[a.getV()] + a.getPeso());
			h.alterarPrioridade(a.getU()+1, custo[a.getU()]);
		}
	}
	public String imprimirResult(){
		return custo.toString();
	}
}



