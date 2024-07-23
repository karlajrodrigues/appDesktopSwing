package prova;
// Classe abstratas
public abstract class Rato {

	public Rato() {
		// TODO Auto-generated constructor stub
	}
	//metodo concreto com implementação
	public void mover() {
		System.out.println("Animal rato se movendo");
	}
	// metodo abstrato sem implementação
	public abstract void fazerSom() ;
}
