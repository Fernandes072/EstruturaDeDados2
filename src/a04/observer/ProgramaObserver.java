package a04.observer;

public class ProgramaObserver {

	public static void main(String[] args) {

		ArvoreBinaria arvore = new ArvoreBinaria();

		NodoAB raiz = arvore.criaRaiz("-");

		NodoAB div2 = arvore.adicionaEsquerdo(raiz, "/");
		NodoAB mul3 = arvore.adicionaEsquerdo(div2, "*");
		NodoAB som3 = arvore.adicionaDireito(div2, "+");

		NodoAB sub4 = arvore.adicionaEsquerdo(som3, "-");
		arvore.adicionaDireito(som3, "2");

		arvore.adicionaEsquerdo(sub4, "9");
		arvore.adicionaDireito(sub4, "5");

		NodoAB som4 = arvore.adicionaEsquerdo(mul3, "+");
		arvore.adicionaDireito(mul3, "3");

		arvore.adicionaEsquerdo(som4, "3");
		arvore.adicionaDireito(som4, "1");

		NodoAB som2 = arvore.adicionaDireito(raiz, "+");
		arvore.adicionaDireito(som2, "6");
		NodoAB mul3d = arvore.adicionaEsquerdo(som2, "*");
		arvore.adicionaEsquerdo(mul3d, "3");
		NodoAB sub4d = arvore.adicionaDireito(mul3d, "-");
		arvore.adicionaEsquerdo(sub4d, "7");
		arvore.adicionaDireito(sub4d, "4");

		System.out.println(arvore);

		Visitante impressao = new ImpressaoVisitante();
		arvore.travessiaPreOrdem(impressao);
		System.out.println();
		arvore.travessiaEmOrdem(impressao);
		System.out.println();
		arvore.travessiaPosOrdem(impressao);
		System.out.println();
		System.out.println(arvore.operacao());
		System.out.println(((((3+1)*3)/((9-5)+2))-((3*(7-4))+6)));

	}
}
