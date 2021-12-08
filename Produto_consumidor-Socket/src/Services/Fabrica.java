package Services;

public class Fabrica {
	private int contador;
	
	private Fabrica() {
		this.contador = 0;
	}
	
	public void subtrairContador() {
		this.contador--;
	}

	public void somarContador() {
		this.contador++;
	}
}
