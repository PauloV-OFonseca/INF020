package semaforo;

import java.util.ArrayList;

import processos.Consumidor;
import processos.Produtor;

public class ProdutorConsumidorController {
	private int count;
	private Semaforo mutex;
	private Semaforo itens;
	private ArrayList<String> messageBuffer;
	private static ProdutorConsumidorController instance;
	
	private ProdutorConsumidorController() {
		this.count = 0;
		this.messageBuffer = new ArrayList<>();		
		this.itens = new Semaforo(0);
		this.mutex = new Semaforo(1);
	}
	
	public static ProdutorConsumidorController getInstance() {
		if(instance == null)
			instance = new ProdutorConsumidorController();
		return instance;
	}
	
	public void runProducer(String mensagem) {
		Produtor producer = new Produtor(mensagem, this);
		new Thread(producer).start();
	}

	public void runConsumer() {
		Consumidor consumer = new Consumidor(this);
		new Thread(consumer).start();
	} 
	
	public void increaseCount() {
		this.count++;
	}
	public void decreaseCount() {
		this.count--;
	}
	
	public void increaseMutex() {
		this.mutex.up();
	}
	public void decreaseMutex() {
		this.mutex.down();
	}
	
	public void increaseItens() {
		this.itens.up();
	}
	public void decreaseItens() {
		this.itens.down();
	}
	
	public void addMessageToBuffer(String msg) {
        this.messageBuffer.add(msg);
    }
    public void removeMessageFromBuffer(int index) {
    	this.messageBuffer.remove(index);
    }
    public String getMessageFromBuffer(int index) {
        return this.messageBuffer.get(index);
    }
}
