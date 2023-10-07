package a06;

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
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		prepararString(this, sb, 0);
		return sb.toString();
	}

	private static void prepararString(NodoAB nodo, StringBuilder sb, int nivel) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(nodo.info.toString());
		sb.append("\r\n");
		if (nodo.getEsquerdo() != null) {
			prepararString(nodo.getEsquerdo(), sb, nivel + 1);
		}
		if (nodo.getDireito() != null) {
			prepararString(nodo.getDireito(), sb, nivel + 1);
		}
	}
}
