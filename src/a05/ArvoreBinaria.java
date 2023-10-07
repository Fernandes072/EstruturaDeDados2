package a05;

public class ArvoreBinaria {
	
	private NodoAB raiz;
	private int tamanho;
	
	public ArvoreBinaria() {
		
	}
	
	public NodoAB criaRaiz(Object info) {
		NodoAB nodo = new NodoAB(info);
		raiz = nodo;
		tamanho++;
		return nodo;
	}
	
	public NodoAB adicionaEsquerdo(NodoAB pai, Object info) {
		if (pai.getEsquerdo() != null) {
			throw new RuntimeException("Já possui filho esquerdo");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setEsquerdo(nodo);
		tamanho++;
		return nodo;
	}
	
	public NodoAB adicionaDireito(NodoAB pai, Object info) {
		if (pai.getDireito() != null) {
			throw new RuntimeException("Já possui filho direito");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setDireito(nodo);
		tamanho++;
		return nodo;
	}
	
	public int tamanho() {
		return tamanho;
	}
	
	public NodoAB busca(Object info) {
		VisitanteBusca buscador = new VisitanteBusca(info);
		travessiaPreOrdem(buscador, raiz);
		return buscador.getResultado();
	}
	
	public void travessiaPreOrdem(Visitante visitante) {
		travessiaPreOrdem(visitante, raiz);
	}
	
	public void travessiaEmOrdem(Visitante visitante) {
		travessiaEmOrdem(visitante, raiz);
	}
	
	public void travessiaPosOrdem(Visitante visitante) {
		travessiaPosOrdem(visitante, raiz);
	}
	
	private void travessiaPreOrdem(Visitante visitante, NodoAB nodo) {
		visitante.visita(nodo);
		if (nodo.getEsquerdo() != null) {
			travessiaPreOrdem(visitante, nodo.getEsquerdo());
		}
		if (nodo.getDireito() != null) {
			travessiaPreOrdem(visitante, nodo.getDireito());
		}
	}
	
	private void travessiaEmOrdem(Visitante visitante, NodoAB nodo) {
		if (nodo.getEsquerdo() != null) {
			travessiaEmOrdem(visitante, nodo.getEsquerdo());
		}
		visitante.visita(nodo);
		if (nodo.getDireito() != null) {
			travessiaEmOrdem(visitante, nodo.getDireito());
		}
	}
	
	private void travessiaPosOrdem(Visitante visitante, NodoAB nodo) {
		if (nodo.getEsquerdo() != null) {
			travessiaPosOrdem(visitante, nodo.getEsquerdo());
		}
		if (nodo.getDireito() != null) {
			travessiaPosOrdem(visitante, nodo.getDireito());
		}
		visitante.visita(nodo);
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
		if (nodo.getEsquerdo() != null && nodo.getDireito() != null) {
			sb.append("(");
		}
		if (nodo.getEsquerdo() != null) {
			MontaString(nodo.getEsquerdo(), sb);
		}
		sb.append(nodo.getInfo());
		if (nodo.getDireito() != null) {
			MontaString(nodo.getDireito(), sb);
		}
		if (nodo.getEsquerdo() != null && nodo.getDireito() != null) {
			sb.append(")");
		}
	}
}
