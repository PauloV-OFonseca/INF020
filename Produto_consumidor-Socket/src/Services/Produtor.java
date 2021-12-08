package Services;

public class Produtor {
	private Fabrica fabrica;
	private String msg;
	
	public Produtor(Fabrica fabrica, String msg) {
		this.fabrica = fabrica;
		this.msg = msg;
	}
	
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public void produzir() {
		fabrica.addMsg(msg);
		fabrica.somarContador();
		fabrica.somarMutex();
		fabrica.somarItems();
		System.out.println("Algumas coisas foram produzidas");
	}
}
