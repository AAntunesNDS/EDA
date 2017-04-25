package br.ufc.quixada.eda.grafo;

public class Aresta {
	private int v;
	private int u;
	private double peso;
	
	public Aresta(int v, int u, double peso) {
		this.v = v;
		this.u = u;
		this.peso = peso;
	}	
	
	public int getV() {
		return v;
	}
	public void setV(int v) {
		this.v = v;
	}
	public int getU() {
		return u;
	}
	public void setU(int u) {
		this.u = u;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(int peso) {
		this.peso = peso;
	}
}