package br.ufc.quixada.eda.listaprioridades;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;

/**
 * Implementa a lista de prioridade usando Heap Maximo.
 * @author fabio
 *
 */

public class HeapMaximo {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public HeapMaximo(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	private void subir(int i){
		int j = i/2;
		
		if(j >= 1){
			if(vetor[j] < vetor[i]){
				int aux = vetor[j];
	            vetor[j] = vetor[i];
	            vetor[i] = aux;
	            
	            subir(j);
			}
		}
	}

	private void subirIncremental(int i){
		int j = i/2;
		
		while (vetor[j] < vetor[i]) {		
			if(vetor[j] < vetor[i]){
				int aux = vetor[j];
	            vetor[j] = vetor[i];
	            vetor[i] = aux;
	            
	            j = i/2;
			}
		}
	}
	
	
	private void descer(int i){
		int j = 2*i;
		
		if(j <= n){
			if(j + 1 <= n && vetor[j + 1] > vetor[j]){
				j++;
			}
			if(vetor[j] > vetor[i]){
				int aux = vetor[j];
	            vetor[j] = vetor[i];
	            vetor[i] = aux;
	            
	            descer(j);
			}
		}
	}
	private void descerIncremental(int i){
		int j = 2*i;
		
		while(vetor[j] > vetor[i]){
			if(j + 1 <= n && vetor[j + 1] > vetor[j]){
				j++;
			}
			int aux = vetor[j];
            vetor[j] = vetor[i];
            vetor[i] = aux;
            
            j = 2*i;
		}
	}
	
	public void construir(List<Integer> entrada){
		n = entrada.size();
		
		for(int i = 1; i < n; i++){
			vetor[i] = entrada.get(i);
		}
		for(int j = n/2; j >= 1; j--){
			descerIncremental(j);
		}
	}
	
	public int getMaximaPrioridade(){
		int maxima = 0;
		
		for(int i = 1; i < n; i++){
			if(vetor[i] > vetor[maxima]){
				maxima = i; 
			}
		}
		return vetor[maxima];
	}
	
	public int remove(){
		if(n >= 1){
			int aux = vetor[0];
			vetor[0] = vetor[n - 1];
			vetor[n - 1] = aux;
			n--;
			descer(0);
			return aux;
		}
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(n + 1 <= nMaximo){
			vetor[n] = prioridade;
			n++;
			subir(n);
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		for(int i = 0; i < n; i++){
			if(vetor[i] == prioridade){
				vetor[i] = novaPrioridade;
				subirIncremental(i);
				break;
			}
		}
	}	
	
	public void mostrarHeap(){
		
		for(int i = 0; i < n; i++){
			System.out.print(vetor[i] + " ");
		}
		System.out.println("\n");
	}

	@Override
	public String toString() {
		return "HeapMaximo [vetor=" + Arrays.toString(vetor) + "]";
	}

	public static void main(String[] args) {
		HeapMaximo heap = new HeapMaximo(10);
		List<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		list.add(50);
		list.add(60);
		list.add(70);
		list.add(80);
		list.add(40);
		list.add(90);
		list.add(30);
		
		System.out.println("HeapMaximo");
		heap.construir(list);
		
		System.out.println(heap.toString());
		
	}
	
}