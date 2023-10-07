package a05;

public class NodoAB {
	
	private Object info;
	private NodoAB pai;
	private NodoAB esquerdo;
	private NodoAB direito;
	
	public NodoAB(Object info) {
		this.info = info;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public NodoAB getPai() {
		return pai;
	}

	public void setPai(NodoAB pai) {
		this.pai = pai;
	}

	public NodoAB getEsquerdo() {
		return esquerdo;
	}

	public void setEsquerdo(NodoAB esquerdo) {
		this.esquerdo = esquerdo;
	}

	public NodoAB getDireito() {
		return direito;
	}

	public void setDireito(NodoAB direito) {
		this.direito = direito;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montarString(this, sb);
		return sb.toString();
	}
	
	private void montarString(NodoAB nodo, StringBuilder sb) {
		sb.append(nodo.getInfo() + " ");
		if (nodo.getEsquerdo() != null) {
			montarString(nodo.getEsquerdo(), sb);
		}
		if (nodo.getDireito() != null) {
			montarString(nodo.getDireito(), sb);
		}
	}
}
