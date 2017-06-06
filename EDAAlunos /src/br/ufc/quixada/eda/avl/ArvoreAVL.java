package br.ufc.quixada.eda.avl;

import java.util.LinkedList;

public class ArvoreAVL {
		private NoAVL raiz = null;
		
		public void inserir (int chave){
			this.raiz = inserir(this.raiz, chave);
		}
		
		private NoAVL inserir (NoAVL raiz, int chave){
			if(raiz == null){
				raiz = new NoAVL(chave);
				return raiz;
			}else if(raiz.getChave() > chave){
				raiz.setEsq(inserir(raiz.getEsq(), chave));				
				if(altura(raiz.getEsq()) - altura(raiz.getDir()) == 2){
					if(raiz.getEsq().getChave() > chave){
						raiz = rotacaoEsq(raiz);
					}else{
						raiz = rotacaoDuplaEsq(raiz);
					}
				}			
			}else if(raiz.getChave() < chave){
				raiz.setDir(inserir(raiz.getDir(), chave));
				if(altura(raiz.getDir()) - altura(raiz.getEsq()) == 2){
					if(raiz.getDir().getChave() > chave){
						raiz = rotacaoDir(raiz);				
					}else{
						raiz = rotacaoDuplaDir(raiz);
					}
				}
			}
			raiz.setAltura(max (altura (raiz.getEsq()), altura (raiz.getDir()) + 1));
			return raiz;
		}
		
		private int altura(NoAVL raiz){
			return raiz == null ? 0 : raiz.getAltura();
		}
		
		private int max(int dir, int esq){
			return dir > esq ? dir : esq;
		}
		
		private NoAVL rotacaoEsq(NoAVL raiz){		
			if(raiz.getEsq() == null) return raiz;
			NoAVL aux = raiz.getEsq();
		    raiz.setEsq(aux.getDir());
		    aux.setDir(raiz);
		    
		    raiz.setAltura(max( altura( raiz.getEsq() ), altura( raiz.getDir())) + 1);
		    aux.setAltura(max( altura( aux.getEsq() ), raiz.getAltura()) + 1);
		    return raiz;
		}

		private NoAVL rotacaoDir(NoAVL raiz){
			if(raiz.getDir() == null) return raiz;
			NoAVL aux = raiz.getDir();
			raiz.setDir(aux.getEsq());
			aux.setEsq(raiz);
			
			raiz.setAltura(max( altura( raiz.getEsq()), altura( raiz.getDir() ) ) + 1);
	        aux.setAltura(max( altura( aux.getDir() ), raiz.getAltura() ) + 1);
	        return aux;		
		}
		
		private NoAVL rotacaoDuplaEsq(NoAVL raiz){
			raiz.setEsq(rotacaoDir(raiz.getEsq()));
			return rotacaoEsq(raiz);
		}

		private NoAVL rotacaoDuplaDir(NoAVL raiz){
			raiz.setDir(rotacaoEsq(raiz.getDir()));
			return rotacaoDir(raiz);
		}
	@Override
	public String toString() {
		return imprimirArvore(raiz);
	}
	
	private String imprimirArvore(NoAVL raiz) {
		String saida = "";
		LinkedList<NoAVL> fila = new LinkedList<NoAVL>();
		fila.add(raiz);
		while (fila.size() !=0) {
			NoAVL atual = fila.removeFirst();
			saida += atual.toString() + " "; 
			if (atual.getEsq() != null ) fila.add(atual.getEsq());
			else saida +=  "FE "; 
			if (atual.getDir() != null ) fila.add(atual.getDir());
			else saida +=  "FD ";
			
			
		}
		
		return saida;
	}
	
}