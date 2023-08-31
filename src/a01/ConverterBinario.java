package a01;

public class ConverterBinario {

	private static String converter(int num) {
		if (num <= 1) {
			return "" + num;
		}
		int aux = num % 2;
		return converter(num / 2) + aux;
	}

	public static void main(String[] args) {
		for (int i = 0; i < 15; i++) {
			System.out.println(converter(i));
		}
	}
}
