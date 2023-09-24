package a04;

public class NodoAB {
	
	private Object info;
	private NodoAB pai;
	private NodoAB filhoEsquerdo;
	private NodoAB filhoDireito;
	
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

	public NodoAB getFilhoEsquerdo() {
		return filhoEsquerdo;
	}

	public void setFilhoEsquerdo(NodoAB filhoEsquerdo) {
		this.filhoEsquerdo = filhoEsquerdo;
	}

	public NodoAB getFilhoDireito() {
		return filhoDireito;
	}

	public void setFilhoDireito(NodoAB filhoDireito) {
		this.filhoDireito = filhoDireito;
	}
	
	@Override
	public boolean equals(Object obj) {
		boolean resultado = false;
		if (obj != null && obj instanceof NodoAB) {
			NodoAB nodo = (NodoAB) obj;
			if (this.getInfo().equals(nodo.getInfo())) {
				return true;
			}
		}
		return resultado;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		MontaString(this, sb);
		return sb.toString();
	}
	
	private void MontaString(NodoAB nodo, StringBuilder sb) {
		if (!nodo.equals(this)) {
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
