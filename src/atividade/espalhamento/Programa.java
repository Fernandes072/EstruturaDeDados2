package atividade.espalhamento;

public class Programa {
	
	public static void main(String[] args) {
		TabelaEspalhamento tabela = new TabelaEspalhamento();
		System.out.println(tabela);
		System.out.println(tabela.tamanho());
		System.out.println(tabela.vazia());
		
		tabela.adiciona("Açaí", 1);
		tabela.adiciona("Açude", 2);
		tabela.adiciona("Bobó", 3);
		tabela.adiciona("Caju", 4);
		tabela.adiciona("Morango", 5);
		tabela.adiciona("Manga", 6);
		tabela.adiciona("Mamão", 7);
		tabela.adiciona("Barro", 8);
		tabela.adiciona("Casa", 9);
		tabela.adiciona("Dado", 10);
		System.out.println(tabela);
		System.out.println(tabela.tamanho());
		tabela.remove("Açaí");
		tabela.remove("Açude");
		tabela.remove("Bobó");
		tabela.remove("Caju");
		tabela.remove("Morango");
		tabela.remove("Manga");
		tabela.remove("Mamão");
		System.out.println(tabela);
		System.out.println(tabela.busca("Casa"));
		System.out.println(tabela.tamanho());
		System.out.println(tabela.vazia());
		System.out.println(tabela.contem("Dado"));
		System.out.println(tabela.contem("Bando"));
		System.out.println(tabela.contemValor(8));
		System.out.println(tabela.contemValor(11));
		
		TabelaEspalhamento tabela2 = new TabelaEspalhamento();
		tabela2.adiciona("Sapo", 20);
		tabela2.adiciona("Rio", 30);
		tabela2.adiciona("Água", 40);
		tabela2.adiciona("Laranja", 50);
		System.out.println(tabela2);
		
		tabela.adicionaTodos(tabela2);
		System.out.println(tabela);
		System.out.println(tabela.clone());
		System.out.println(tabela.chaves());
		System.out.println(tabela.valores());
		
		
		
		tabela.limpa();
		System.out.println(tabela);
		System.out.println(tabela.vazia());
		System.out.println(tabela.tamanho());
		

	}
}