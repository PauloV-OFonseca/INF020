package Services;

public class Semaforo {
	protected int contador;
	
    public Semaforo() {
        contador = 0;
    }

    public Semaforo(int i) {
        contador = i;
    }

    public synchronized void down() {
        while (contador == 0)
            try {
                wait();
            } catch (InterruptedException _ex) {
            }
        contador--;
    }

    public synchronized void up() {
        contador++;
        notify();
    }

}
