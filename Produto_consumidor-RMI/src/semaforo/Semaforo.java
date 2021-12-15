package semaforo;

public class Semaforo {
	protected int count;

	public Semaforo()
    {
        count = 0;
    }
	
    public Semaforo(int i) {
    	count = i;
    }

    public synchronized void down() {
        while (count == 0)
            try {
                wait();
            } catch (InterruptedException _ex) {
            	_ex.printStackTrace();
            	//Thread.currentThread().interrupt();
            }
        count--;
    }

    public synchronized void up() {
    	count++;
        notify();
    }    
}
