package a05;

public class Programa {
	public static void main(String[] args) {
		
		/*ArvoreBinaria arvore = new ArvoreBinaria();
		
		NodoAB raiz = arvore.criaRaiz("A");
		
		NodoAB B = arvore.adicionaEsquerdo(raiz, "B");
		NodoAB C = arvore.adicionaDireito(raiz, "C");
		
		arvore.adicionaEsquerdo(B, "D");
		arvore.adicionaDireito(B, "E");
		
		arvore.adicionaEsquerdo(C, "F");
		arvore.adicionaDireito(C, "G");
		
		VisitanteImpressao impressora = new VisitanteImpressao();
		arvore.travessiaPreOrdem(impressora);
		
		System.out.println();
		System.out.println(arvore.busca("B"));
		
		VisitanteExpressao expressao = new VisitanteExpressao();
		arvore.travessiaPosOrdem(expressao);
		System.out.println(expressao.getResultado());*/
		
		
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
		
		VisitanteImpressao impressora = new VisitanteImpressao();
		arvore.travessiaPosOrdem(impressora);
		System.out.println();
		
		VisitanteExpressao expressao = new VisitanteExpressao();
		arvore.travessiaPosOrdem(expressao);
		System.out.println("Resultado: " + expressao.getResultado());
		System.out.println(((((3+1)*3)/((9-5)+2))-((3*(7-4))+6)));
	}
}
