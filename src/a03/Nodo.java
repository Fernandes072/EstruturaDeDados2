package a03;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
	
	private Object dado;
	private List<Nodo> filhos = new ArrayList<Nodo>();
	private Nodo pai;
	
	public Nodo() {
	}
	
	public Nodo(Object dado) {
		this.dado = dado;
	}

	public Object getDado() {
		return dado;
	}

	public List<Nodo> getFilhos() {
		return filhos;
	}
	
	public Nodo getPai() {
		return pai;
	}

	public void setPai(Nodo pai) {
		this.pai = pai;
	}

	public void adicionaFilho(Nodo filho) {
		filhos.add(filho);
		filho.setPai(this);
	}
	
	public Object[] pegaFilhos() {
		Object[] filhos = new Object[this.filhos.size()];
		int i = 0;
		for (Nodo nodo : this.filhos) {
			filhos[i] = nodo.getDado();
			i++;
		}
		return filhos;
	}
	
	public Object pegaPai() {
		return pai.getDado();
	}
	
	public boolean eRaiz() {
		return pai == null;
	}
	
	public boolean eFolha() {
		return filhos.size() == 0;
	}
	
	public int grau() {
		return filhos.size();
	}
	
	public int nivel() {
		int i = 1;
		Nodo nodo = this;
		while (nodo.getPai() != null) {
			nodo = nodo.getPai();
			i++;
		}
		return i;
	}
	
	public int contagem() {
		int i = 0;
		Nodo nodo = this;
		while (nodo.getPai() != null) {
			nodo = nodo.getPai();
			i++;
		}
		
		return contarNodos(nodo, i);
	}
	
	private static int contarNodos(Nodo nodo, int cont) {
		for (Nodo filho : nodo.filhos) {
			contarNodos(filho, cont+1);
		}
		return cont;
	}
	
	public Object busca(Object info) {
		Nodo nodo = raiz(this);
		
		return nodo.pegaPai();
	}
	
	private Nodo raiz(Nodo nodo) {
		while (nodo.getPai() != null) {
			nodo = nodo.getPai();
		}
		return nodo;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		prepararString(this, sb, 0);
		return sb.toString();
	}
	
	private static void prepararString(Nodo nodo, StringBuilder sb, int nivel) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(nodo.dado.toString());
		sb.append("\r\n");
		for (Nodo filho : nodo.filhos) {
			prepararString(filho, sb, nivel+1);
		}
	}
}
