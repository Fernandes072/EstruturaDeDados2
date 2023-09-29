package a04.observer;

import java.util.List;

public class ProgramaObserver {

	public static void main(String[] args) {

		/*
		 * ArvoreBinaria arvore = new ArvoreBinaria();
		 * 
		 * NodoAB raiz = arvore.criaRaiz("A");
		 * 
		 * NodoAB B = arvore.adicionaEsquerdo(raiz, "B"); arvore.adicionaEsquerdo(B,
		 * "D"); arvore.adicionaDireito(B, "E");
		 * 
		 * NodoAB C = arvore.adicionaDireito(raiz, "C"); arvore.adicionaEsquerdo(C,
		 * "F"); arvore.adicionaDireito(C, "G");
		 * 
		 * System.out.println(arvore);
		 * 
		 * Visitante impressao = new ImpressaoVisitante();
		 * arvore.travessiaPreOrdem(impressao); System.out.println();
		 * arvore.travessiaEmOrdem(impressao); System.out.println();
		 * arvore.travessiaPosOrdem(impressao); System.out.println();
		 * System.out.println(arvore.eFolha(C));
		 * 
		 * List<NodoAB> filhos = arvore.filhos(raiz); for (NodoAB filho : filhos) {
		 * System.out.println(filho); }
		 */

		/*
		 * ArvoreBinaria arvore = new ArvoreBinaria();
		 * 
		 * NodoAB raiz = arvore.criaRaiz("-");
		 * 
		 * NodoAB div2 = arvore.adicionaEsquerdo(raiz, "/"); NodoAB mul3 =
		 * arvore.adicionaEsquerdo(div2, "x"); NodoAB som3 =
		 * arvore.adicionaDireito(div2, "+");
		 * 
		 * NodoAB sub4 = arvore.adicionaEsquerdo(som3, "-");
		 * arvore.adicionaDireito(som3, "2");
		 * 
		 * arvore.adicionaEsquerdo(sub4, "9"); arvore.adicionaDireito(sub4, "5");
		 * 
		 * NodoAB som4 = arvore.adicionaEsquerdo(mul3, "+");
		 * arvore.adicionaDireito(mul3, "3");
		 * 
		 * arvore.adicionaEsquerdo(som4, "3"); arvore.adicionaDireito(som4, "1");
		 * 
		 * NodoAB som2 = arvore.adicionaDireito(raiz, "+"); arvore.adicionaDireito(som2,
		 * "6"); NodoAB mul3d = arvore.adicionaEsquerdo(som2, "x");
		 * arvore.adicionaEsquerdo(mul3d, "3"); NodoAB sub4d =
		 * arvore.adicionaDireito(mul3d, "-"); arvore.adicionaEsquerdo(sub4d, "7");
		 * arvore.adicionaDireito(sub4d, "4");
		 * 
		 * System.out.println(arvore);
		 * 
		 * Visitante impressao = new ImpressaoVisitante();
		 * arvore.travessiaPreOrdem(impressao); System.out.println();
		 * arvore.travessiaEmOrdem(impressao); System.out.println();
		 * arvore.travessiaPosOrdem(impressao); System.out.println();
		 * System.out.println(arvore.soma());
		 */
		
		ArvoreBinaria arvore = new ArvoreBinaria();

		NodoAB raiz = arvore.criaRaiz("-");

		/*
		 * NodoAB div2 = arvore.adicionaEsquerdo(raiz, "/"); NodoAB mul3 =
		 * arvore.adicionaEsquerdo(div2, "x"); NodoAB som3 =
		 * arvore.adicionaDireito(div2, "+");
		 * 
		 * NodoAB sub4 = arvore.adicionaEsquerdo(som3, "-");
		 * arvore.adicionaDireito(som3, "2");
		 * 
		 * arvore.adicionaEsquerdo(sub4, "9"); arvore.adicionaDireito(sub4, "5");
		 * 
		 * NodoAB som4 = arvore.adicionaEsquerdo(mul3, "+");
		 * arvore.adicionaDireito(mul3, "3");
		 * 
		 * arvore.adicionaEsquerdo(som4, "3"); arvore.adicionaDireito(som4, "1");
		 * 
		 * NodoAB som2 = arvore.adicionaDireito(raiz, "+"); arvore.adicionaDireito(som2,
		 * "6"); NodoAB mul3d = arvore.adicionaEsquerdo(som2, "x");
		 * arvore.adicionaEsquerdo(mul3d, "3"); NodoAB sub4d =
		 * arvore.adicionaDireito(mul3d, "-");
		 */
		NodoAB esq = arvore.adicionaEsquerdo(raiz, "+");
		NodoAB dir = arvore.adicionaDireito(raiz, "-");
		arvore.adicionaEsquerdo(esq, "7");
		arvore.adicionaDireito(esq, "3");
		arvore.adicionaEsquerdo(dir, "2");
		arvore.adicionaDireito(dir, "5");

		System.out.println(arvore);

		Visitante impressao = new ImpressaoVisitante();
		arvore.travessiaPreOrdem(impressao);
		System.out.println();
		arvore.travessiaEmOrdem(impressao);
		System.out.println();
		arvore.travessiaPosOrdem(impressao);
		System.out.println();
		System.out.println(arvore.soma());

	}
}
