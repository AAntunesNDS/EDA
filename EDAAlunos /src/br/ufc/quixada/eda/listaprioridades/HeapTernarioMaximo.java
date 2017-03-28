package br.ufc.quixada.eda.listaprioridades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */

public class HeapTernarioMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapTernarioMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int j = (i + 1) / 3;
		if(j >= 1){
			if(this.vetor[i] > this.vetor[j]){
				int aux = this.vetor[i];
				this.vetor[i] = this.vetor[j];
				this.vetor[j] = aux;
				subir(j);
			}
		}
	}
	
	private void descer(int i){
		int j = 3 * i;
		if(j <= this.n){
			if(j + 1 <= this.n){
				if(this.vetor[j - 1] > this.vetor[j] && this.vetor[j - 1] > this.vetor[j + 1]) j--;
				else if(this.vetor[j + 1] > this.vetor[j]) j++;
			}else{
				if(this.vetor[j] < this.vetor[j - 1]) j--;
			}
			if(this.vetor[i] < this.vetor[j]){
				int aux = this.vetor[i];
				this.vetor[i] = this.vetor[j];
				this.vetor[j] = aux;
				descer(j);
			}
		}else if(j - 1 <= this.n){
			j--;
			if(this.vetor[i] < this.vetor[j]){
				int aux = this.vetor[i];
				this.vetor[i] = this.vetor[j];
				this.vetor[j] = aux;
				descer(j);
			}
		}
	}
	
	
	public void construir(List<Integer> entrada){
		for (int i = 1; i <= entrada.size(); i++) {
			vetor[i] = entrada.get(i - 1);
		}
		n = entrada.size();
		for (int i = (this.n / 3); i >= 1; i--)
			descer(i);
	}
	
	public int getMaximaPrioridade(){
		if(this.n > 0)
			return this.vetor[1];
		return 0;
	}
	
	public int remove(){
		if(this.n > 0){
			int aux = this.vetor[1];
			this.vetor[1] = this.vetor[n];
			this.n--;
			descer(1);
			return aux;
		}
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(this.n != this.nMaximo){
			vetor[this.n + 1] = prioridade;
			this.n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		int i;
		for (i = 1; i <= this.n && this.vetor[i] != prioridade; i++)
		if(i > this.n) return;
		vetor[i] = novaPrioridade;
		if(prioridade > novaPrioridade) descer(i);
		else subir(i);
	}
	
	public void mostrarHeap(){
		
		for(int i = 1; i <= n; i++){
			System.out.print(vetor[i] + " ");
		}
		System.out.println("\n");
	}
	/*
	public static void main(String[] args) {
		HeapTernarioMaximo heap = new HeapTernarioMaximo(20);
		List<Integer> entrada = new ArrayList<Integer>();
		entrada.add(20);
		entrada.add(40);
		entrada.add(10);
		entrada.add(50);
		entrada.add(70);
		entrada.add(80);
		entrada.add(90);
		entrada.add(22);
		entrada.add(24);
		entrada.add(15);
		
		System.out.println("Entradas: " + entrada.toString());
		heap.contruir(entrada);
		System.out.print("Heap Ternario ");
		heap.mostrarHeap();
	}
	*/
	}