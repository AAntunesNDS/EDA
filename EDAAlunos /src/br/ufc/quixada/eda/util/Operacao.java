package br.ufc.quixada.eda.util;

/**
 * Classe respons�vel por armazenar uma opera��o que ser� realizada na lista de prioridade.
 * O atributo id cont�m o identificador da opera��o sendo as seguintes possibilidades: Inser��o: I; Remo��o: R; Altera��o: A; S: Sele��o.
 * O atributo valor ter� o valor a ser inserido, o valor que foi removido, o valor que ser� alterado e o valor com maior prioridade, respectivamente para as opera��es de inser��o, remo��o, altera��o e sele��o.
 * O atributo novoValor ter� o novo valor da prioridade para a opera��o de altera��o. Para as demais opera��es ele ter� valor 0(zero).  
 * @author fabio
 *
 */
public class Operacao {
	private Integer x;
	private Integer y;
	private Integer peso;
	
	public Operacao(Integer x, Integer y, Integer peso) {
		this.x = x;
		this.y = y;
		this.peso = peso;
	}
	public Operacao(Integer x, Integer y) {
		this.x = x;
		this.y = y;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
		this.y = y;
	}

	public Integer getPeso() {
		return peso;
	}

	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
}