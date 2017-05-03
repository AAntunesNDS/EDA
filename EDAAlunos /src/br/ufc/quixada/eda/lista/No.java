	package br.ufc.quixada.eda.lista;

import java.util.ArrayList;
import java.util.List;

public class No {

	private Integer chave;
	private String valor;
	private No prox;
	private Integer proxInt;
	
	public No(Integer chave, String valor) {
		this.chave = chave;
		this.valor = valor;
	}
	
	public Integer getChave() {
		return chave;
	}
	public void setChave(Integer chave) {
		this.chave = chave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public No getProx() {
		return prox;
	}
	public void setProx(No prox) {
		this.prox = prox;
	}

	public Integer getProxInt() {
		return proxInt;
	}

	public void setProxInt(Integer proxInt) {
		this.proxInt = proxInt;
	}

	@Override
	public String toString() {
		return chave + ": " + valor + " |"
				+ proxInt;
	}
	
	
}