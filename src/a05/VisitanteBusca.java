package a05;

public class VisitanteBusca implements Visitante{
	
	private NodoAB resultado;
	private Object info;
	
	public VisitanteBusca(Object info) {
		this.info = info;
	}

	@Override
	public void visita(NodoAB nodo) {
		if (nodo.getInfo().equals(info)) {
			resultado = nodo;
		}
	}
	
	public NodoAB getResultado() {
		return resultado;
	}
}
