package prova;

public class Cachorro extends Animal{

	private String raca;
	private String cor;
	private String porte;
	//6
	private String nome;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	// fim da questão 6
	
	
	// metodo construtor
	public Cachorro(String raca, String cor, String porte) {
		this.raca = raca;
		this.cor = cor;
		this.porte = porte;
	}
	public Cachorro() {
		
	}
	
	public void emitirSom() {
		System.out.println("Au Au ");
	}
}
