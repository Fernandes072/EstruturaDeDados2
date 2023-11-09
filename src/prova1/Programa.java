package prova1;

public class Programa {

	public static void main(String[] args) {

		ArvoreBinariaBusca arvore = new ArvoreBinariaBusca();
		arvore.adiciona(37f);
		arvore.adiciona(20f);
		arvore.adiciona(80f);
		arvore.adiciona(10f);
		arvore.adiciona(30f);
		arvore.adiciona(5f);
		arvore.adiciona(100f);
		arvore.adiciona(180f);
		arvore.adiciona(90f);
		System.out.println(arvore);
		System.out.println();
		ArvoreBinariaBusca arvoreCopia = arvore.copia();
		System.out.println(arvoreCopia);
	}

}
