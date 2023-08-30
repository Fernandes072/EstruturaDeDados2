package a01;

public class SomaLista {

	private static float somar(float[] lista, int i) {
		if (i == 0) {
			return lista[0];
		} else {
			return lista[i] + somar(lista, i - 1);
		}
	}

	public static void main(String[] args) {

		float lista[] = { 1, 2, 3, 4, 5 };
		int i = lista.length - 1;
		System.out.println(somar(lista, i));
	}

}
