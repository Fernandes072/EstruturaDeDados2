package a09;

public class ArvoreAVL {

	private NodoAVL raiz;
	private int tamanho;

	public ArvoreAVL() {

	}

	public NodoAVL raiz() {
		return raiz;
	}

	public int tamanho() {
		return tamanho;
	}

	public void adiciona(Comparable info) {
		if (raiz == null) {
			NodoAVL novoNodo = new NodoAVL(info);
			raiz = novoNodo;
			tamanho++;
			raiz.atualizaAltura();
		} else {
			adiciona(info, raiz);
			raiz.atualizaAltura();
		}
	}

	private void adiciona(Comparable info, NodoAVL nodo) {
		if (info.compareTo(nodo.getInfo()) > 0) {
			if (nodo.getDireito() == null) {
				NodoAVL novoNodo = new NodoAVL(info);
				nodo.setDireito(novoNodo);
				novoNodo.setPai(nodo);
				tamanho++;
				novoNodo.atualizaAltura();
				nodo.atualizaAltura();
				balancear(nodo);
				return;
			}
			adiciona(info, nodo.getDireito());
			nodo.atualizaAltura();
			balancear(nodo);
		} else if (info.compareTo(nodo.getInfo()) < 0) {
			if (nodo.getEsquerdo() == null) {
				NodoAVL novoNodo = new NodoAVL(info);
				nodo.setEsquerdo(novoNodo);
				novoNodo.setPai(nodo);
				tamanho++;
				novoNodo.atualizaAltura();
				nodo.atualizaAltura();
				balancear(nodo);
				return;
			}
			adiciona(info, nodo.getEsquerdo());
			nodo.atualizaAltura();
			balancear(nodo);
		}
	}

	private NodoAVL balancear(NodoAVL nodo) {
		int fator = nodo.getFator();
		if (fator == 2) { // Desbalanceado para a direita;
			// Balancear
			if (nodo.getDireito().getFator() > 0) {
				rotacaoEsquerda(nodo);
			} else {
				rotacaoDuplaEsquerda(nodo);
			}
		} else if (fator == -2) { // Desbalanceado para a esquerda;
			// Balancear
			if (nodo.getEsquerdo().getFator() < 0) {
				rotacaoDireita(nodo);
			} else {
				rotacaoDuplaDireita(nodo);
			}
		}
		nodo.atualizaAltura();
		return nodo;
	}

	private void rotacaoDuplaDireita(NodoAVL nodo) {
		rotacaoEsquerda(nodo.getEsquerdo());
		rotacaoDireita(nodo);
	}

	private void rotacaoDireita(NodoAVL nodo) {
		NodoAVL filhoEsquerdo = nodo.getEsquerdo();
		NodoAVL pai = nodo.getPai();
		if (filhoEsquerdo.getDireito() == null) {
			if (pai != null) {
				pai.setEsquerdo(filhoEsquerdo);
				filhoEsquerdo.setDireito(nodo);
				filhoEsquerdo.setPai(pai);
				nodo.setPai(filhoEsquerdo);
				nodo.setEsquerdo(null);
			} else {
				raiz = filhoEsquerdo;
				filhoEsquerdo.setDireito(nodo);
				filhoEsquerdo.setPai(null);
				nodo.setEsquerdo(null);
			}
		} else {
			if (pai != null) {
				NodoAVL direito = filhoEsquerdo.getDireito();
				pai.setEsquerdo(filhoEsquerdo);
				filhoEsquerdo.setDireito(nodo);
				filhoEsquerdo.setPai(pai);
				nodo.setPai(filhoEsquerdo);
				nodo.setEsquerdo(direito);
			} else {
				NodoAVL direito = filhoEsquerdo.getDireito();
				raiz = filhoEsquerdo;
				filhoEsquerdo.setDireito(nodo);
				filhoEsquerdo.setPai(null);
				nodo.setEsquerdo(direito);
			}
		}
	}

	private void rotacaoDuplaEsquerda(NodoAVL nodo) {
		rotacaoDireita(nodo.getDireito());
		rotacaoEsquerda(nodo);

	}

	private void rotacaoEsquerda(NodoAVL nodo) {
		NodoAVL filhoDireito = nodo.getDireito();
		NodoAVL pai = nodo.getPai();
		if (filhoDireito.getEsquerdo() == null) {
			if (pai != null) {
				pai.setDireito(filhoDireito);
				filhoDireito.setEsquerdo(nodo);
				filhoDireito.setPai(pai);
				nodo.setPai(filhoDireito);
				nodo.setDireito(null);
			} else {
				raiz = filhoDireito;
				filhoDireito.setEsquerdo(nodo);
				filhoDireito.setPai(null);
				nodo.setDireito(null);
			}
		} else {
			if (pai != null) {
				NodoAVL esquerdo = filhoDireito.getEsquerdo();
				pai.setDireito(filhoDireito);
				filhoDireito.setEsquerdo(nodo);
				filhoDireito.setPai(pai);
				nodo.setPai(filhoDireito);
				nodo.setDireito(esquerdo);
			} else {
				NodoAVL esquerdo = filhoDireito.getEsquerdo();
				raiz = filhoDireito;
				filhoDireito.setEsquerdo(nodo);
				filhoDireito.setPai(null);
				nodo.setDireito(esquerdo);
			}
		}
	}

	public NodoAVL busca(Comparable info) {
		return busca(info, raiz);
	}

	private NodoAVL busca(Comparable info, NodoAVL nodo) {
		if (nodo != null) {
			if (info.compareTo(nodo.getInfo()) == 0) {
				return nodo;
			}
			if (info.compareTo(nodo.getInfo()) < 0) {
				return busca(info, nodo.getEsquerdo());
			}
			if (info.compareTo(nodo.getInfo()) > 0) {
				return busca(info, nodo.getDireito());
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

	public void remove(Comparable info) {
		NodoAVL nodo = busca(info);
		if (nodo != null) {
			remove(nodo);
		}
	}

	public void remove(NodoAVL nodo) {
		if (nodo.getEsquerdo() == null && nodo.getDireito() == null) {
			if (nodo == raiz) {
				raiz = null;
			} else {
				if (nodo == nodo.getPai().getEsquerdo()) {
					nodo.getPai().setEsquerdo(null);
				} else {
					nodo.getPai().setDireito(null);
				}
				nodo.setPai(null);
			}
		} else if (nodo.getEsquerdo() == null || nodo.getDireito() == null) {
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
			NodoAVL escolhido = nodo.getDireito().getMenor();
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
		novo.setDireito(velho.getDireito());

		// Se o nodo velho tem pai, troca as referências do pai tb
		if (velho.getPai() != null) {
			if (velho.getPai().getEsquerdo() == velho) {
				velho.getPai().setEsquerdo(novo);
			} else {
				velho.getPai().setDireito(novo);
			}
		}
	}

	public ArvoreAVL copia() {
		ArvoreAVL novaArvore = new ArvoreAVL();
		return criaArvoreCopia(novaArvore, raiz);
	}

	private ArvoreAVL criaArvoreCopia(ArvoreAVL novaArvore, NodoAVL nodo) {
		novaArvore.adiciona(nodo.getInfo());

		if (nodo.getEsquerdo() != null) {
			criaArvoreCopia(novaArvore, nodo.getEsquerdo());
		}
		if (nodo.getDireito() != null) {
			criaArvoreCopia(novaArvore, nodo.getDireito());
		}
		return novaArvore;
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
		montaString(raiz, sb, 1, "R");
		return sb.toString();
	}

	private void montaString(NodoAVL nodo, StringBuilder sb, int nivel, String posicao) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(posicao + ": ");
		sb.append(nodo.getInfo().toString());
		sb.append("\r\n");
		if (nodo.getEsquerdo() != null) {
			montaString(nodo.getEsquerdo(), sb, nivel + 1, "E");
		}
		if (nodo.getDireito() != null) {
			montaString(nodo.getDireito(), sb, nivel + 1, "D");
		}
	}
}
