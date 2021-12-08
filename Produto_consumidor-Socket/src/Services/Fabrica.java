package Services;

public class Fabrica {
	//A fabrica tem a capacidade de produzir ou consumir atrav�s das a��es do cliente
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
