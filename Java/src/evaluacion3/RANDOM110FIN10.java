package evaluacion3;

import java.util.Random;

public class RANDOM110FIN10 {

	public static void main(String[] args) {
		
		// Necesidades previas
		Random rnd = new Random();
		int numero = 0;
		
		do {
			// Generar numero aleatoriamente y sacar texto por consola
			numero = ((int)(rnd.nextDouble()*100000.0))%10 + 1;
			System.out.println("Numero generado: "+numero);
		}
		// Repetitiva mientras numero no sea 10
		while (numero !=  10);

	}

}
