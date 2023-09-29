package a04.observer;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria {

	private NodoAB raiz;
	private int tamanho;

	public ArvoreBinaria() {

	}

	public int getTamanho() {
		return tamanho;
	}

	public NodoAB getRaiz() {
		return raiz;
	}

	public NodoAB criaRaiz(Object info) {
		if (raiz != null) {
			throw new RuntimeException("Raiz já existe");
		}
		tamanho++;
		return raiz = new NodoAB(info);
	}

	public NodoAB adicionaEsquerdo(NodoAB pai, Object info) {
		if (pai.getFilhoEsquerdo() != null) {
			throw new RuntimeException("Filho esquerdo já existe");
		}
		NodoAB nodo = new NodoAB(info);
		pai.setFilhoEsquerdo(nodo);
		nodo.setPai(pai);
		tamanho++;
		return nodo;
	}

	public NodoAB adicionaDireito(NodoAB pai, Object info) {
		if (pai.getFilhoDireito() != null) {
			throw new RuntimeException("Filho direito já existe");
		}
		NodoAB nodo = new NodoAB(info);
		pai.setFilhoDireito(nodo);
		nodo.setPai(pai);
		tamanho++;
		return nodo;
	}

	public void removerNodo(NodoAB nodo) {
		if (nodo == raiz) {
			raiz = null;
		} else {
			NodoAB pai = nodo.getPai();
			if (pai.getFilhoEsquerdo() != null) {
				if (pai.getFilhoEsquerdo().equals(nodo)) {
					pai.setFilhoEsquerdo(null);
				}
			}
			if (pai.getFilhoDireito() != null) {
				if (pai.getFilhoDireito().equals(nodo)) {
					pai.setFilhoDireito(null);
				}
			}
		}
	}

	public int grau(NodoAB nodo) {
		int sub = 0;
		if (nodo.getFilhoDireito() != null) {
			sub++;
		}
		if (nodo.getFilhoEsquerdo() != null) {
			sub++;
		}
		return sub;
	}

	public int nivel(NodoAB nodo) {
		int nivel = 1;
		while (nodo.getPai() != null) {
			nivel++;
			nodo = nodo.getPai();
		}
		return nivel;
	}

	public int altura(NodoAB nodo) {
		return pegaAltura(nodo, 1, 1);
	}

	private int pegaAltura(NodoAB nodo, int nivel, int fim) {
		if (nivel > fim) {
			fim = nivel;
		}
		if (nodo.getFilhoEsquerdo() != null) {
			fim = pegaAltura(nodo.getFilhoEsquerdo(), nivel + 1, fim);
		}
		if (nodo.getFilhoDireito() != null) {
			fim = pegaAltura(nodo.getFilhoDireito(), nivel + 1, fim);
		}
		return fim;
	}

	public NodoAB busca(Object info) {
		return pegaBusca(raiz, info, new NodoAB(null));
	}

	private NodoAB pegaBusca(NodoAB nodo, Object info, NodoAB elemento) {
		if (nodo.getInfo().equals(info)) {
			return nodo;
		}
		if (nodo.getFilhoEsquerdo() != null) {
			elemento = pegaBusca(nodo.getFilhoEsquerdo(), info, elemento);
		}
		if (nodo.getFilhoDireito() != null) {
			elemento = pegaBusca(nodo.getFilhoDireito(), info, elemento);
		}
		return elemento;
	}

	public NodoAB irmao(NodoAB nodo) {
		if (nodo.getPai() != null) {
			NodoAB pai = nodo.getPai();
			if (pai.getFilhoEsquerdo().equals(nodo)) {
				return pai.getFilhoDireito();
			} else {
				return pai.getFilhoEsquerdo();
			}
		}
		return null;
	}

	public ArvoreBinaria copia() {
		ArvoreBinaria novaArvore = new ArvoreBinaria();
		NodoAB novaRaiz = novaArvore.criaRaiz(raiz.getInfo());
		return criaArvoreCopia(novaArvore, novaRaiz, raiz);
	}

	private ArvoreBinaria criaArvoreCopia(ArvoreBinaria novaArvore, NodoAB novoNodo, NodoAB nodo) {
		if (nodo.getPai() == null) {
			novoNodo.setInfo(nodo.getInfo());
		}

		if (nodo.getPai() != null) {
			if (nodo.getPai().getFilhoEsquerdo().equals(nodo)) {
				novoNodo = novaArvore.adicionaEsquerdo(novoNodo, nodo.getInfo());
			}
			if (nodo.getPai().getFilhoDireito().equals(nodo)) {
				novoNodo = novaArvore.adicionaDireito(novoNodo, nodo.getInfo());
			}
		}
		if (nodo.getFilhoEsquerdo() != null) {
			criaArvoreCopia(novaArvore, novoNodo, nodo.getFilhoEsquerdo());
		}
		if (nodo.getFilhoDireito() != null) {
			criaArvoreCopia(novaArvore, novoNodo, nodo.getFilhoDireito());
		}
		return novaArvore;
	}

	public boolean vazia() {
		return raiz == null;
	}

	public boolean eRaiz(NodoAB nodo) {
		return nodo.getPai() == null;
	}

	public boolean eFolha(NodoAB nodo) {
		return nodo.getFilhoEsquerdo() == null && nodo.getFilhoDireito() == null;
	}

	public NodoAB pai(NodoAB nodo) {
		return nodo.getPai();
	}

	public List<NodoAB> filhos(NodoAB nodo) {
		List<NodoAB> filhos = new ArrayList<>();
		filhos.add(nodo.getFilhoEsquerdo());
		filhos.add(nodo.getFilhoDireito());
		return filhos;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (raiz != null) {
			MontaString(raiz, sb);
		}
		return sb.toString();
	}

	private void MontaString(NodoAB nodo, StringBuilder sb) {
		if (nodo.getFilhoEsquerdo() != null && nodo.getFilhoDireito() != null) {
			sb.append("(");
		}
		if (nodo.getFilhoEsquerdo() != null) {
			MontaString(nodo.getFilhoEsquerdo(), sb);
		}
		sb.append(nodo.getInfo());
		if (nodo.getFilhoDireito() != null) {
			MontaString(nodo.getFilhoDireito(), sb);
		}
		if (nodo.getFilhoEsquerdo() != null && nodo.getFilhoDireito() != null) {
			sb.append(")");
		}
	}

	public void travessiaPreOrdem(Visitante visitante) {
		travessiaPreOrdem(raiz, visitante);
	}

	private void travessiaPreOrdem(NodoAB nodo, Visitante visitante) {
		if (nodo != null) {
			visitante.visita(nodo);
		}
		if (nodo.getFilhoEsquerdo() != null) {
			travessiaPreOrdem(nodo.getFilhoEsquerdo(), visitante);
		}
		if (nodo.getFilhoDireito() != null) {
			travessiaPreOrdem(nodo.getFilhoDireito(), visitante);
		}
	}

	public void travessiaEmOrdem(Visitante visitante) {
		travessiaEmOrdem(raiz, visitante);
	}

	private void travessiaEmOrdem(NodoAB nodo, Visitante visitante) {
		if (nodo.getFilhoEsquerdo() != null) {
			travessiaEmOrdem(nodo.getFilhoEsquerdo(), visitante);
		}
		if (nodo != null) {
			visitante.visita(nodo);
		}
		if (nodo.getFilhoDireito() != null) {
			travessiaEmOrdem(nodo.getFilhoDireito(), visitante);
		}
	}

	public void travessiaPosOrdem(Visitante visitante) {
		travessiaPosOrdem(raiz, visitante);
	}

	private void travessiaPosOrdem(NodoAB nodo, Visitante visitante) {
		if (nodo.getFilhoEsquerdo() != null) {
			travessiaPosOrdem(nodo.getFilhoEsquerdo(), visitante);
		}
		if (nodo.getFilhoDireito() != null) {
			travessiaPosOrdem(nodo.getFilhoDireito(), visitante);
		}
		if (nodo != null) {
			visitante.visita(nodo);
		}
	}

	public int operacao() {
		if (raiz != null) {
			return montaSoma(raiz, 0, "", 0);
		}
		return 0;
	}

	private int montaSoma(NodoAB nodo, int total, String operacao, int esq) {
		if (nodo.getInfo().equals("+") || nodo.getInfo().equals("x") || nodo.getInfo().equals("/")
				|| nodo.getInfo().equals("-")) {
			operacao = nodo.getInfo().toString();
		}

		if (!nodo.getInfo().equals("+") && !nodo.getInfo().equals("x") && !nodo.getInfo().equals("/")
				&& !nodo.getInfo().equals("-")) {
			if (nodo.getPai().getFilhoEsquerdo().equals(nodo)) {
				esq = Integer.parseInt(nodo.getInfo().toString());
				return esq;
			}
		}

		if (!nodo.getInfo().equals("+") && !nodo.getInfo().equals("x") && !nodo.getInfo().equals("/")
				&& !nodo.getInfo().equals("-")) {
			if (nodo.getPai().getFilhoDireito().equals(nodo)) {
				if (operacao.equals("+")) {
					total += esq + Integer.parseInt(nodo.getInfo().toString());
				} else if (operacao.equals("-")) {
					total += esq - Integer.parseInt(nodo.getInfo().toString());
				}
			}
		}

		if (nodo.getFilhoEsquerdo() != null) {
			total = montaSoma(nodo.getFilhoEsquerdo(), total, operacao, esq);
		}
		if (nodo.getFilhoDireito() != null) {
			total = montaSoma(nodo.getFilhoDireito(), total, operacao, esq);
		}
		
		return total;

	}

	/*
	 * private int montaSoma(NodoAB nodo, int total, String operacao, int esq) { if
	 * (nodo.getInfo().equals("+") || nodo.getInfo().equals("x") ||
	 * nodo.getInfo().equals("/") || nodo.getInfo().equals("-")) { operacao =
	 * nodo.getInfo().toString(); }
	 * 
	 * if (!nodo.getInfo().equals("+") && !nodo.getInfo().equals("x") &&
	 * !nodo.getInfo().equals("/") && !nodo.getInfo().equals("-")) { if
	 * (nodo.getPai().getFilhoEsquerdo().equals(nodo)) { esq =
	 * Integer.parseInt(nodo.getInfo().toString()); return esq; }
	 * 
	 * }
	 * 
	 * if (nodo.getFilhoEsquerdo() != null) { total =
	 * montaSoma(nodo.getFilhoEsquerdo(), total, operacao, esq); } if
	 * (nodo.getFilhoDireito() != null) { total = montaSoma(nodo.getFilhoDireito(),
	 * total, operacao, esq); } if (!nodo.getInfo().equals("+") &&
	 * !nodo.getInfo().equals("x") && !nodo.getInfo().equals("/") &&
	 * !nodo.getInfo().equals("-")) { if
	 * (nodo.getPai().getFilhoDireito().equals(nodo)) { if (operacao.equals("+")) {
	 * total += esq + Integer.parseInt(nodo.toString()); } else if
	 * (operacao.equals("-")) { total += esq - Integer.parseInt(nodo.toString()); }
	 * else if (operacao.equals("x")) { total += esq *
	 * Integer.parseInt(nodo.toString()); } else if (operacao.equals("/")) { total
	 * += esq / Integer.parseInt(nodo.toString()); } } } return total;
	 * 
	 * }
	 */

	/*
	 * public int soma() { if (raiz != null) { return montaSoma(raiz, 0, "", 0); }
	 * return 0; }
	 * 
	 * 
	 * private int MontaSoma(NodoAB nodo, int total, String operacao, int esq) {
	 * 
	 * if (nodo.getFilhoEsquerdo() != null) { total =
	 * MontaSoma(nodo.getFilhoEsquerdo(), total, operacao, esq); } if
	 * (!nodo.getInfo().equals("+") && !nodo.getInfo().equals("x") &&
	 * !nodo.getInfo().equals("/") && !nodo.getInfo().equals("-")) { if
	 * (nodo.getPai().getFilhoEsquerdo().equals(nodo)) { esq =
	 * Integer.parseInt(nodo.getInfo().toString()); if
	 * (nodo.getPai().getInfo().equals("+")) { total += esq +
	 * Integer.parseInt(nodo.getPai().getFilhoDireito().toString()); } else if
	 * (nodo.getPai().getInfo().equals("-")) { total += esq -
	 * Integer.parseInt(nodo.getPai().getFilhoDireito().toString()); } else if
	 * (nodo.getPai().getInfo().equals("x")) { total += esq *
	 * Integer.parseInt(nodo.getPai().getFilhoDireito().toString()); } else if
	 * (nodo.getPai().getInfo().equals("/")) { total += esq /
	 * Integer.parseInt(nodo.getPai().getFilhoDireito().toString()); } } operacao =
	 * nodo.getPai().toString(); } if (nodo.getFilhoDireito() != null) { total =
	 * MontaSoma(nodo.getFilhoDireito(), total, operacao, esq); } return total;
	 * 
	 * }
	 */
}
