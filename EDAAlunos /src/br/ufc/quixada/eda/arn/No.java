package br.ufc.quixada.eda.arn;

public class No<G> {
	
	private No<G> esq;
	private No<G> dir;
	private int chave;
	private G info;
	private boolean cor;
	public static final boolean PRETO = true;
	public static final boolean VERMELHO = false;
	
	public No(int chave){
		this.chave = chave;
		this.cor = VERMELHO;
	}

	public No<G> getEsq() {
		return esq;
	}

	public void setEsq(No<G> esq) {
		this.esq = esq;
	}

	public No<G> getDir() {
		return dir;
	}

	public void setDir(No<G> dir) {
		this.dir = dir;
	}

	public int getChave() {
		return chave;
	}

	public void setChave(int chave) {
		this.chave = chave;
	}

	public boolean isCor() {
		return cor;
	}

	public void setCor(boolean cor) {
		this.cor = cor;
	}

	public G getInfo() {
		return info;
	}

	public void setInfo(G info) {
		this.info = info;
	}
	
}