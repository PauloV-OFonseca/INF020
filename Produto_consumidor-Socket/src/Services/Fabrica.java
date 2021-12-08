package Services;

public class Fabrica {
	//A fabrica tem a capacidade de produzir ou consumir através das ações do cliente
	private int contador;
	private Semaforo mutex;
	private Semaforo items;
	
	private Fabrica() {
		this.contador = 0;
		this.mutex = new Semaforo(1);
		this.items = new Semaforo(0);
	}
	
	public void subtrairContador() {
		this.contador--;
	}

	public void somarContador() {
		this.contador++;
	}
	
	public void subtrairMutex() {
		this.mutex.down();
	}

	public void somarMutex() {
		this.mutex.up();
	}

	public void subtrairItems() {
		this.items.down();
	}

	public void somarItems() {
		this.items.up();
	}
}
