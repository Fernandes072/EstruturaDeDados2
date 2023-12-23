package a10.p02;

public class Programa2 {
	
	public static void main(String[] args) {
		TabelaEspalhamento<Object> tabela = new TabelaEspalhamento<Object>();
		System.out.println(tabela);
		
		tabela.adiciona("Açaí");
		tabela.adiciona("Açude");
		tabela.adiciona("Bobó");
		tabela.adiciona("Caju");
		System.out.println(tabela.contem("Caju"));
		tabela.adiciona("Morango");
		tabela.adiciona("Manga");
		tabela.adiciona("Mamão");
		tabela.adiciona("Barro");
		tabela.adiciona("Casa");
		tabela.adiciona("Dado");
		System.out.println(tabela.contem("Caju"));
		tabela.adiciona("Elefante");
		tabela.adiciona("Faca");
		tabela.adiciona("Paca");
		tabela.remove("Açaí");
		tabela.remove("Casa");
		tabela.remove("Barro");
		tabela.adiciona("Gato");
		System.out.println(tabela.contem("Caju"));
		tabela.adiciona("1111");
		tabela.adiciona("4444");
		System.out.println(tabela.contem("Caju"));
		
		


		System.out.println(tabela);
		System.out.println(tabela.tamanho());
		

	}
}