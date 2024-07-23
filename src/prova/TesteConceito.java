package prova;

public class TesteConceito {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Teste do polimorfismo
		Pessoa p = new Pessoa();
		p.emitirSom();
		
		
		
		//inicialização de uma classe utilizando construtor com atributos
		Cachorro c = new Cachorro("Sem raça definida", "Caramelo", "Médio");
		c.emitirSom();
		c.comer();
	}

}
