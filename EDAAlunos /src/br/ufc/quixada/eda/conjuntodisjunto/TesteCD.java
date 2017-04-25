package br.ufc.quixada.eda.conjuntodisjunto;

import java.util.ArrayList;
import java.util.List;

/*
 * Classe de Teste para ConjuntoDisjunto e ConjuntoDisjuntoLE   
 */
public class TesteCD {
	public static void main(String[] args) {	
		ConjuntoDisjuntoI conjunto = new ConjuntoDisjunto(15);
		//ConjuntoDisjuntoI conjunto = new ConjuntoDisjuntoLE();
		List<Integer> entrada = new ArrayList<Integer>();
		entrada.add(1);
		entrada.add(2);
		entrada.add(3);
		entrada.add(4);
		entrada.add(5);
		entrada.add(6);
		entrada.add(7);
		entrada.add(8);
		entrada.add(9);
		entrada.add(10);
		conjunto.makeSet(entrada);
		System.out.println(conjunto.toString());
		conjunto.union(1, 2);
		conjunto.union(2, 3);
		System.out.println(conjunto.toString());
		conjunto.union(5, 6);
		conjunto.union(6, 7);
		System.out.println(conjunto.toString());
		conjunto.union(1, 6);
		System.out.println(conjunto.toString());
		conjunto.union(1, 10);
		System.out.println(conjunto.toString());
	}	

}
