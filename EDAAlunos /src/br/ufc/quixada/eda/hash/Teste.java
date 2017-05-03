package br.ufc.quixada.eda.hash;

public class Teste {
	public static void main(String[] args) {
		Hash hash = new EnderecamentoInterno(10);
		//Hash hash = new EnderecamentoExterno(10);
		hash.inserir(1, "Afonso");
		hash.inserir(10, "arthur");
		hash.inserir(20, "Conflito");
		hash.inserir(6, "Teste");
		hash.inserir(12, "Neto");
		hash.inserir(24, "fabio");
		hash.inserir(18, "Tal");
		System.out.println(hash.toString());
		System.out.println(hash.remover(1));
		System.out.println(hash.toString());

	}
}