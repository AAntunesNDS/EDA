package br.ufc.quixada.eda.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EDAUtil {
	/**
	 * Ler o arquivo que cont�m as prioridades iniciais da lista de prioridades.
	 * @param path
	 * @return
	 * @throws IOException
	 */
    public static List<Integer> getDadosIniciais(String path) throws IOException {
        List<Integer> entrada = new ArrayList<Integer>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter("\r\n");
		while (scanner.hasNext())
			entrada.add(scanner.nextInt());
		
		scanner.close();
        return entrada;
    }
    
    /**
     * Ler as opera��es que ser�o realizadas na lista de prioridades ap�s a sua cria��o.
     * @param path
     * @return
     * @throws IOException
     */
    public static List<Operacao> getOperacoes(String path) throws IOException {
        List<Operacao> operacoes = new ArrayList<Operacao>();
        Scanner scanner = new Scanner(new FileReader(path)).useDelimiter(" |\r\n");	        
        operacoes.add(new Operacao(scanner.nextInt(), scanner.nextInt()));
        while (scanner.hasNext()){
        	System.out.println(scanner.nextInt()+" " + scanner.nextInt()+" "+ scanner.nextInt());
        	//operacoes.add(new Operacao(scanner.nextInt(), scanner.nextInt(), scanner.nextInt()));
        	
        }
						
		scanner.close();
        return operacoes;
    }      
}
