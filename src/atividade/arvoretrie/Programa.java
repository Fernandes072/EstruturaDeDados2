package atividade.arvoretrie;

public class Programa {

	public static void main(String[] args) {
		ArvoreTrie arvore = new ArvoreTrie();
		System.out.println(arvore);
		System.out.println(arvore.vazia());
		System.out.println(arvore.getTamanho());
		arvore.adiciona("ab", "seila1");
		arvore.adiciona("ba", "seila2");
		arvore.adiciona("abc", "seila3");
		arvore.adiciona("cab", "seila4");
		System.out.println(arvore.getTamanho());
		System.out.println(arvore);
		System.out.println(arvore.vazia());
		System.out.println(arvore.pega("ab"));
		System.out.println(arvore.contem("abc"));
		System.out.println(arvore.contem("abd"));
		System.out.println(arvore.contemValor("seila4"));
		System.out.println(arvore.contemValor("sei"));
		arvore.remove("ab");
		System.out.println(arvore.getTamanho());
		System.out.println(arvore);

		ArvoreTrie arvore2 = new ArvoreTrie();
		arvore2.adiciona("c", "carro1");
		arvore2.adiciona("ca", "carro2");
		arvore2.adiciona("cab", "carro3");
		arvore2.adiciona("egf", "carro4");
		arvore2.adiciona("cc", "carro5");
		System.out.println(arvore2);

		arvore.adicionaTodos(arvore2);
		System.out.println(arvore);

		System.out.println(arvore.clone());

		System.out.println(arvore.chaves());
		System.out.println(arvore.valores());

		arvore.limpar();
		System.out.println(arvore);
		System.out.println(arvore.vazia());
		System.out.println(arvore.getTamanho());
	}
}
