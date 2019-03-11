package evaluacion3;

import java.util.Random;
import java.util.Scanner;

public class RANDOMNUMEROSECRETO {

	public static void main(String[] args) {
		
		// Necesidades previas
		Scanner teclado = new Scanner(System.in);
		Random rnd = new Random();
		int numero = 0;
		int pedir = 0;
		
		// Generar numero aleatoriamente y sacar texto por consola
		numero = ((int)(rnd.nextDouble()*100000.0))%10 + 1;
		
		
		while (pedir != numero) {
			System.out.println("Inserta un numero: ");
			pedir = teclado.nextInt();
			
			if (pedir == numero) {
				System.out.println("Has acertado, tu numero es: "+ pedir + " y el numero secreto es: "+ numero);
				teclado.close();
				break;
			} else {
				System.out.println("Has fallado.");
			}
			
		}

	}

}
