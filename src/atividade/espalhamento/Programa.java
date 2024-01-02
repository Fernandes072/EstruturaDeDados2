package atividade.espalhamento;

public class Programa {
	
	public static void main(String[] args) {
		TabelaEspalhamento tabela = new TabelaEspalhamento();
		System.out.println(tabela);
		
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
		tabela.adiciona("Elefante", 11);
		tabela.adiciona("Faca", 12);
		tabela.adiciona("Paca", 13);
		tabela.adiciona("Gato", 14);
		tabela.adiciona("1111", 15);
		tabela.adiciona("4444", 16);
		System.out.println(tabela);
		
		System.out.println(tabela.chaves());
		System.out.println(tabela.valores());

		

	}
}