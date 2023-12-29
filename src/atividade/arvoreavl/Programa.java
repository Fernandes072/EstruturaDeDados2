package atividade.arvoreavl;

public class Programa {

	public static void main(String[] args) {


		ArvoreAVL arvore = new ArvoreAVL();
		arvore.adiciona(1f, "carro1");
		arvore.adiciona(2f, "carro2");
		arvore.adiciona(3f, "carro3");
		arvore.adiciona(4f, "carro4");
		arvore.adiciona(5f, "carro5");
		arvore.adiciona(6f, "carro6");
		arvore.adiciona(7f, "carro7");
		arvore.adiciona(8f, "carro8");
		System.out.println(arvore);
		
		ArvoreAVL arvore2 = new ArvoreAVL();
		arvore2.adiciona(10f, "carro10");
		arvore2.adiciona(11f, "carro11");
		arvore2.adiciona(12f, "carro12");
		arvore2.adiciona(13f, "carro13");
		System.out.println(arvore2);
		
		arvore.adicionaTodos(arvore2);
		System.out.println(arvore);
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println(arvore.clone());


	}

}
