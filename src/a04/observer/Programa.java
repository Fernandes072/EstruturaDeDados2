package a04.observer;

public class Programa {

	public static void main(String[] args) {
		ArvoreBinaria arvore = new ArvoreBinaria();
		System.out.println(arvore.getTamanho() == 0);

		NodoAB raiz = arvore.criaRaiz("A");

		arvore.adicionaEsquerdo(raiz, "B");
		NodoAB D = arvore.adicionaEsquerdo(arvore.busca("B"), "D");
		arvore.adicionaDireito(arvore.busca("B"), "E");
		System.out.println(arvore.getTamanho() == 4);

		NodoAB C = arvore.adicionaDireito(raiz, "C");
		arvore.adicionaEsquerdo(C, "F");
		arvore.adicionaDireito(C, "G");
		System.out.println(arvore.getTamanho() == 7);

		System.out.println(arvore.getTamanho() == 7);
		System.out.println(arvore.getRaiz() == raiz);
		System.out.println(arvore.toString().equals("A B D E C F G"));
		System.out.println(arvore.grau(raiz) == 2);
		System.out.println(arvore.grau(D) == 0);
		System.out.println(arvore.nivel(raiz) == 1);
		System.out.println(arvore.nivel(arvore.busca("B")) == 2);
		System.out.println(arvore.nivel(D) == 3);
		System.out.println(arvore.altura(raiz) == 3);
		System.out.println(arvore.altura(arvore.busca("B")) == 2);
		System.out.println(arvore.altura(D) == 1);
		System.out.println(arvore.busca("B").toString().equals("B D E"));
		System.out.println(arvore.irmao(arvore.busca("B")).toString().equals("C F G"));
		System.out.println(arvore.irmao(D).toString().equals("E"));
		
		ArvoreBinaria arvore2 = arvore.copia();
		System.out.println(arvore.toString().equals(arvore2.toString()));
		System.out.println(arvore2.toString().equals("A B D E C F G"));
		System.out.println(arvore2.busca("G").toString().equals("G"));
		arvore2.removerNodo(arvore2.busca("F"));
		System.out.println(arvore2.toString().equals("A B D E C G"));
		arvore2.removerNodo(arvore2.busca("C"));
		System.out.println(arvore2.toString().equals("A B D E"));
		arvore2.removerNodo(arvore2.busca("D"));
		System.out.println(arvore2.toString().equals("A B E"));
	}
}
