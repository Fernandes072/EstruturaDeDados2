package a09;

public class Programa {

	public static void main(String[] args) {

		ArvoreAVL arvore = new ArvoreAVL();
		/*
		 * arvore.adiciona(37f); arvore.adiciona(20f); arvore.adiciona(10f);
		 * 
		 * System.out.println(arvore);
		 * 
		 * arvore.adiciona(5f); System.out.println(arvore);
		 * 
		 * arvore.adiciona(3f); System.out.println(arvore);
		 * 
		 * arvore.adiciona(2f); System.out.println(arvore);
		 * 
		 * arvore.adiciona(4f); System.out.println(arvore);
		 * 
		 * arvore.adiciona(1f); System.out.println(arvore);
		 * 
		 * arvore.adiciona(0.5f); System.out.println(arvore);
		 * 
		 * arvore.adiciona(0.3f); System.out.println(arvore);
		 */
		
		arvore.adiciona(5f);
		arvore.adiciona(3f);
		arvore.adiciona(8f);
		arvore.adiciona(2f);
		arvore.adiciona(4f);
		arvore.adiciona(7f);
		arvore.adiciona(10f);
		arvore.adiciona(1f);
		arvore.adiciona(6f);
		arvore.adiciona(9f);
		arvore.adiciona(11f);
		System.out.println(arvore);
		
		arvore.remove(4f);
		arvore.remove(8f);
		arvore.remove(6f);
		System.out.println(arvore);

	}

}

/*
 * arvore.adiciona(37f); arvore.adiciona(20f); arvore.adiciona(80f);
 * arvore.adiciona(10f); arvore.adiciona(30f); arvore.adiciona(5f);
 * arvore.adiciona(100f); arvore.adiciona(180f); arvore.adiciona(90f);
 */
