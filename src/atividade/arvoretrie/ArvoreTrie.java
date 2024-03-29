package atividade.arvoretrie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArvoreTrie {

	private NodoTrie raiz;
	private int tamanho;

	public ArvoreTrie() {
		raiz = new NodoTrie();
		tamanho = 0;
	}

	public void adiciona(String chave, Object valor) {
		adiciona(chave, valor, raiz, 0);
	}

	private void adiciona(String chave, Object valor, NodoTrie nodo, int posicao) {
		if (posicao == chave.length()) {
			if(nodo.getValor() == null) {
				tamanho++;
			}
			nodo.setValor(valor);
		} else {
			char letra = chave.charAt(posicao);
			NodoTrie filho = nodo.getFilho(letra);
			if (filho == null) {
				filho = new NodoTrie();
				nodo.setFilho(letra, filho);
			}
			adiciona(chave, valor, filho, posicao + 1);
		}
	}

	public Object pega(String chave) {
		NodoTrie nodo = pega(chave, raiz, 0);
		if (nodo != null) {
			return nodo.getValor();
		}
		return null;
	}

	private NodoTrie pega(String chave, NodoTrie nodo, int posicao) {
		if (posicao == chave.length()) {
			return nodo;
		} else {
			char letra = chave.charAt(posicao);
			NodoTrie filho = nodo.getFilho(letra);
			if (filho != null) {
				return pega(chave, filho, posicao + 1);
			} else {
				return null;
			}
		}
	}

	public void remove(String chave) {
		remove(chave, raiz, 0);
	}

	private boolean remove(String chave, NodoTrie nodo, int posicao) {
		if (posicao == chave.length()) {
			nodo.setValor(null);
			tamanho--;
			if (nodo.getTamanho() == 0) {
				return true;
			} else {
				return false;
			}
		} else {
			char letra = chave.charAt(posicao);
			NodoTrie filho = nodo.getFilho(letra);
			if (filho == null) {
				return false;
			} else {
				boolean deveRemover = remove(chave, filho, posicao + 1);
				if (deveRemover) {
					if (filho.getTamanho() == 0 && filho.getValor() == null) {
						nodo.remove(letra);
					} else {
						deveRemover = false;
					}
				}
				return deveRemover;
			}
		}
	}

	public NodoTrie getRaiz() {
		return raiz;
	}

	public int getTamanho() {
		return tamanho;
	}

	public Set chaves() {
		Set resultado = new HashSet();
		chaves(resultado, raiz, "");
		return resultado;
	}

	private void chaves(Set resultado, NodoTrie nodo, String chave) {
		if (nodo.getValor() != null) {
			resultado.add(chave);
		}
		for (int i = 0; i < NodoTrie.QTD_LETRAS; i++) {
			char letra = (char) i;
			NodoTrie filho = nodo.getFilho(letra);
			if (filho != null) {
				chaves(resultado, filho, chave + letra);
			}
		}
	}

	public List valores() {
		List resultado = new ArrayList();
		valores(resultado, raiz);
		return resultado;
	}

	private void valores(List resultado, NodoTrie nodo) {
		if (nodo.getValor() != null) {
			resultado.add(nodo.getValor());
		}
		for (int i = 0; i < NodoTrie.QTD_LETRAS; i++) {
			char letra = (char) i;
			NodoTrie filho = nodo.getFilho(letra);
			if (filho != null) {
				valores(resultado, filho);
			}
		}
	}
	
	public boolean contem(String chave) {
		return chaves().contains(chave);
	}

	public boolean contemValor(Object valor) {
		return valores().contains(valor);
	}

	public boolean vazia() {
		return tamanho == 0;
	}

	public void limpar() {
		for (Object chave : chaves()) {
			remove(chave.toString());
		}
	}

	public void adicionaTodos(String[] chaves, Object[] valores) {
		if (chaves.length == valores.length) {
			for (int i = 0; i < chaves.length; i++) {
				adiciona(chaves[i], valores[i]);
			}
		}
	}
	
	public void adicionaTodos(ArvoreTrie arvore) {
		for (Object chave : arvore.chaves()) {
			adiciona(chave.toString(), arvore.pega(chave.toString()));
		}
	}
	
	public ArvoreTrie clone() {
		ArvoreTrie copia = new ArvoreTrie();
		for (Object chave : chaves()) {
			copia.adiciona(chave.toString(), pega(chave.toString()));
		}
		return copia;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		montaString(sb, raiz, 0);
		return sb.toString();
	}

	private void montaString(StringBuilder sb, NodoTrie nodo, int posicao) {
		if (nodo.getValor() != null) {
			sb.append(nodo.getValor());
		}

		for (int i = 0; i < NodoTrie.QTD_LETRAS; i++) {
			NodoTrie filho = nodo.getFilho((char) i);
			if (filho != null) {
				sb.append("\n");
				for (int j = 0; j < posicao; j++) {
					sb.append(" ");
				}
				sb.append("(");
				sb.append((char) i);
				sb.append(")");
				montaString(sb, filho, posicao + 1);
			}
		}
	}

}
