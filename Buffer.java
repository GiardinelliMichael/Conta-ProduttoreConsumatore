package conta;

public class Buffer {

	private int[] buffer;
    private int size;
    private int count = 0;
    private int in = 0;
    private int out = 0;

    public Buffer(int size) {
        this.size = size;
        buffer = new int[size];
    }

    // Metodo per inserire un numero nel buffer
    public synchronized void Push(int value) {
        while (count == size) {
            try {
                wait();  // Attende finché c'è spazio nel buffer
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        buffer[in] = value;
        in = (in + 1) % size;
        count++;
        notifyAll();  // Notifica il consumatore che ci sono dati disponibili
    }

    // Metodo per ottenere un numero dal buffer
    public synchronized int Pop() {
        while (count == 0) {
            try {
                wait();  // Attende finché ci sono dati nel buffer
            } catch (InterruptedException e) {
            }
        }
        int value = buffer[out];
        out = (out + 1) % size;
        count--;
        notifyAll();  // Notifica il produttore che c'è spazio disponibile
        return value;
    }


// Per creare la variante LIFO vado a agire sul Buffer, precisamente sul metodo POP

/*
	public synchronized int get() {
        while (count == 0) {
            try {
                wait();  // Attende finché ci sono dati nel buffer
            } catch (InterruptedException e) {
            }
        }
        in = (in - 1 + size) % size;  // Prende l'ultimo numero inserito (logica LIFO)
        int value = buffer[in];
        count--;
        notifyAll();  // Notifica il produttore che c'è spazio disponibile
        return value;
    }
*/
//Variante numeri primi 

/*
    
	private boolean NumeroPrimo(int number) { //Questo medoto lo uso per controllare che ci siano numeri primi
        if (number <= 1) return false;
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
	
	 public synchronized int POP() {
        while (count == 0) {
            try {
                wait();  // Attende finché ci sono dati nel buffer
            } catch (InterruptedException e) {
            }
        }

        int primeIndex = -1;
        for (int i = 0; i < count; i++) {
            int indice = (out + i) % size;
            if (NumeroPrimo(buffer[indice])) {
                primeIndex = indice;
                break;
            }
        }

        // Se trovo un numero primo, lo consumiamo per primo
        if (primeIndex != -1) {
            out = primeIndex;
        }

        int value = buffer[out];
        out = (out + 1) % size;
        count--;
        notifyAll();  
        return value;
    }
*/
}