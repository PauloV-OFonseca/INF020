package processos;

import semaforo.ProdutorConsumidorController;

public class Consumidor implements Runnable{
		
	private ProdutorConsumidorController handler;

	public Consumidor(ProdutorConsumidorController handler) {
		this.handler = handler;
	}
	
	@Override
	public void run() {
		this.handler.decreaseMutex();
		this.handler.decreaseItens();
		this.handler.decreaseCount();
				
		String msg = this.handler.getMessageFromBuffer(0);
		this.handler.removeMessageFromBuffer(0);
		this.handler.increaseMutex();
				
		System.out.println("Consumidor consumiu " + msg.substring(msg.lastIndexOf(":")));
	}
}