package prova;

public class TesteConceito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Teste do polimorfismo
		Pessoa p = new Pessoa();
		p.emitirSom();
		
		
		
		//inicializa��o de uma classe utilizando construtor com atributos
		Cachorro c = new Cachorro("Sem ra�a definida", "Caramelo", "M�dio");
		c.emitirSom();
		c.comer();
	}

}
