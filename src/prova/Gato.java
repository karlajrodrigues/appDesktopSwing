package prova;

public class Gato implements AnimalInterface{

	public void fazerSom() {
		System.out.println("Miau....");
		
	}

	@Override
	public void mover() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("O gato anda");
	}

	@Override
	public void comer() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("O gato come");
	}

	@Override
	public void dormir() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("O gato dorme");
	}

	@Override
	public void necessidades() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("o gato vai na caixa de areia");
	}

	@Override
	public void reproducao() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("O gato cruza com uma gatinha");
	}
	
	
	

}
