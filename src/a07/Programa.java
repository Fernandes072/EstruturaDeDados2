package a07;

public class Programa {

	public static void main(String[] args) {
		
		ArvoreBinaria arvore = new ArvoreBinaria();
		arvore.adiciona(37);
		arvore.adiciona(20);
		arvore.adiciona(80);
		arvore.adiciona(10);
		arvore.adiciona(30);
		arvore.adiciona(5);
		arvore.adiciona(100);
		arvore.adiciona(180);
		arvore.adiciona(90);
		System.out.println(arvore);
		
	
		System.out.println(arvore.minimo());

	}

}
