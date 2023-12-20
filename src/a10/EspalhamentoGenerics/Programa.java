package a10.EspalhamentoGenerics;

public class Programa {

	public static void main(String[] args) {
		TabelaEspalhamento<Object> tabela = new TabelaEspalhamento<Object>();
		System.out.println(tabela);
		
		tabela.adiciona("Açaí");
		tabela.adiciona("Açude");
		tabela.adiciona("Bobó");
		tabela.adiciona("Caju");
		tabela.adiciona("Morango");
		tabela.adiciona("Manga");
		tabela.adiciona("Mamão");
		tabela.adiciona("Barro");
		tabela.adiciona("Casa");
		tabela.adiciona("Dado");
		tabela.adiciona("Elefante");
		tabela.adiciona("Faca");
		tabela.adiciona("Paca");
		tabela.adiciona("Gato");
		tabela.adiciona("1111");
		tabela.adiciona("4444");

		System.out.println(tabela);
		

	}

}
