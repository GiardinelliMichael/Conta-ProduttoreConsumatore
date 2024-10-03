package conta;

public class Contatore extends Thread{
	
	  private int max;

	    public Contatore(int max) {
	        this.max = max;
	    }

	    public void run() {
	        for (int i = 0; i <= max; i++) {
	            System.out.println("Thread " + this.getId() + " conta: " + i);
	            try {
	                Thread.sleep(120);  // Pausa di 120 ms
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }
	    }
	    
}
