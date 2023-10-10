package a06;

public class Programa {
	public static void main(String[] args) {
		
		ArvoreBinaria arvore = new ArvoreBinaria();
		arvore.adiciona(37f);
		arvore.adiciona(20f);
		arvore.adiciona(80f);
		arvore.adiciona(10f);
		arvore.adiciona(30f);
		arvore.adiciona(5f);
		arvore.adiciona(100f);
		arvore.adiciona(90f);
		arvore.adiciona(180f);
		System.out.println(arvore);
		System.out.println();
		arvore.remover(arvore.busca(20f));
		System.out.println(arvore);
		
	}
}
