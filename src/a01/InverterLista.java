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
		System.out.println(lista[0] + " " + lista[1] + " " + lista[2] + " " + lista[3] + " " + lista[4]);
		int j = lista.length - 1;
		int[] nlista = inverter(lista, 0, j);
		System.out.println(nlista[0] + " " + nlista[1] + " " + nlista[2] + " " + nlista[3] + " " + nlista[4]);

	}

}