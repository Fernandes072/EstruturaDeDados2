package a08;

public class Programa {
	
	public static void main(String[] args) {
		ArvoreTrie arvore = new ArvoreTrie();
		System.out.println(arvore);
		System.out.println(arvore.vazia());
		
		arvore.adiciona("a", "seila1");
		System.out.println(arvore);
		
		
		arvore.adiciona("ab", "seila2");
		arvore.adiciona("ba", "seila3");
		arvore.adiciona("abc", "seila4");
		System.out.println(arvore);
		
		System.out.println(arvore.chaves());
		System.out.println(arvore.valores());
		System.out.println(arvore.vazia());
		
		
		String[] a = {"c", "ca", "cab", "egf"};
		String[] b = {"carro1", "carro2", "carro3", "carro4"};
		arvore.adicionaTodos(a, b);
		System.out.println();
		System.out.println(arvore);
		
		System.out.println(arvore.contemValor("C"));
		System.out.println(arvore.contemValor("carro1"));
	}
}
