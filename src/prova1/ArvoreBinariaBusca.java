package prova1;

public class ArvoreBinariaBusca {

	private Nodo raiz;
	private int tamanho;

	public ArvoreBinariaBusca() {

	}

	public Nodo raiz() {
		return raiz;
	}

	public int tamanho() {
		return tamanho;
	}

	public void adiciona(Comparable info) {
		if (raiz == null) {
			Nodo novoNodo = new Nodo(info);
			raiz = novoNodo;
			tamanho++;
		} else {
			adiciona(info, raiz);
		}
	}

	private void adiciona(Comparable info, Nodo nodo) {
		if (info.compareTo(nodo.getInfo()) > 0) {
			if (nodo.getDireito() == null) {
				Nodo novoNodo = new Nodo(info);
				nodo.setDireito(novoNodo);
				novoNodo.setPai(nodo);
				tamanho++;
				return;
			}
			adiciona(info, nodo.getDireito());
		} else if (info.compareTo(nodo.getInfo()) < 0) {
			if (nodo.getEsquerdo() == null) {
				Nodo novoNodo = new Nodo(info);
				nodo.setEsquerdo(novoNodo);
				novoNodo.setPai(nodo);
				tamanho++;
				return;
			}
			adiciona(info, nodo.getEsquerdo());
		}
	}

	public Nodo busca(Comparable info) {
		return busca(info, raiz);
	}

	private Nodo busca(Comparable info, Nodo nodo) {
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

	public Nodo minimo() {
		return raiz.getMenor();
	}

	public Nodo maximo() {
		return raiz.getMaior();
	}
	
	public int contagem() {
		return raiz.contagem();
	}

	public Nodo sucessor(Nodo nodo) {
		if (nodo != null) {
			if (nodo == maximo()) {
				return null;
			}
			if (nodo.getDireito() != null) {
				if (nodo.getDireito().getEsquerdo() == null) {
					return nodo.getDireito();
				}
				if (nodo.getDireito().getEsquerdo() != null) {
					Nodo resultado = nodo.getDireito();
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
						Nodo resultado = nodo;
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

	public Nodo predecessor(Nodo nodo) {
		if (nodo != null) {
			if (nodo == minimo()) {
				return null;
			}
			if (nodo.getEsquerdo() != null) {
				if (nodo.getEsquerdo().getDireito() == null) {
					return nodo.getEsquerdo();
				}
				if (nodo.getEsquerdo().getDireito() != null) {
					Nodo resultado = nodo.getEsquerdo();
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
						Nodo resultado = nodo;
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
		Nodo nodo = busca(info);
		if (nodo != null) {
			remove(nodo);
		}
	}

	public void remove(Nodo nodo) {
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
			Nodo filho;
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
				Nodo pai = nodo.getPai();
				if (nodo == pai.getEsquerdo()) {
					pai.setEsquerdo(filho);
				} else {
					pai.setDireito(filho);
				}
				filho.setPai(pai);
				nodo.setPai(null);
			}
		} else {
			Nodo escolhido = nodo.getDireito().getMenor();
			remove(escolhido);
			troca(nodo, escolhido);
			if (nodo == raiz) {
				raiz = escolhido;
			}
		}
	}
	
	private void troca(Nodo velho, Nodo novo) {
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
	
	public ArvoreBinariaBusca copia() {
		ArvoreBinariaBusca novaArvore = new ArvoreBinariaBusca();
		return criaArvoreCopia(novaArvore, raiz);
	}

	private ArvoreBinariaBusca criaArvoreCopia(ArvoreBinariaBusca novaArvore, Nodo nodo) {
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

	private void travessiaPreOrdem(Nodo nodo, Visitante visitante) {
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

	private void travessiaEmOrdem(Nodo nodo, Visitante visitante) {
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

	private void travessiaPosOrdem(Nodo nodo, Visitante visitante) {
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

	private void montaString(Nodo nodo, StringBuilder sb, int nivel, String posicao) {
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
