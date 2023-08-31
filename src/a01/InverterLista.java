package a01;

public class InverterLista {

	private static int[] inverter(int[] lista, int aux) {
		if (aux <= lista.length / 2) {
			return lista;
		} else {
			int i = lista.length - 1 - aux;
			int j = aux;
			int num = lista[j];
			lista[j] = lista[i];
			lista[i] = num;
			return inverter(lista, aux - 1);
		}
	}

	public static void main(String[] args) {

		int[] lista1 = { 1, 2, 3, 4, 5 };
		for (int aux = 0; aux < lista1.length; aux++) {
			System.out.print(lista1[aux] + " ");
		}
		System.out.println();

		int[] nlista1 = inverter(lista1, lista1.length - 1);
		for (int aux = 0; aux < lista1.length; aux++) {
			System.out.print(nlista1[aux] + " ");
		}
		System.out.println();
		System.out.println();

		int[] lista2 = { 1, 2, 3, 4, 5, 6 };
		for (int aux = 0; aux < lista2.length; aux++) {
			System.out.print(lista2[aux] + " ");
		}
		System.out.println();

		int[] nlista2 = inverter(lista2, lista2.length - 1);
		for (int aux = 0; aux < lista2.length; aux++) {
			System.out.print(nlista2[aux] + " ");
		}
		System.out.println();
	}

}