package a10.p01;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {

	private static int TAMANHO = 30;

	private List<List<String>> tabela;
	private int quantidade;

	public TabelaEspalhamento() {
		tabela = new ArrayList<List<String>>();
		for (int i = 0; i < TAMANHO; i++) {
			tabela.add(new LinkedList<String>());
		}
	}

	public void adiciona(String info) {
		//tabela.get(calculaPosicao(info)).add(info);
		int posicao = calculaPosicao(info);
		List<String> lista = tabela.get(posicao);
		lista.add(info);
		quantidade++;
	}

	public void remove(String info) {
		int posicao = calculaPosicao(info);
		List<String> lista = tabela.get(posicao);
		lista.remove(info);
		quantidade--;
	}

	public boolean contem(String info) {
		int posicao = calculaPosicao(info);
		List<String> lista = tabela.get(posicao);
		return lista.contains(info);
	}
	
	private int calculaPosicao(String info) {
		return info.toLowerCase().charAt(0) % TAMANHO;
	}
	
	public int tamanho() {
		return quantidade;
	}
	
	@Override
	public String toString() {
		return tabela.toString();
	}
}
