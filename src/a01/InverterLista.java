package a01;

public class InverterLista {

	private static int[] inverter(int[] lista, int i, int j) {
		if (i >= j) {
			return lista;
		} else {
			int num = lista[j];
			lista[j] = lista[i];
			lista[i] = num;
			return inverter(lista, i + 1, j - 1);
		}
	}

	public static void main(String[] args) {

		int[] lista = { 1, 2, 3, 4, 5 };
		for (int aux = 0; aux < lista.length; aux++) {
			System.out.print(lista[aux] + " ");
		}
		System.out.println();
		
		int j = lista.length - 1;
		int[] nlista = inverter(lista, 0, j);
		for (int aux = 0; aux < lista.length; aux++) {
			System.out.print(nlista[aux] + " ");
		}
		System.out.println();
	}

}