package a04;

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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (raiz != null) {
			MontaString(raiz, sb);
		}
		return sb.toString();
	}

	private void MontaString(NodoAB nodo, StringBuilder sb) {
		if (nodo.getPai() != null) {
			sb.append(" ");
		}
		sb.append(nodo.getInfo());
		if (nodo.getFilhoEsquerdo() != null) {
			MontaString(nodo.getFilhoEsquerdo(), sb);
		}
		if (nodo.getFilhoDireito() != null) {
			MontaString(nodo.getFilhoDireito(), sb);
		}

	}
}
