package Services;

public class Produtor {
	private Fabrica fabrica;
	
	public Produtor(Fabrica fabrica) {
		this.fabrica = fabrica;
	}
	
	public void produzir() {
		fabrica.somarContador();
	}
}
