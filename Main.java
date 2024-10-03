package conta;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

        System.out.print("Inserisci il numero di thread (T): ");
        int T = scanner.nextInt();

        System.out.print("Inserisci il valore massimo (N): ");
        int N = scanner.nextInt();

        // Creo il bufer
        Buffer buffer = new Buffer(N);

        // Creo il produttoer
        Produttore produttore = new Produttore(buffer);
        produttore.start();

        // Creo il consumatore
        Consumatore consumatore = new Consumatore(buffer);
        consumatore.start();

        // Creo i T Thread
        Random random = new Random();
        for (int i = 0; i < T; i++) {
            int X = random.nextInt(N + 1);  // Genera un numero casuale tra 0 e N
            Contatore contatore = new Contatore(X);
            contatore.start();
        }

        scanner.close();
    }
	}

