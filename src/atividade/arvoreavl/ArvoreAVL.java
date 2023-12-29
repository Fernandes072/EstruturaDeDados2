package atividade.arvoreavl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArvoreAVL {

	private NodoAVL raiz;
	private int tamanho;

	public ArvoreAVL() {

	}

	public NodoAVL raiz() {
		return raiz;
	}

	public int getTamanho() {
		return tamanho;
	}

	public void adiciona(Comparable chave, Object valor) {
		this.raiz = adiciona(chave, valor, this.raiz);
	}

	private NodoAVL adiciona(Comparable chave, Object valor, NodoAVL nodo) {
		if (nodo == null) {
			nodo = new NodoAVL(chave, valor);
			tamanho++;
		} else {
			int comp = chave.compareTo(nodo.getChave());
			if (comp > 0) {
				NodoAVL filho = adiciona(chave, valor, nodo.getDireito());
				nodo.setDireito(filho);
				filho.setPai(nodo);
			} else if (comp < 0) {
				NodoAVL filho = adiciona(chave, valor, nodo.getEsquerdo());
				nodo.setEsquerdo(filho);
				filho.setPai(nodo);
			}
		}
		nodo.atualizaAltura();
		nodo = balancear(nodo);
		return nodo;
	}

	private NodoAVL balancear(NodoAVL nodo) {
		int fator = nodo.getFator();
		if (fator == +2) { // Desbalanceado para a direita;
			// Balancear
			if (nodo.getDireito().getFator() >= 0) {
				nodo = rotacaoEsquerda(nodo);
			} else {
				nodo = rotacaoDuplaEsquerda(nodo);
			}
		} else if (fator == -2) { // Desbalanceado para a esquerda;
			// Balancear
			if (nodo.getEsquerdo().getFator() <= 0) {
				nodo = rotacaoDireita(nodo);
			} else {
				nodo = rotacaoDuplaDireita(nodo);
			}
		}
		return nodo;
	}

	private NodoAVL rotacaoDireita(NodoAVL n) {
		NodoAVL pai = n.getPai();
		NodoAVL ne = n.getEsquerdo();
		n.setEsquerdo(ne.getDireito());
		if (ne.getDireito() != null) {
			ne.getDireito().setPai(n);
		}
		ne.setDireito(n);
		ne.setPai(pai);
		if (pai != null) {
			if (n == pai.getEsquerdo()) {
				pai.setEsquerdo(ne);
			} else {
				pai.setDireito(ne);
			}
		}
		n.setPai(ne);
		n.atualizaAltura();
		ne.atualizaAltura();
		return ne;
	}

	private NodoAVL rotacaoEsquerda(NodoAVL n) {
		NodoAVL pai = n.getPai();
		NodoAVL nd = n.getDireito();
		n.setDireito(nd.getEsquerdo());
		if (nd.getEsquerdo() != null) {
			nd.getEsquerdo().setPai(n);
		}
		nd.setEsquerdo(n);
		nd.setPai(pai);
		if (pai != null) {
			if (n == pai.getEsquerdo()) {
				pai.setEsquerdo(nd);
			} else {
				pai.setDireito(nd);
			}
		}
		n.setPai(nd);
		n.atualizaAltura();
		nd.atualizaAltura();
		return nd;
	}

	private NodoAVL rotacaoDuplaDireita(NodoAVL nodo) {
		nodo.setEsquerdo(rotacaoEsquerda(nodo.getEsquerdo()));
		return rotacaoDireita(nodo);
	}

	private NodoAVL rotacaoDuplaEsquerda(NodoAVL nodo) {
		nodo.setDireito(rotacaoDireita(nodo.getDireito()));
		return rotacaoEsquerda(nodo);
	}

	public NodoAVL busca(Comparable chave) {
		return busca(chave, raiz);
	}

	private NodoAVL busca(Comparable chave, NodoAVL nodo) {
		if (nodo != null) {
			if (chave.compareTo(nodo.getChave()) == 0) {
				return nodo;
			}
			if (chave.compareTo(nodo.getChave()) < 0) {
				return busca(chave, nodo.getEsquerdo());
			}
			if (chave.compareTo(nodo.getChave()) > 0) {
				return busca(chave, nodo.getDireito());
			}
		}
		return null;
	}

	public NodoAVL minimo() {
		return raiz.getMenor();
	}

	public NodoAVL maximo() {
		return raiz.getMaior();
	}

	public int contagem() {
		return raiz.contagem();
	}

	public NodoAVL sucessor(NodoAVL nodo) {
		if (nodo != null) {
			if (nodo == maximo()) {
				return null;
			}
			if (nodo.getDireito() != null) {
				if (nodo.getDireito().getEsquerdo() == null) {
					return nodo.getDireito();
				}
				if (nodo.getDireito().getEsquerdo() != null) {
					NodoAVL resultado = nodo.getDireito();
					while (resultado.getEsquerdo() != null) {
						resultado = resultado.getEsquerdo();
					}
					return resultado;
				}
			}
			if (nodo.getDireito() == null) {
				if (nodo.getPai().getEsquerdo() != null) {
					if (nodo == nodo.getPai().getEsquerdo()) {
						return nodo.getPai();
					}
				}
				if (nodo.getPai().getDireito() != null) {
					if (nodo == nodo.getPai().getDireito()) {
						NodoAVL resultado = nodo;
						while (resultado.getPai() != null) {
							if (resultado.getPai().getEsquerdo() != null) {
								if (resultado == resultado.getPai().getEsquerdo()) {
									return resultado.getPai();
								}
							}
							resultado = resultado.getPai();
						}
						return resultado;
					}
				}
			}
		}
		return null;
	}

	public NodoAVL predecessor(NodoAVL nodo) {
		if (nodo != null) {
			if (nodo == minimo()) {
				return null;
			}
			if (nodo.getEsquerdo() != null) {
				if (nodo.getEsquerdo().getDireito() == null) {
					return nodo.getEsquerdo();
				}
				if (nodo.getEsquerdo().getDireito() != null) {
					NodoAVL resultado = nodo.getEsquerdo();
					while (resultado.getDireito() != null) {
						resultado = resultado.getDireito();
					}
					return resultado;
				}
			}
			if (nodo.getEsquerdo() == null) {
				if (nodo.getPai().getDireito() != null) {
					if (nodo == nodo.getPai().getDireito()) {
						return nodo.getPai();
					}
				}
				if (nodo.getPai().getEsquerdo() != null) {
					if (nodo == nodo.getPai().getEsquerdo()) {
						NodoAVL resultado = nodo;
						while (resultado.getPai() != null) {
							if (resultado.getPai().getDireito() != null) {
								if (resultado == resultado.getPai().getDireito()) {
									return resultado.getPai();
								}
							}
							resultado = resultado.getPai();
						}
						return resultado;
					}
				}
			}
		}
		return null;
	}

	public void remove(Comparable chave) {
		NodoAVL nodo = busca(chave);
		NodoAVL pai = nodo.getPai();
		if (nodo != null) {
			tamanho--;
			remove(nodo);
			balancearPais(pai);
		}
	}

	private void balancearPais(NodoAVL nodo) {
		if (nodo != null) {
			nodo.atualizaAltura();
			boolean eRaiz = nodo == raiz;

			nodo = balancear(nodo);
			if (eRaiz) {
				raiz = nodo;
			}
			balancearPais(nodo.getPai());
		}
	}

	private void remove(NodoAVL nodo) {
		if (nodo.getEsquerdo() == null && nodo.getDireito() == null) {
			// Os dois filhos são nulos
			if (nodo == raiz) {
				raiz = null;
			} else {
				NodoAVL pai = nodo.getPai();
				if (nodo == pai.getEsquerdo()) {
					pai.setEsquerdo(null);
				} else {
					pai.setDireito(null);
				}
				nodo.setPai(null);
			}
		} else if (nodo.getEsquerdo() == null || nodo.getDireito() == null) {
			// Um deles é nulo
			NodoAVL filho;
			if (nodo.getEsquerdo() != null) {
				filho = nodo.getEsquerdo();
				nodo.setEsquerdo(null);
			} else {
				filho = nodo.getDireito();
				nodo.setDireito(null);
			}
			if (nodo == raiz) {
				raiz = filho;
			} else {
				NodoAVL pai = nodo.getPai();
				if (nodo == pai.getEsquerdo()) {
					pai.setEsquerdo(filho);
				} else {
					pai.setDireito(filho);
				}
				filho.setPai(pai);
				nodo.setPai(null);
			}
		} else {
			// Nenhum dos dois é nulo
			// Escolhe um lado (nesse caso, o esquerdo) e pega o maior ou o menor
			NodoAVL escolhido = nodo.getEsquerdo().getMaior();
//			NodoAVL escolhido = nodo.getDireito().getMenor();
			remove(escolhido);
			troca(nodo, escolhido);
			if (nodo == raiz) {
				raiz = escolhido;
			}
		}
	}

	private void troca(NodoAVL velho, NodoAVL novo) {
		// Troca as referêncis do nodo antigo pelo novo
		novo.setPai(velho.getPai());
		novo.setEsquerdo(velho.getEsquerdo());
		if (velho.getEsquerdo() != null) {
			velho.getEsquerdo().setPai(novo);
		}
		novo.setDireito(velho.getDireito());
		if (velho.getDireito() != null) {
			velho.getDireito().setPai(novo);
		}

		// Se o nodo velho tem pai, troca as referências do pai tb
		if (velho.getPai() != null) {
			if (velho.getPai().getEsquerdo() == velho) {
				velho.getPai().setEsquerdo(novo);
			} else {
				velho.getPai().setDireito(novo);
			}
		}
	}

	public boolean vazia() {
		return tamanho == 0;
	}

	public boolean contem(Comparable chave) {
		return chaves().contains(chave);
	}

	public boolean contemValor(Object valor) {
		return valores().contains(valor);
	}

	public void limpa() {
		for (Object chave : chaves()) {
			remove((Comparable) chave);
		}
	}

	public Set chaves() {
		Set chaves = new HashSet();
		chaves(chaves, raiz);
		return chaves;
	}

	private void chaves(Set chaves, NodoAVL nodo) {
		if (nodo != null) {
			chaves.add(nodo.getChave());
			if (nodo.getEsquerdo() != null) {
				chaves(chaves, nodo.getEsquerdo());
			}
			if (nodo.getDireito() != null) {
				chaves(chaves, nodo.getDireito());
			}
		}

	}

	public List valores() {
		List valores = new ArrayList();
		valores(valores, raiz);
		return valores;
	}

	private void valores(List valores, NodoAVL nodo) {
		if (nodo != null) {
			valores.add(nodo.getValor());
			if (nodo.getEsquerdo() != null) {
				valores(valores, nodo.getEsquerdo());
			}
			if (nodo.getDireito() != null) {
				valores(valores, nodo.getDireito());
			}
		}
	}

	public void adicionaTodos(ArvoreAVL arvore) {
		for (Object chave : arvore.chaves()) {
			adiciona((Comparable) chave, arvore.busca((Comparable) chave));
		}
	}

	public ArvoreAVL clone() {
		ArvoreAVL novaArvore = new ArvoreAVL();
		// for (Object chave : chaves()) {
		// novaArvore.adiciona((Comparable) chave, busca((Comparable)chave));
		// } ----funcionou, mas não ficou exatamente igual
		clone(novaArvore, raiz);
		return novaArvore;
	}

	private void clone(ArvoreAVL arvore, NodoAVL nodo) {
		if (nodo != null) {
			arvore.adiciona(nodo.getChave(), nodo.getValor());
			if (nodo.getEsquerdo() != null) {
				clone(arvore, nodo.getEsquerdo());
			}
			if (nodo.getDireito() != null) {
				clone(arvore, nodo.getDireito());
			}
		}
	}

	public void travessiaPreOrdem(Visitante visitante) {
		travessiaPreOrdem(raiz, visitante);
	}

	private void travessiaPreOrdem(NodoAVL nodo, Visitante visitante) {
		if (nodo != null) {
			visitante.visita(nodo);

			if (nodo.getEsquerdo() != null) {
				travessiaPreOrdem(nodo.getEsquerdo(), visitante);
			}

			if (nodo.getDireito() != null) {
				travessiaPreOrdem(nodo.getDireito(), visitante);
			}
		}
	}

	public void travessiaEmOrdem(Visitante visitante) {
		travessiaEmOrdem(raiz, visitante);
	}

	private void travessiaEmOrdem(NodoAVL nodo, Visitante visitante) {
		if (nodo != null) {
			if (nodo.getEsquerdo() != null) {
				travessiaPreOrdem(nodo.getEsquerdo(), visitante);
			}

			visitante.visita(nodo);

			if (nodo.getDireito() != null) {
				travessiaPreOrdem(nodo.getDireito(), visitante);
			}
		}
	}

	public void travessiaPosOrdem(Visitante visitante) {
		travessiaPosOrdem(raiz, visitante);
	}

	private void travessiaPosOrdem(NodoAVL nodo, Visitante visitante) {
		if (nodo != null) {
			if (nodo.getEsquerdo() != null) {
				travessiaPosOrdem(nodo.getEsquerdo(), visitante);
			}

			if (nodo.getDireito() != null) {
				travessiaPosOrdem(nodo.getDireito(), visitante);
			}

			visitante.visita(nodo);
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		if (raiz != null) {
			montaString(raiz, sb, 1, "R");
		}
		return sb.toString();
	}

	private void montaString(NodoAVL nodo, StringBuilder sb, int nivel, String posicao) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(posicao + ": ");
		sb.append(nodo.getValor().toString());
		sb.append("\r\n");
		if (nodo.getEsquerdo() != null) {
			montaString(nodo.getEsquerdo(), sb, nivel + 1, "E");
		}
		if (nodo.getDireito() != null) {
			montaString(nodo.getDireito(), sb, nivel + 1, "D");
		}
	}
}
