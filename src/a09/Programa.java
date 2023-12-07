package a09;

public class Programa {

	public static void main(String[] args) {

		ArvoreAVL arvore = new ArvoreAVL();
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
		Float n = 20f;
		System.out.println(arvore.busca(n).getAltura());
		System.out.println(arvore.busca(n).altura());
	}

}

/*
 * arvore.adiciona(37f); arvore.adiciona(20f); arvore.adiciona(80f);
 * arvore.adiciona(10f); arvore.adiciona(30f); arvore.adiciona(5f);
 * arvore.adiciona(100f); arvore.adiciona(180f); arvore.adiciona(90f);
 */
