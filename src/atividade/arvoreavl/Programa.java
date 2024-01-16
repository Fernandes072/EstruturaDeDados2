package atividade.arvoreavl;

public class Programa {

	public static void main(String[] args) {


		ArvoreAVL arvore = new ArvoreAVL();
		System.out.println(arvore.getTamanho());
		System.out.println(arvore.vazia());
		arvore.adiciona(1f, "carro1");
		arvore.adiciona(2f, "carro2");
		arvore.adiciona(3f, "carro3");
		arvore.adiciona(4f, "carro4");
		arvore.adiciona(5f, "carro5");
		arvore.adiciona(6f, "carro6");
		arvore.adiciona(7f, "carro7");
		arvore.adiciona(8f, "carro8");
		System.out.println(arvore.getTamanho());
		System.out.println(arvore);
		System.out.println(arvore.busca(5f));
		arvore.remove(4f);
		System.out.println(arvore.vazia());
		System.out.println(arvore.getTamanho());
		System.out.println(arvore);
		System.out.println(arvore.contem(2f));
		System.out.println(arvore.contem(10f));
		System.out.println(arvore.contemValor("carro8"));
		System.out.println(arvore.contemValor("moto"));
		
		ArvoreAVL arvore2 = new ArvoreAVL();
		arvore2.adiciona(20f, "carro20");
		arvore2.adiciona(30f, "carro30");
		arvore2.adiciona(40f, "carro40");
		arvore2.adiciona(50f, "carro50");
		System.out.println(arvore2);
		
		arvore.adicionaTodos(arvore2);
		System.out.println(arvore);
		System.out.println(arvore.clone());
		System.out.println(arvore.chaves());
		System.out.println(arvore.valores());
		
		
		arvore.limpa();
		System.out.println(arvore);
		System.out.println(arvore.vazia());
		System.out.println(arvore.getTamanho());


	}

}
