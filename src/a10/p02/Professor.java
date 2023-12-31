package a10.p02;

public class Professor {
	
	private String nome;
	private double salario;
	
	public Professor(String nome, int salario) {
		this.nome = nome;
		this.salario = salario;
	}
	
	public Professor() {
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public void setSalario(double salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Professor [nome=" + nome + ", salario=" + salario + "]";
	}
}
