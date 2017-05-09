package br.ufc.quixada.eda.lista;

import java.util.ArrayList;
import java.util.List;

public class No<T> {

	private Integer chave;
	private T valor;
	private No prox;
	private Integer proxInt;
	
	public No(Integer chave, T valor) {
		this.chave = chave;
		this.valor = valor;
	}
	
	public Integer getChave() {
		return chave;
	}
	public void setChave(Integer chave) {
		this.chave = chave;
	}
	public T getValor() {
		return valor;
	}
	public void setValor(T valor) {
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
		return "No [chave=" + chave + ", valor=" + valor + ", prox=" + prox
				+ "]";
	}
	
}