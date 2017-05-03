
package br.ufc.quixada.eda.hash;

public class Teste {
	public static void main(String[] args) {
		Hash hash = new EnderecamentoInterno(10);
		//Hash hash = new EnderecamentoExterno(10);
		hash.inserir(1, "Arthur");
		hash.inserir(10, "Afonso");
		hash.inserir(20, "Conflito");
		//hash.inserir(6, "Teste");
		hash.inserir(3, "Neto");
		hash.inserir(5, "Fulano");
		hash.inserir(9, "Tal");
		System.out.println(hash.toString());
		
	}
}