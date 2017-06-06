package br.ufc.quixada.eda.avl;

public class Teste {
	public static void main(String[] args) {
		ArvoreAVL avl = new ArvoreAVL(); 
		for (int i = 0; i < 5; i++) {
			avl.inserir(i);
			System.out.println(avl.toString());
		}
	}
	
}