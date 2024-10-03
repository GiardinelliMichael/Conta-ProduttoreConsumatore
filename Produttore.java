package conta;
import java.util.Random;

public class Produttore {
	
	private Buffer buffer;
    private Random random = new Random();

    public Produttore(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        while (true) {
            int numero = random.nextInt(1024);  // Genera un numero casuale tra 0 e 1023, ho inserito 1024 perchè va a generare 1024 numeri partendo dallo 0.
            buffer.Push(numero);  // Inserisce il numero nel buffer
            int delay = random.nextInt(901) + 100;  // Tempo di attesa casuale tra 100 e 1000 ms
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
            }
        }
    }

	public void start() {
		// TODO Auto-generated method stub
		
	}
}
