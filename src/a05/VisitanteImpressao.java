package a05;

public class VisitanteImpressao implements Visitante{

	@Override
	public void visita(NodoAB nodo) {
		System.out.print(nodo.getInfo() + " ");
	}

}
