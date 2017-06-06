package br.ufc.quixada.eda.avl;

public class NoAVL {

	private NoAVL dir,esq;
	private Integer altura,chave;

	public NoAVL(Integer chave) {
		dir = esq = null;
		altura = 0;
		this.chave = chave;
	}
	
	public NoAVL getDir() {
		return dir;
	}
	public void setDir(NoAVL dir) {
		this.dir = dir;
	}
	public NoAVL getEsq() {
		return esq;
	}
	public void setEsq(NoAVL esq) {
		this.esq = esq;
	}
	public Integer getAltura() {
		return altura;
	}
	public void setAltura(Integer altura) {
		this.altura = altura;
	}
	public Integer getChave() {
		return chave;
	}
	public void setChave(Integer chave) {
		this.chave = chave;
	}

	@Override
	public String toString() {
		return chave.toString();
	}
	
	
}