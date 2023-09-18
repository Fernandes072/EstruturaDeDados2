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

	public List<Nodo> pegaFilhos() {
		return filhos;
	}

	public Nodo pegaPai() {
		return pai;
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

	public int altura() {
		return pegarAltura(this, 1, 1);
	}

	private static int pegarAltura(Nodo nodo, int nivel, int fim) {
		if (nivel > fim) {
			fim = nivel;
		}
		for (Nodo filho : nodo.filhos) {
			fim = pegarAltura(filho, nivel + 1, fim);
		}
		return fim;
	}

	public int contagem() {
		// return contarNodos(raiz(this), 1); para contar todos os elementos
		return contarNodos(this, 1); // conta os elementos do nó
	}

	private static int contarNodos(Nodo nodo, int cont) {
		for (Nodo filho : nodo.filhos) {
			cont = 1 + contarNodos(filho, cont);
		}
		return cont;
	}

	public Nodo busca(Object info) {
		Nodo nodo = encontrarBusca(this, info, new Nodo());
		if (nodo.dado != null) {
			return nodo;
		}
		return null;
	}

	private static Nodo encontrarBusca(Nodo nodo, Object info, Nodo elemento) {
		if (info.equals(nodo.dado)) {
			System.out.println("achou");
			return nodo;
		}
		for (Nodo filho : nodo.filhos) {
			elemento = encontrarBusca(filho, info, elemento);
		}
		return elemento;
	}

	public void remove(Nodo nodo) {
		nodo.pai.filhos.remove(nodo);
	}

	public List<Nodo> irmaos() {
		List<Nodo> irmaos = new ArrayList<Nodo>();
		for (Nodo irmao : pai.filhos) {
			if (irmao != this) {
				irmaos.add(irmao);
			}
		}
		return irmaos;
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
			prepararString(filho, sb, nivel + 1);
		}
	}

	private static void prepararString2(Nodo nodo, StringBuilder sb, int nivel) {
		sb.append("(");
		sb.append(nodo.dado.toString());
		if (!nodo.eFolha()) {
			sb.append("(");
			for (Nodo filho : nodo.filhos) {
				prepararString2(filho, sb, nivel + 1);
			}
			sb.append(")");
		}
		sb.append(")");
	}
}
