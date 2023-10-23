package a07;

public class ArvoreBinaria {

	private Nodo raiz;
	private int tamanho;

	public ArvoreBinaria() {

	}

	public void adiciona(Comparable info) {
		if (raiz == null) {
			Nodo novoNodo = new Nodo(info);
			raiz = novoNodo;
			tamanho++;
		} else {
			adiciona(info, raiz);
		}
	}

	private void adiciona(Comparable info, Nodo nodo) {
		if (info.compareTo(nodo.getInfo()) > 0) {
			if (nodo.getDireito() == null) {
				Nodo novoNodo = new Nodo(info);
				nodo.setDireito(novoNodo);
				novoNodo.setPai(nodo);
				tamanho++;
				return;
			}
			adiciona(info, nodo.getDireito());
		} else if (info.compareTo(nodo.getInfo()) < 0) {
			if (nodo.getEsquerdo() == null) {
				Nodo novoNodo = new Nodo(info);
				nodo.setEsquerdo(novoNodo);
				novoNodo.setPai(nodo);
				tamanho++;
				return;
			}
			adiciona(info, nodo.getEsquerdo());
		}
	}

	public Nodo busca(Comparable info) {
		return busca(info, raiz);
	}

	private Nodo busca(Comparable info, Nodo nodo) {
		if (nodo != null) {
			if (info.compareTo(nodo.getInfo()) == 0) {
				return nodo;
			}
			if (info.compareTo(nodo.getInfo()) < 0) {
				return busca(info, nodo.getEsquerdo());
			}
			if (info.compareTo(nodo.getInfo()) > 0) {
				return busca(info, nodo.getDireito());
			}
		}
		return null;
	}
	
	public Nodo minimo() {
		Nodo resultado = raiz;
		while (resultado.getEsquerdo() != null) {
			resultado = resultado.getEsquerdo();
		}
		return resultado;
	}
	
	public Nodo maximo() {
		Nodo resultado = raiz;
		while (resultado.getDireito() != null) {
			resultado = resultado.getDireito();
		}
		return resultado;
	}

	public int grau(Nodo nodo) {
		return nodo.grau();
	}
	
	public int nivel(Nodo nodo) {
		return nodo.nivel();
	}
	
	public int altura(Nodo nodo) {
		return nodo.altura();
	}
	
	public Nodo raiz() {
		return raiz;
	}

	public int tamanho() {
		return tamanho;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaString(raiz, sb, 1, "R");
		return sb.toString();
	}

	private void montaString(Nodo nodo, StringBuilder sb, int nivel, String posicao) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(posicao + ": ");
		sb.append(nodo.getInfo().toString());
		sb.append("\r\n");
		if (nodo.getEsquerdo() != null) {
			montaString(nodo.getEsquerdo(), sb, nivel + 1, "E");
		}
		if (nodo.getDireito() != null) {
			montaString(nodo.getDireito(), sb, nivel + 1, "D");
		}
	}
}
