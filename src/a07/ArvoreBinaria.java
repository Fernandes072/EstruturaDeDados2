package a07;

public class ArvoreBinaria {

	private Nodo raiz;
	private int tamanho;

	public ArvoreBinaria() {

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
		Nodo resultado = raiz;
		while (resultado.getEsquerdo() != null) {
			resultado = resultado.getEsquerdo();
		}
		return resultado;
	}
	
	public Nodo maximo() {
		Nodo resultado = raiz;
		while (resultado.getDireito() != null) {
			resultado = resultado.getDireito();
		}
		return resultado;
	}

	public int grau(Nodo nodo) {
		return nodo.grau();
	}
	
	public int nivel(Nodo nodo) {
		return nodo.nivel();
	}
	
	public int altura(Nodo nodo) {
		return nodo.altura();
	}
	
	public Nodo sucessor(Nodo nodo) {
		if (nodo != null) {
			if (nodo.getInfo().equals(maximo().getInfo())) {
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
					if (nodo.getInfo().equals(nodo.getPai().getEsquerdo().getInfo())) {
						return nodo.getPai();
					}
				}
				if (nodo.getInfo().equals(nodo.getPai().getDireito().getInfo())) {
					Nodo resultado = nodo;
					while (resultado.getPai() != null) {
						if (resultado.getPai().getEsquerdo() != null) {
							if (resultado.getInfo().equals(resultado.getPai().getEsquerdo().getInfo())) {
								return resultado.getPai();
							}
						}
						resultado = resultado.getPai();
					}
					return resultado;
				}
			}
		}
		return null;
	}
	
	public Nodo predecessor(Nodo nodo) {
		if (nodo != null) {
			if (nodo.getInfo().equals(minimo().getInfo())) {
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
					if (nodo.getInfo().equals(nodo.getPai().getDireito().getInfo())) {
						return nodo.getPai();
					}
				}
				if (nodo.getInfo().equals(nodo.getPai().getEsquerdo().getInfo())) {
					Nodo resultado = nodo;
					while (resultado.getPai() != null) {
						if (resultado.getPai().getDireito() != null) {
							if (resultado.getInfo().equals(resultado.getPai().getDireito().getInfo())) {
								return resultado.getPai();
							}
						}
						resultado = resultado.getPai();
					}
					return resultado;
				}
			}
		}
		return null;
	}
	
	public void remove(Nodo nodo) {
		if (nodo.getEsquerdo() == null && nodo.getDireito() == null) {
			if (nodo.getInfo().equals(nodo.getPai().getEsquerdo().getInfo())) {
				nodo.getPai().setEsquerdo(null);
				nodo.setPai(null);
			} else {
				nodo.getPai().setDireito(null);
				nodo.setPai(null);
			}
		}
		if (nodo.getEsquerdo() != null && nodo.getDireito() == null) {
			if (nodo.getInfo().equals(nodo.getPai().getEsquerdo().getInfo())) {
				nodo.getPai().setEsquerdo(nodo.getEsquerdo());
				nodo.getEsquerdo().setPai(nodo.getPai());
			} else {
				nodo.getPai().setDireito(nodo.getEsquerdo());
				nodo.getEsquerdo().setPai(nodo.getPai());
			}
			nodo.setPai(null);
			nodo.setEsquerdo(null);
		}
		if (nodo.getEsquerdo() == null && nodo.getDireito() != null) {
			if (nodo.getInfo().equals(nodo.getPai().getEsquerdo().getInfo())) {
				nodo.getPai().setEsquerdo(nodo.getDireito());
				nodo.getDireito().setPai(nodo.getPai());
			} else {
				nodo.getPai().setDireito(nodo.getDireito());
				nodo.getDireito().setPai(nodo.getPai());
			}
			nodo.setPai(null);
			nodo.setEsquerdo(null);
		}
		if (nodo.getEsquerdo() != null && nodo.getDireito() != null) {
			Nodo resultado = nodo.getEsquerdo();
			while (resultado.getDireito() != null) {
				resultado = resultado.getDireito();
			}
			if (resultado.getEsquerdo() == null && resultado.getDireito() == null) {
				if (resultado.getInfo().equals(resultado.getPai().getEsquerdo().getInfo())) {
					resultado.getPai().setEsquerdo(null);
				} else {
					resultado.getPai().setDireito(null);
				}
				nodo.getEsquerdo().setPai(resultado);
				nodo.getDireito().setPai(resultado);
				if (nodo.getInfo().equals(nodo.getPai().getEsquerdo().getInfo())) {
					nodo.getPai().setEsquerdo(resultado);
				} else {
					nodo.getPai().setDireito(resultado);
				}
				resultado.setEsquerdo(nodo.getEsquerdo());
				resultado.setDireito(nodo.getDireito());
				resultado.setPai(nodo.getPai());
				nodo.setDireito(null);
				nodo.setEsquerdo(null);
				nodo.setPai(null);
			}
		}
	}
	
	public Nodo raiz() {
		return raiz;
	}

	public int tamanho() {
		return tamanho;
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
