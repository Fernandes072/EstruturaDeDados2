package a06;

public class ArvoreBinaria {

	private NodoAB raiz;
	private int tamanho;

	public ArvoreBinaria() {

	}

	public NodoAB adiciona(Object info) {
		if (tamanho == 0) {
			return criaRaiz(info);
		} else {
			return adiciona(info, raiz);
		}
	}

	private NodoAB adiciona(Object info, NodoAB nodo) {
		if (((Float) info) < ((Float) nodo.getInfo())) {
			if (nodo.getEsquerdo() == null) {
				return adicionaEsquerdo(nodo, info);
			}
			adiciona(info, nodo.getEsquerdo());
		} else if (((Float) info) > ((Float) nodo.getInfo())) {
			if (nodo.getDireito() == null) {
				return adicionaDireito(nodo, info);
			}
			adiciona(info, nodo.getDireito());
		}
		return null;
	}

	private NodoAB criaRaiz(Object info) {
		NodoAB nodo = new NodoAB(info);
		raiz = nodo;
		tamanho++;
		return nodo;
	}

	private NodoAB adicionaEsquerdo(NodoAB pai, Object info) {
		if (pai.getEsquerdo() != null) {
			throw new RuntimeException("Já possui filho esquerdo");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setEsquerdo(nodo);
		tamanho++;
		return nodo;
	}

	private NodoAB adicionaDireito(NodoAB pai, Object info) {
		if (pai.getDireito() != null) {
			throw new RuntimeException("Já possui filho direito");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setDireito(nodo);
		tamanho++;
		return nodo;
	}

	public NodoAB busca(Object info) {
		return busca(info, raiz, new NodoAB(null));
	}

	private NodoAB busca(Object info, NodoAB nodo, NodoAB resultado) {
		if (info.toString().equals(nodo.getInfo().toString())) {
			resultado = nodo;
		}
		if (((Float) info) < ((Float) nodo.getInfo())) {
			resultado = busca(info, nodo.getEsquerdo(), resultado);
		} else if (((Float) info) > ((Float) nodo.getInfo())) {
			resultado = busca(info, nodo.getDireito(), resultado);
		}
		return resultado;
	}
	
	public NodoAB minimo() {
		NodoAB nodo = raiz;
		while (nodo.getEsquerdo() != null) {
			nodo = nodo.getEsquerdo();
		}
		return nodo;
	}
	
	public NodoAB maximo() {
		NodoAB nodo = raiz;
		while (nodo.getDireito() != null) {
			nodo = nodo.getDireito();
		}
		return nodo;
	}

	public int tamanho() {
		return tamanho;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		prepararString(raiz, sb, 0);
		return sb.toString();
	}

	private static void prepararString(NodoAB nodo, StringBuilder sb, int nivel) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(nodo.getInfo().toString());
		sb.append("\r\n");
		if (nodo.getEsquerdo() != null) {
			prepararString(nodo.getEsquerdo(), sb, nivel + 1);
		}
		if (nodo.getDireito() != null) {
			prepararString(nodo.getDireito(), sb, nivel + 1);
		}
	}
}
