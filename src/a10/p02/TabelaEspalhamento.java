package a10.p02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento<T> {

	private int tamanho = 10;

	private List<List<T>> tabela;
	private int quantidade;

	public TabelaEspalhamento() {
		tabela = new ArrayList<List<T>>();
		for (int i = 0; i < tamanho; i++) {
			tabela.add(new LinkedList<T>());
		}
	}

	public void adiciona(T obj) {
		//tabela.get(calculaPosicao(info)).add(info);
		int posicao = calculaPosicao(obj);
		List<T> lista = tabela.get(posicao);
		lista.add(obj);
		quantidade++;
		adaptarTabela();
	}
	
	private void adaptarTabela() {
		double carga = (double)quantidade/tamanho;
		if ((carga < 0.25) || (carga > 0.75)) {
			if (carga < 0.25) {
				tamanho -= 5;
			} else if (carga > 0.75){
				tamanho += 5;
			}
			List<T> reserva = obterTodos();
			List<List<T>> tabelaReserva = new ArrayList<List<T>>();
			for (int i = 0; i < tamanho; i++) {
				tabelaReserva.add(new LinkedList<T>());
			}
			for (T elemento : reserva) {
				int posicao = calculaPosicao(elemento);
				List<T> lista = tabelaReserva.get(posicao);
				lista.add(elemento);
			}
			tabela = tabelaReserva;
		}
	}

	public void remove(T obj) {
		int posicao = calculaPosicao(obj);
		List<T> lista = tabela.get(posicao);
		lista.remove(obj);
		quantidade--;
		adaptarTabela();
	}
	
	public void limpa() {
		for (List<T> vertical : tabela) {
			vertical.clear();
		}
	}

	public boolean contem(T obj) {
		int posicao = calculaPosicao(obj);
		List<T> lista = tabela.get(posicao);
		return lista.contains(obj);
	}
	
	private int calculaPosicao(T obj) {
		return Math.abs(obj.hashCode()) % tamanho;
	}
	
	public int tamanho() {
		return quantidade;
	}
	
	public List<T> obterTodos() {
		List<T> retorno = new ArrayList<T>();
		for (List<T> vertical : tabela) {
			for (T horizontal : vertical) {
				retorno.add(horizontal);
			}
		}
		return retorno;
	}
	
	@Override
	public String toString() {
		return tabela.toString();
	}
}
