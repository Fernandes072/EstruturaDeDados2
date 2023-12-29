package atividade.arvoreavl;

import java.util.ArrayList;
import java.util.List;

public class NodoAVL {

	private Comparable chave;
	private Object valor;
	private NodoAVL esquerdo;
	private NodoAVL direito;
	private NodoAVL pai;
	private int altura;

	public NodoAVL(Comparable chave, Object valor) {
		this.chave = chave;
		this.valor = valor;
	}

	public Comparable getChave() {
		return chave;
	}
	
	public Object getValor() {
		return valor;
	}

	public NodoAVL getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NodoAVL esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NodoAVL getDireito() {
		return direito;
	}

	public void setDireito(NodoAVL direito) {
		this.direito = direito;
	}

	public NodoAVL getPai() {
		return pai;
	}

	public void setPai(NodoAVL pai) {
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
		NodoAVL novoNodo = this;
		while (novoNodo.getPai() != null) {
			novoNodo = novoNodo.getPai();
			resultado++;
		}
		return resultado;
	}

	public int altura() {
		return altura(this, 1, 1);
	}

	private int altura(NodoAVL nodo, int nivel, int resultado) {
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
	
	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
	}

	public int getFator() {
		return getAltura(direito) - getAltura(esquerdo);
	}

	private int getAltura(NodoAVL nodo) {
		if (nodo != null) {
			return nodo.getAltura();
		} else {
			return 0;
		}
	}
	
	public void atualizaAltura() {
		this.altura = Math.max(getAltura(direito), getAltura(esquerdo)) + 1; 
	}

	public boolean eRaiz() {
		return pai == null;
	}

	public boolean eFolha() {
		return esquerdo == null && direito == null;
	}
	
	public NodoAVL irmao() {
		if (pai != null) {
			if (this == pai.getEsquerdo()) {
				return pai.getDireito();
			} else if (this == pai.getDireito()) {
				return pai.getEsquerdo();
			}
		}
		return null;
	}
	
	public NodoAVL getMaior() {
		NodoAVL nodo = this;
		while (nodo.getDireito() != null) {
			nodo = nodo.getDireito();
		}
		return nodo;
	}
	
	public NodoAVL getMenor() {
		NodoAVL nodo = this;
		while (nodo.getEsquerdo() != null) {
			nodo = nodo.getEsquerdo();
		}
		return nodo;
	}
	
	public List<NodoAVL> pegaFilhos() {
		List<NodoAVL> filhos = new ArrayList<NodoAVL>();
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
	
	private int contagem(NodoAVL nodo, int cont) {
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
		return valor.toString();
	}
}
