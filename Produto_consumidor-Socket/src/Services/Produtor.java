package Services;

public class Produtor {
	private Fabrica fabrica;
	
	public Produtor(Fabrica fabrica) {
		this.fabrica = fabrica;
	}
	
	public void produzir() {
		fabrica.somarContador();
		fabrica.somarMutex();
		fabrica.somarItems();
		System.out.println("Algumas coisas foram produzidas");
	}
}
