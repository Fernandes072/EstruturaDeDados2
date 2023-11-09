package prova1;

import java.util.ArrayList;
import java.util.List;

public class Nodo {

	private Comparable info;
	private Nodo esquerdo;
	private Nodo direito;
	private Nodo pai;

	public Nodo(Comparable info) {
		this.info = info;
	}

	public Comparable getInfo() {
		return info;
	}

	public Nodo getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(Nodo esquerdo) {
		this.esquerdo = esquerdo;
	}

	public Nodo getDireito() {
		return direito;
	}

	public void setDireito(Nodo direito) {
		this.direito = direito;
	}

	public Nodo getPai() {
		return pai;
	}

	public void setPai(Nodo pai) {
		this.pai = pai;
	}

	public int grau() {
		int resultado = 0;
		if (esquerdo != null) {
			resultado++;
		}
		if (direito != null) {
			resultado++;
		}
		return resultado;
	}

	public int nivel() {
		int resultado = 1;
		Nodo novoNodo = this;
		while (novoNodo.getPai() != null) {
			novoNodo = novoNodo.getPai();
			resultado++;
		}
		return resultado;
	}

	public int altura() {
		return altura(this, 1, 1);
	}

	private int altura(Nodo nodo, int nivel, int resultado) {
		if (nivel > resultado) {
			resultado = nivel;
		}
		if (nodo.getEsquerdo() != null) {
			return altura(nodo.getEsquerdo(), nivel + 1, resultado);
		}
		if (nodo.getDireito() != null) {
			return altura(nodo.getDireito(), nivel + 1, resultado);
		}
		return resultado;
	}

	public boolean eRaiz() {
		return pai == null;
	}

	public boolean eFolha() {
		return esquerdo == null && direito == null;
	}
	
	public Nodo irmao() {
		if (pai != null) {
			if (this == pai.getEsquerdo()) {
				return pai.getDireito();
			} else if (this == pai.getDireito()) {
				return pai.getEsquerdo();
			}
		}
		return null;
	}
	
	public Nodo getMaior() {
		Nodo nodo = this;
		while (nodo.getDireito() != null) {
			nodo = nodo.getDireito();
		}
		return nodo;
	}
	
	public Nodo getMenor() {
		Nodo nodo = this;
		while (nodo.getEsquerdo() != null) {
			nodo = nodo.getEsquerdo();
		}
		return nodo;
	}
	
	public List<Nodo> pegaFilhos() {
		List<Nodo> filhos = new ArrayList<Nodo>();
		if (esquerdo != null) {
			filhos.add(esquerdo);
		}
		if (direito != null) {
			filhos.add(direito);
		}
		return filhos;
	}
	
	public int contagem() {
		return contagem(this, 0);
	}
	
	private int contagem(Nodo nodo, int cont) {
		cont++;
		if (nodo.getEsquerdo() != null) {
			cont = contagem(nodo.getEsquerdo(), cont);
		}
		if (nodo.getDireito() != null) {
			cont = contagem(nodo.getDireito(), cont);
		}
		return cont;
	}
	
	@Override
	public String toString() {
		return info.toString();
	}
}
