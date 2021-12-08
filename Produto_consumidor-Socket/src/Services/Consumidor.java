package Services;

public class Consumidor {
	private Fabrica fabrica;
	
	public Consumidor(Fabrica fabrica) {
		this.fabrica = fabrica;
	}
	
	public void consumir() {
		fabrica.subtrairContador();
		fabrica.subtrairMutex();
		fabrica.subtrairItems();
	}
	
}
