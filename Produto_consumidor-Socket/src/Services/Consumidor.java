package Services;

public class Consumidor {
	private Fabrica fabrica;
	
	public Consumidor(Fabrica fabrica) {
		this.fabrica = fabrica;
	}
	
	//Consome a primeira mensagem e subtrai o contador, mutex e items
	public void consumir() {
		String mensagem = this.fabrica.getMsg(0);
		this.fabrica.delMsg(0);
		fabrica.subtrairContador();
		fabrica.subtrairMutex();
		fabrica.subtrairItems();
		System.out.println("Algumas coisas foram consumidas. Mensagem enviada pelo produtor: " + mensagem);
	}
	
}
