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

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		MontaString(raiz, sb);
		return sb.toString();
	}

	private void MontaString(NodoAB nodo, StringBuilder sb) {
		sb.append(nodo.getInfo() + "\n");
		if (nodo.getFilhoEsquerdo() != null) {
			MontaString(nodo.getFilhoEsquerdo(), sb);
		}
		if (nodo.getFilhoDireito() != null) {
			MontaString(nodo.getFilhoDireito(), sb);
		}

	}
}
