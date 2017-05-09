package br.ufc.quixada.eda.hash;

public class Teste {
	public static void main(String[] args) {
		Hash<String> hash = new EnderecamentoInterno(10);
		//Hash<String> hash = new EnderecamentoExterno(10);
		hash.inserir(1, "Afonso");
		hash.inserir(10, "ArthurAntunes");
		hash.inserir(20, "Conflito");
		hash.inserir(6, "Teste");
		hash.inserir(12, "Neto");
		hash.inserir(24, "Fulano");
		hash.inserir(18, "Fabio");
		System.out.println(hash.toString());
		System.out.println(hash.remover(1));
		System.out.println(hash.toString());

	}
}