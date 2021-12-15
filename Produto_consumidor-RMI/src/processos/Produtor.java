package processos;

import semaforo.ProdutorConsumidorController;

public class Produtor implements Runnable{
	
	private String text;
	private ProdutorConsumidorController handler;
	
	public Produtor(String msg, ProdutorConsumidorController handler) {
		this.text = msg;
		this.handler = handler;
	}
	
	public void setText(String msg) {
		this.text = msg;
	}
	
	@Override
	public void run(){
		this.handler.decreaseMutex();
		
		this.handler.increaseItens();		
		this.handler.increaseCount();
		this.handler.increaseMutex();
		
		this.handler.addMessageToBuffer(this.text);
		System.out.println("Produtor produziu" + this.text.substring(this.text.lastIndexOf(":")));
	}
}