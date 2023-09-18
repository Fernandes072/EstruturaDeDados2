package a03;

import java.util.List;

public class Programa {

	public static void main(String[] args) {

		/*Nodo veiculo = new Nodo("Veiculo");

		Nodo aereo = new Nodo("Aereo");
		veiculo.adicionaFilho(aereo);
		Nodo terrestre = new Nodo("Terrestre");
		veiculo.adicionaFilho(terrestre);
		Nodo aquatico = new Nodo("Aquatico");
		veiculo.adicionaFilho(aquatico);

		Nodo aviao = new Nodo("Avião");
		aereo.adicionaFilho(aviao);
		Nodo heli = new Nodo("Helicóptero");
		aereo.adicionaFilho(heli);

		Nodo carro = new Nodo("Carro");
		terrestre.adicionaFilho(carro);
		Nodo moto = new Nodo("Motocicleta");
		terrestre.adicionaFilho(moto);

		Nodo aMotor = new Nodo("A Motor");
		aquatico.adicionaFilho(aMotor);
		Nodo aVela = new Nodo("A vela");
		aquatico.adicionaFilho(aVela);
		Nodo aRemo = new Nodo("A remo");
		aquatico.adicionaFilho(aRemo);

		Nodo navio = new Nodo("Navio");
		aMotor.adicionaFilho(navio);
		Nodo iate = new Nodo("Iate");
		aMotor.adicionaFilho(iate);
		Nodo lancha = new Nodo("Lancha");
		aMotor.adicionaFilho(lancha);

		System.out.println(veiculo);*/

		/*System.out.println(aviao.pegaPai());
		System.out.println();

		Object[] filhos = veiculo.pegaFilhos();
		for (Object object : filhos) {
			System.out.println(object);
		}
		System.out.println();

		System.out.println(veiculo.eRaiz());
		System.out.println();

		System.out.println(aMotor.eFolha());
		System.out.println();

		System.out.println(aereo.grau());
		System.out.println();

		System.out.println(iate.nivel());
		System.out.println();

		System.out.println("Contagem: " + iate.contagem());
		System.out.println();
		
		System.out.println("Busca: " + veiculo.busca("Avião"));
		System.out.println();
		System.out.println(veiculo.contagem());*/
		
		Nodo A = new Nodo("A");
		Nodo B = new Nodo("B");
		Nodo C = new Nodo("C");
		Nodo D = new Nodo("D");
		Nodo E = new Nodo("E");
		Nodo F = new Nodo("F");
		Nodo G = new Nodo("G");
		Nodo H = new Nodo("H");
		Nodo I = new Nodo("I");
		Nodo J = new Nodo("J");
		A.adicionaFilho(B);
		A.adicionaFilho(C);
		A.adicionaFilho(D);
		B.adicionaFilho(E);
		C.adicionaFilho(F);
		C.adicionaFilho(G);
		D.adicionaFilho(H);
		H.adicionaFilho(I);
		H.adicionaFilho(J);
		System.out.println(A);
		List<Nodo> irmaos = B.irmaos();
		for (Nodo irmao : irmaos) {
			System.out.println(irmao);
		}
		System.out.println(A);
	}

}
