package a04.observer;

public class ProgramaObserver {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();

		NodoAB raiz = arvore.criaRaiz("A");

		NodoAB B = arvore.adicionaEsquerdo(raiz, "B");
		arvore.adicionaEsquerdo(B, "D");
		arvore.adicionaDireito(B, "E");

		NodoAB C = arvore.adicionaDireito(raiz, "C");
		arvore.adicionaEsquerdo(C, "F");
		arvore.adicionaDireito(C, "G");
		
		System.out.println(arvore);
		
		Visitante impressao = new ImpressaoVisitante();
		arvore.travessiaPreOrdem(impressao);
	}
}
