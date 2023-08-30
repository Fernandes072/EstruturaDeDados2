package a01;

public class Potencia {

	private static int calcularPot(int b, int e) {
		if (e == 0) {
			return 1;
		} else {
			return b * calcularPot(b, e - 1);
		}
	}

	public static void main(String[] args) {

		System.out.println(calcularPot(2, 5));
	}
}
