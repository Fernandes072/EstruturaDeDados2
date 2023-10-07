package a05;

import java.util.Stack;

public class VisitanteExpressao implements Visitante {

	private Stack<Double> pilha = new Stack<Double>();

	public void visita(NodoAB nodo) {
		if (nodo != null) {
			if (nodo.getInfo().equals("+") || nodo.getInfo().equals("-") || nodo.getInfo().equals("*")
					|| nodo.getInfo().equals("/")) {
				double direito = pilha.pop();
				double esquerdo = pilha.pop();
				if (nodo.getInfo().equals("+")) {
					pilha.push(esquerdo + direito);
				} else if (nodo.getInfo().equals("-")) {
					pilha.push(esquerdo - direito);
				} else if (nodo.getInfo().equals("*")) {
					pilha.push(esquerdo * direito);
				} else if (nodo.getInfo().equals("/")) {
					pilha.push(esquerdo / direito);
				}
			} else {
				pilha.push(Double.parseDouble(nodo.getInfo().toString()));
			}
		}
	}

	public double getResultado() {
		return pilha.peek();
	}

	/*
	 * private double esquerdo; private double direito; private double total;
	 * 
	 * @Override public void visita(NodoAB nodo) { System.out.println(total + " " +
	 * esquerdo + " " + direito); if (nodo != null) { if
	 * (!nodo.getInfo().equals("+") && !nodo.getInfo().equals("-") &&
	 * !nodo.getInfo().equals("*") && !nodo.getInfo().equals("/")) { if
	 * (nodo.getPai().getEsquerdo().getInfo().equals(nodo.getInfo())) { esquerdo =
	 * Double.parseDouble(nodo.getInfo().toString()); } else { direito =
	 * Double.parseDouble(nodo.getInfo().toString()); } } else { if
	 * (nodo.getInfo().equals("+")) { total += esquerdo + direito; } else if
	 * (nodo.getInfo().equals("-")) { total += esquerdo - direito; } else if
	 * (nodo.getInfo().equals("*")) { total += esquerdo * direito; } else if
	 * (nodo.getInfo().equals("/")) { total += esquerdo / direito; } } } }
	 * 
	 * public double getResultado() { return total; }
	 */
}
