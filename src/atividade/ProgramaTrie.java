package atividade;

public class ProgramaTrie {
	
	public static void main(String[] args) {
		ArvoreTrie arvore = new ArvoreTrie();
		System.out.println(arvore);
		arvore.adiciona("ab", "seila2");
		arvore.adiciona("ba", "seila3");
		arvore.adiciona("abc", "seila4");
		System.out.println(arvore);
		
		ArvoreTrie arvore2 = new ArvoreTrie();
		String[] a = {"c", "ca", "cab", "egf", "cc"};
		String[] b = {"carro1", "carro2", "carro3", "carro4", "carro5"};
		arvore2.adicionaTodos(a, b);
		System.out.println(arvore2);
		
		System.out.println();
		arvore.adicionaTodos(arvore2);
		System.out.println(arvore);
		
		System.out.println();
		System.out.println();
		System.out.println(arvore.clone());
	}
}
