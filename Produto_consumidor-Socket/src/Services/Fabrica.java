package Services;

public class Fabrica {
	//A fabrica tem a capacidade de produzir ou consumir através das ações do cliente
	private int contador;
	private Semaforo mutex;
	private Semaforo items;
	private static Fabrica instancia;
	
	private Fabrica() {
		this.contador = 0;
		this.mutex = new Semaforo(1);
		this.items = new Semaforo(0);
	}
	
	public static Fabrica getInstance() {
		if(instancia == null) 
			instancia = new Fabrica();
		return instancia;
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
	
	public void produzir() {
		Produtor produtor = new Produtor(getInstance());
		produtor.produzir();
	}

	public void consumir() {
		Consumidor consumidor = new Consumidor(getInstance());
		consumidor.consumir();
	}
}
