package conta;

public class Consumatore {
	
	 private Buffer buffer;
	    private int pariCount = 0;
	    private int dispariCount = 0;

	    public Consumatore(Buffer buffer) {
	        this.buffer = buffer;
	    }

	    public void run() {
	        while (true) {
	            int numero = buffer.Pop();  // Preleva il numero dal buffer
	            System.out.println("Consumato: " + numero);
	            if (numero % 2 == 0) {
	                pariCount++;
	            } else {
	                dispariCount++;
	            }
	            System.out.println("Numeri pari: " + pariCount + ", Numeri dispari: " + dispariCount);
	        }
	    }

		public void start() {
			// TODO Auto-generated method stub
			
		}
}
