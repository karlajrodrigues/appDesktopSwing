package prova;

public class Pessoa extends Animal {
	public void comerComidaSaudavel() {
		System.out.println("Metodo de comer comida processada ");
	}
	// Polimorfismo 
	public void emitirSom() {
		System.out.println("Falar");
	}
	
	// Polimorfismo 
	public void dormir() {
		System.out.println("Pessoa dormindo");
	}
}
