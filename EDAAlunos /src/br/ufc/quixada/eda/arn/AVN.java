package br.ufc.quixada.eda.arn;

public class AVN<G> {
	
	private No<G> raiz;
	
	public boolean isPreto(No<G> no){
		if(no == null) return true;
		else if(no.isCor() == No.PRETO) return true;
		else return false;
	}
	
	public void inserir(int chave){
		raiz = inserir(raiz, chave);
		raiz.setCor(No.PRETO);
	}
	
	public No<G> inserir(No<G> raiz, int chave){
		if(raiz == null){
			No<G> no = new No<G>(chave);
			return no;
		}
		
		if(chave < raiz.getChave())
			raiz.setEsq(inserir(raiz.getEsq(), chave));
		else if(chave > raiz.getChave())
			raiz.setDir(inserir(raiz.getDir(), chave));
		if(!isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq())){
			raiz.setCor(No.VERMELHO);
			raiz.getEsq().setCor(No.PRETO);
			raiz.getDir().setCor(No.PRETO);
			
		}
		else if(!isPreto(raiz) && !isPreto(raiz.getDir()))
			raiz = rotacaoEsquerda(raiz);
		else if(isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getEsq().getEsq())){
			raiz = rotacaoDireita(raiz);
			raiz.setCor(No.PRETO);
			raiz.getDir().setCor(No.VERMELHO);
		}else if(!isPreto(raiz.getDir()) && !isPreto(raiz.getEsq()) && !isPreto(raiz.getDir().getDir())){
			raiz.setCor(No.VERMELHO);
			raiz.getEsq().setCor(No.PRETO);
			raiz.getDir().setCor(No.PRETO);
		}
		else if(!isPreto(raiz) && !isPreto(raiz.getEsq()))
			raiz = rotacaoDireita(raiz);
		else if(isPreto(raiz.getEsq()) && !isPreto(raiz.getDir()) && !isPreto(raiz.getDir().getDir())){
			raiz = rotacaoEsquerda(raiz);
			raiz.setCor(No.PRETO);
			raiz.getEsq().setCor(No.VERMELHO);
		}
		return raiz;
	}
	
	No<G> rotacaoDireita(No<G> no){
		No<G> aux = no.getEsq();
		no.setEsq(no.getEsq().getDir());
		aux.setDir(no);
		return aux;
	}
	
	public No<G> rotacaoEsquerda(No<G> no){
		No<G> aux = no.getDir();
		no.setDir(no.getDir().getEsq());
		aux.setEsq(no);
		return aux;
	}

}