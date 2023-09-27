package a04.observer;



public class ImpressaoVisitante implements Visitante{

	public void visita(NodoAB nodo) {
		System.out.print(nodo.getInfo() + " ");
	}
}
