package atividade.espalhamento;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TabelaEspalhamento {
	
	private class Celula {
		private Object chave;
		private Object valor;
		
		public Celula(Object chave, Object valor) {
			this.chave = chave;
			this.valor = valor;
		}
		
		public boolean equals(Object obj) {
			if (obj != null && obj instanceof Celula) {
				return chave.equals(((Celula)obj).chave);
			}
			return false;
		}
		
		public String toString() {
			return chave.toString() + ": " + valor.toString();
		}
	}

	private int tamanho = 10;
	private List<List<Celula>> tabela;
	private int quantidade;

	public TabelaEspalhamento() {
		tabela = new ArrayList<List<Celula>>();
		for (int i = 0; i < tamanho; i++) {
			tabela.add(new LinkedList<Celula>());
		}
	}

	public void adiciona(Object chave, Object valor) {
		int posicao = calculaPosicao(chave);
		List<Celula> lista = tabela.get(posicao);
		lista.add(new Celula(chave, valor));
		quantidade++;
		adaptarTabela();
	}
	
	public void remove(Object chave) {
		int posicao = calculaPosicao(chave);
		List<Celula> lista = tabela.get(posicao);
		int indice = lista.indexOf(new Celula(chave, null));
		lista.remove(lista.get(indice));
		quantidade--;
		adaptarTabela();
	}
	
	/*public boolean contem(Object chave) {
		int posicao = calculaPosicao(chave);
		List<Celula> lista = tabela.get(posicao);
		int indice = lista.indexOf(new Celula(chave, null));
		return indice > -1;
	}*/
	
	public Object busca(Object chave) {
		int posicao = calculaPosicao(chave);
		List<Celula> lista = tabela.get(posicao);
		int indice = lista.indexOf(new Celula(chave, null));
		if (indice > -1) {
			return lista.get(indice).valor;
		}
		return null;
	}
	
	private void adaptarTabela() {
		double carga = (double)quantidade/tamanho;
		if ((carga < 0.25) || (carga > 0.75)) {
			if (carga < 0.25) {
				tamanho -= 5;
			} else if (carga > 0.75){
				tamanho += 5;
			}
			List<Celula> reserva = obterTodos();
			List<List<Celula>> tabelaReserva = new ArrayList<List<Celula>>();
			for (int i = 0; i < tamanho; i++) {
				tabelaReserva.add(new LinkedList<Celula>());
			}
			for (Celula elemento : reserva) {
				int posicao = calculaPosicao(elemento.chave);
				List<Celula> lista = tabelaReserva.get(posicao);
				lista.add(elemento);
			}
			tabela = tabelaReserva;
		}
	}
	
	private List<Celula> obterTodos() {
		List<Celula> retorno = new ArrayList<Celula>();
		for (List<Celula> horizontal : tabela) {
			for (Celula celula : horizontal) {
				retorno.add(celula);
			}
		}
		return retorno;
	}
	
	private int calculaPosicao(Object chave) {
		return Math.abs(chave.hashCode()) % tamanho;
	}
	
	public void limpa() {
		for (List<Celula> vertical : tabela) {
			vertical.clear();
		}
		quantidade = 0;
	}
	
	public int tamanho() {
		return quantidade;
	}
	
	public boolean vazia() {
		return quantidade == 0;
	}
	
	public boolean contem(Object chave) {
		return chaves().contains(chave);
	}
	
	public boolean contemValor(Object valor) {
		return valores().contains(valor);
	}
	
	public void adicionaTodos(TabelaEspalhamento tabela) {
		for (Object chave : tabela.chaves()) {
			adiciona(chave, tabela.busca(chave));
		}
	}
	
	public TabelaEspalhamento clone() {
		TabelaEspalhamento resultado = new TabelaEspalhamento();
		for(List<Celula> horizontal : tabela) {
			for(Celula celula : horizontal) {
				resultado.adiciona(celula.chave, celula.valor);
			}
		}
		return resultado;
	}
	
	public List<Object> chaves(){
		List<Object> resultado = new ArrayList<Object>();
		for(List<Celula> horizontal : tabela) {
			for(Celula celula : horizontal) {
				resultado.add(celula.chave);
			}
		}
		return resultado;
	}
	
	public List<Object> valores(){
		List<Object> resultado = new ArrayList<Object>();
		for(List<Celula> horizontal : tabela) {
			for(Celula celula : horizontal) {
				resultado.add(celula.valor);
			}
		}
		return resultado;
	}
	
	@Override
	public String toString() {
		return tabela.toString();
	}
}
