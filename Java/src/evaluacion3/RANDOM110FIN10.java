package evaluacion3;

import java.util.Random;

public class RANDOM110FIN10 {

	public static void main(String[] args) {
		
		// Necesidades previas
		Random rnd = new Random();
		int numero = 0;
		
		// Repetitiva mientras numero no sea 10
		while (numero !=  10) {
			
			// Generar numero aleatoriamente y sacar texto por consola
			numero = ((int)(rnd.nextDouble()*100000.0))%10 + 1;
			System.out.println("Numero generado: "+numero);
			
			// Para cuando numero es igual a 10
			if (numero == 10) {
				break;
			}
			
		}

	}

}
