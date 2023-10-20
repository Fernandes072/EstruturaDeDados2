package a06;

public class ArvoreBinaria {

	private NodoAB raiz;
	private int tamanho;

	public ArvoreBinaria() {

	}

	public NodoAB adiciona(Object info) {
		if (tamanho == 0) {
			return criaRaiz(info);
		} else {
			return adiciona(info, raiz);
		}
	}

	private NodoAB adiciona(Object info, NodoAB nodo) {
		if (((Float) info) < ((Float) nodo.getInfo())) {
			if (nodo.getEsquerdo() == null) {
				return adicionaEsquerdo(nodo, info);
			}
			adiciona(info, nodo.getEsquerdo());
		} else if (((Float) info) > ((Float) nodo.getInfo())) {
			if (nodo.getDireito() == null) {
				return adicionaDireito(nodo, info);
			}
			adiciona(info, nodo.getDireito());
		}
		return null;
	}

	private NodoAB criaRaiz(Object info) {
		NodoAB nodo = new NodoAB(info);
		raiz = nodo;
		tamanho++;
		return nodo;
	}

	private NodoAB adicionaEsquerdo(NodoAB pai, Object info) {
		if (pai.getEsquerdo() != null) {
			throw new RuntimeException("Já possui filho esquerdo");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setEsquerdo(nodo);
		tamanho++;
		return nodo;
	}

	private NodoAB adicionaDireito(NodoAB pai, Object info) {
		if (pai.getDireito() != null) {
			throw new RuntimeException("Já possui filho direito");
		}
		NodoAB nodo = new NodoAB(info);
		nodo.setPai(pai);
		pai.setDireito(nodo);
		tamanho++;
		return nodo;
	}

	public NodoAB busca(Object info) {
		return busca(info, raiz, new NodoAB(null));
	}

	private NodoAB busca(Object info, NodoAB nodo, NodoAB resultado) {
		if (info.toString().equals(nodo.getInfo().toString())) {
			resultado = nodo;
		}
		if (((Float) info) < ((Float) nodo.getInfo())) {
			resultado = busca(info, nodo.getEsquerdo(), resultado);
		} else if (((Float) info) > ((Float) nodo.getInfo())) {
			resultado = busca(info, nodo.getDireito(), resultado);
		}
		return resultado;
	}

	public NodoAB minimo() {
		NodoAB nodo = raiz;
		while (nodo.getEsquerdo() != null) {
			nodo = nodo.getEsquerdo();
		}
		return nodo;
	}

	public NodoAB maximo() {
		NodoAB nodo = raiz;
		while (nodo.getDireito() != null) {
			nodo = nodo.getDireito();
		}
		return nodo;
	}

	public NodoAB sucessor(NodoAB nodo) {
		if (nodo != null) {
			if (nodo.getInfo().equals(maximo().getInfo())) {
				return null;
			}
			if (nodo.getDireito() != null) {
				if (nodo.getDireito().getEsquerdo() == null) {
					return nodo.getDireito();
				}
				if (nodo.getDireito().getEsquerdo() != null) {
					NodoAB resultado = nodo.getDireito();
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
					NodoAB resultado = nodo;
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

	public NodoAB predecessor(NodoAB nodo) {
		if (nodo != null) {
			if (nodo.getInfo().equals(minimo().getInfo())) {
				return null;
			}
			if (nodo.getEsquerdo() != null) {
				if (nodo.getEsquerdo().getDireito() == null) {
					return nodo.getEsquerdo();
				}
				if (nodo.getEsquerdo().getDireito() != null) {
					NodoAB resultado = nodo.getEsquerdo();
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
					NodoAB resultado = nodo;
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

	public void remover(NodoAB nodo) {
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
			nodo.getPai().setEsquerdo(nodo.getEsquerdo());
			nodo.getEsquerdo().setPai(nodo.getPai());
			nodo.setPai(null);
			nodo.setEsquerdo(null);
		}
		if (nodo.getEsquerdo() == null && nodo.getDireito() != null) {
			nodo.getPai().setDireito(nodo.getDireito());
			nodo.getDireito().setPai(nodo.getPai());
			nodo.setPai(null);
			nodo.setDireito(null);
		}
		if (nodo.getEsquerdo() != null && nodo.getDireito() != null) {
			NodoAB resultado = nodo.getEsquerdo();
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

	public int tamanho() {
		return tamanho;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		prepararString(raiz, sb, 0);
		return sb.toString();
	}

	private static void prepararString(NodoAB nodo, StringBuilder sb, int nivel) {
		for (int i = 0; i < nivel; i++) {
			sb.append("  ");
		}
		sb.append(nodo.getInfo().toString());
		sb.append("\r\n");
		if (nodo.getEsquerdo() != null) {
			prepararString(nodo.getEsquerdo(), sb, nivel + 1);
		}
		if (nodo.getDireito() != null) {
			prepararString(nodo.getDireito(), sb, nivel + 1);
		}
	}
}
