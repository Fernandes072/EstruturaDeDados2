package a09levi;

public class Programa {

	public static void main(String[] args) {
		ArvoreAVL arvore = new ArvoreAVL();
		arvore.adiciona("carro1");
		arvore.adiciona("carro2");
		arvore.adiciona("carro3");
		arvore.adiciona("carro4");
		arvore.adiciona("carro5");
		arvore.adiciona("carro6");
		arvore.adiciona("carro7");
		arvore.adiciona("carro8");
		System.out.println(arvore);
		
		arvore.remove("carro4");
		System.out.println(arvore);
	}

}