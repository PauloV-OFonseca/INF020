package Services;

import java.util.ArrayList;

public class Fabrica {
	//A fabrica tem a capacidade de produzir ou consumir através das ações do cliente
	private int contador;
	private Semaforo mutex;
	private Semaforo items;
	private static Fabrica instancia;
	private ArrayList<String> mensagens;
	
	private Fabrica() {
		this.contador = 0;
		this.mutex = new Semaforo(1);
		this.items = new Semaforo(0);
		this.mensagens = new ArrayList<>();
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
	
    public void addMsg(String msg) {
        this.mensagens.add(msg);
    }
    
    public String getMsg(int index) {
        return this.mensagens.get(index);
    }
    
    public void delMsg(int index) {
    	this.mensagens.remove(index);
    }
	
    //Inicia o processo de produção
	public void produzir(String msg) {
		Produtor produtor = new Produtor(getInstance(), msg);
		produtor.produzir();
	}

	//Inicia o processo de consumir
	public void consumir() {
		Consumidor consumidor = new Consumidor(getInstance());
		consumidor.consumir();
	}
}
