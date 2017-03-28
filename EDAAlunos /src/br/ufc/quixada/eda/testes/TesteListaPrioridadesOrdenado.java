package br.ufc.quixada.eda.testes;

import java.io.IOException;
import java.util.List;

import br.ufc.quixada.eda.listaprioridades.LPMaximaOrdenada;
import br.ufc.quixada.eda.util.CriarInstancia;
import br.ufc.quixada.eda.util.EDAConstants;
import br.ufc.quixada.eda.util.EDAUtil;
import br.ufc.quixada.eda.util.Operacao;

public class TesteListaPrioridadesOrdenado {
	public static void main(String args[]){		
		try {
			for (int tamanho : CriarInstancia.tamanhoInstancias) {				
				String path = EDAConstants.caminhoPasta + "tarefa" + tamanho + ".txt";
				List<Integer> entrada = EDAUtil.getDadosIniciais(path);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE INSER��ES
				String arquivoOperacao = "operacoesI_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				List<Operacao> operacoes = EDAUtil.getOperacoes(path);
				
				long tempoInicial = System.currentTimeMillis();				
				LPMaximaOrdenada listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					switch (operacao.getId()) {
					case "I":
						listaPrioridade.inserir(operacao.getValor());
						break;
					case "R":
						listaPrioridade.remove();
						break;
					case "A":
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
						break;
					case "S":
						listaPrioridade.getMaximaPrioridade();
						break;
					default:
						break;
					}
				}	
				long tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);
				
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE ALTERA��ES
				arquivoOperacao = "operacoesA_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					switch (operacao.getId()) {
					case "I":
						listaPrioridade.inserir(operacao.getValor());
						break;
					case "R":
						listaPrioridade.remove();
						break;
					case "A":
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
						break;
					case "S":
						listaPrioridade.getMaximaPrioridade();
						break;
					default:
						break;
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);		
				
			
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE REMOÇÂO
				arquivoOperacao = "operacoesR_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					switch (operacao.getId()) {
					case "I":
						listaPrioridade.inserir(operacao.getValor());
						break;
					case "R":
						listaPrioridade.remove();
						break;
					case "A":
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
						break;
					case "S":
						listaPrioridade.getMaximaPrioridade();
						break;
					default:
						break;
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);		
			
				//PARA ARQUIVO COM MAIOR QUANTIDADE DE SELEÇÂO
				arquivoOperacao = "operacoesS_" + tamanho;
				path = EDAConstants.caminhoPasta + arquivoOperacao + ".txt";
				operacoes = EDAUtil.getOperacoes(path);
				
				tempoInicial = System.currentTimeMillis();				
				listaPrioridade = new LPMaximaOrdenada(2*entrada.size());
				listaPrioridade.contruir(entrada);							
			
				for (Operacao operacao : operacoes) {
					switch (operacao.getId()) {
					case "I":
						listaPrioridade.inserir(operacao.getValor());
						break;
					case "R":
						listaPrioridade.remove();
						break;
					case "A":
						listaPrioridade.alterarPrioridade(operacao.getValor(), operacao.getNovoValor());
						break;
					case "S":
						listaPrioridade.getMaximaPrioridade();
						break;
					default:
						break;
					}
				}	
				tempo = System.currentTimeMillis() - tempoInicial;			  
				System.out.println(arquivoOperacao + ": " + tempo);		
			
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("FIM");
	}
}
