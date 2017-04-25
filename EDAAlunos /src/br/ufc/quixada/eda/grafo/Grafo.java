package br.ufc.quixada.eda.grafo;

public class Grafo {
	private int qtdVertice;
	private int qtdAresta;
	private Aresta arestas[];
	private ListaAdjacencia adj[];
	
	public Grafo(int a, int b) {
		qtdVertice = a;
		qtdAresta = b;
		//arestas = new Aresta[b];
	}
	
	public int getQtdVertice() {
		return qtdVertice;
	}

	public void setQtdVertice(int qtdVertice) {
		this.qtdVertice = qtdVertice;
	}

	public int getQtdAresta() {
		return qtdAresta;
	}

	public void setQtdAresta(int qtdAresta) {
		this.qtdAresta = qtdAresta;
	}

	public Aresta[] getArestas() {
		return arestas;
	}

	public void setArestas(Aresta[] arestas) {
		this.arestas = arestas;
	}
	public void add(Aresta a){
		arestas[arestas.length] = a;
	}
	
	public void quickSort(int i, int j){
		if(i < j){
			int k = particiona(i, j);
			quickSort(i, k - 1);
			quickSort(k + 1, j);
		}
	}
	
	private int particiona(int i, int j){
		int pivo = j;
		int q = i - 1;
		for(int k = i; k < j; k++){
			if(arestas[k].getPeso() < arestas[pivo].getPeso()){
				q++;
				Aresta aux = arestas[k];
				arestas[k] = arestas[q];
				arestas[q] = aux;
			}
		}
		Aresta aux = arestas[q + 1];
		arestas[q + 1] = arestas[j];
		arestas[j] = aux;
		return q + 1;
	}

	public ListaAdjacencia[] getAdj() {
		return adj;
	}

	public void setAdj(ListaAdjacencia[] adj) {
		this.adj = adj;
	}
	
	
}