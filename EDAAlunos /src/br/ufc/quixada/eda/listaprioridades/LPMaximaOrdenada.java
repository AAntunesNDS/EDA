package br.ufc.quixada.eda.listaprioridades;

import java.util.List;

/**
 * Implementa a lista de prioridade usando vetor ordenado.
 * Reparem que aqui voc� devem utilizar obrigat�riamente o quickSort 
 * para realizar a ordena��o, quando for necess�rio.
 * @author fabio
 *
 */
public class LPMaximaOrdenada {
	private int nMaximo = 0;
	private int vetor[] = null;
	private int n = 0;
	
	public LPMaximaOrdenada(int Nmaximo){
		nMaximo = Nmaximo;
		vetor = new int[Nmaximo];
	}
	
	public void contruir(List<Integer> entrada){
		for (int i = 0; i < entrada.size(); i++)
			vetor[i] = entrada.get(i);
		this.n = entrada.size();
		quickSort(0, this.n - 1);
	}
	
	public int getMaximaPrioridade(){
		if(this.n > 0)
			return this.vetor[0];
		return 0;
	}
	
	public int remove(){
		if(this.n > 0){
			int aux = vetor[0];
			for (int i = 1; i < this.n; i++)
				this.vetor[i - 1] = this.vetor[i];
			this.n--;
			return aux;
		}
		return 0;
	}	
	
	public void inserir(int prioridade){
		if(this.nMaximo != this.n){
			int i;
			for (i = 0; i < this.n; i++)
				if(vetor[i] < prioridade)
					break;
			this.vetor[this.n] = prioridade;
			this.n++;
			for (int j = this.n - 1; j > i; j--){
				int aux = this.vetor[j];
				this.vetor[j] = this.vetor[j - 1];
				this.vetor[j - 1] = aux;
			}
		}
	}
	
	public void alterarPrioridade(int prioridade, int novaPrioridade){
		int i;
		for (i = 0; i < this.n && this.vetor[i] != prioridade; i++)
		if(i == this.n) return;
		vetor[i] = novaPrioridade;
		if(prioridade > novaPrioridade) IrPraDireita(i);
		else IrPraEsquerda(i);
	}
	
	private void IrPraEsquerda(int indice){
		for (int i = indice; i > 0 && this.vetor[i - 1] < this.vetor[i]; i--) {
			int aux = this.vetor[i - 1];
			this.vetor[i - 1] = this.vetor[i];
			this.vetor[i] = aux;
		}
	}
	
	private void IrPraDireita(int indice){
		for (int i = indice; i < this.n - 1 && this.vetor[i] < this.vetor[i + 1]; i++) {
			int aux = this.vetor[i + 1];
			this.vetor[i + 1] = this.vetor[i];
			this.vetor[i] = aux;
		}
	}
	
	private void quickSort(int ini, int fim){
        if(ini < fim){
        	int aux = particiona(ini, fim);
        	quickSort(ini, aux - 1);
        	quickSort(aux + 1, fim);
        }
	}
	
	private int particiona(int p, int r) {
        int pivo = this.vetor[p];
        int i = p + 1, f = r;
        while (i <= f) {
               if (this.vetor[i] >= pivo)
                      i++;
               else if (pivo > this.vetor[f])
                      f--;
               else {
                      int troca = this.vetor[i];
                      this.vetor[i] = this.vetor[f];
                      this.vetor[f] = troca;
                      i++;
                      f--;
               }
        }
        this.vetor[p] = this.vetor[f];
        this.vetor[f] = pivo;
        return f;
  }
	
	public String toString() {
		
		StringBuilder s = new StringBuilder();
		s.append("[");
		
		for (int i=0; i<this.n-1; i++){
			s.append(this.vetor[i]);
			s.append(", ");
		}
		
		if (this.n > 0){
			s.append(this.vetor[this.n-1]);
		}
		
		s.append("]");
		
		return s.toString();
	}}