package br.ufc.quixada.eda.algoritmo;



import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.grafo.Aresta;
import br.ufc.quixada.eda.grafo.Grafo;
import br.ufc.quixada.eda.util.*;

public class TesteDijkstra {
	public static void main(String args[]){		
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				for (int i = 0; i < 4; i++) {
					
					String arquivoOperacao = "tb8ch" + tamanho + "_" + i;
					String path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
					List<Operacao> operacoes = EDAUtil.getOperacoes(path);
					
					long tempoInicial = System.currentTimeMillis();				
					Grafo g = new Grafo(operacoes.get(0).getX(),operacoes.get(0).getY());
					operacoes.remove(0);
			
					for (Operacao operacao : operacoes) {
						Aresta aux = new Aresta(operacao.getX(), operacao.getY(), operacao.getPeso());
						g.add(aux);
					}
					//Dijkstra d = new Dijkstra(g, 0);
					//d.executar(g);
					long tempo = System.currentTimeMillis() - tempoInicial;			  
					
				}
				break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}