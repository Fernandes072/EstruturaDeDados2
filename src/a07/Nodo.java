package a07;

public class Nodo {
	
	private Comparable info;
	private Nodo esquerdo;
	private Nodo direito;
	private Nodo pai;
	
	public Nodo (Comparable info) {
		this.info = info;
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
	
	@Override
	public String toString() {
		return info.toString();
	}
}
