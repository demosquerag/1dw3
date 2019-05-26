package evaluacion3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RANDOMMASTERMINDCLASE {

	public static void main(String[] args) {
		
		// Genero un numero de 4 cifras diferentes
		ArrayList<Integer> numerocorrecto = new ArrayList<Integer>();
		Random rnd = new Random();
		String numero = "";
		// Defino un objeto de la clase escaner
		Scanner teclado;
		int cifra;
		int posicioncorrecta = 0;
		int cifrascorrectas = 0;
		int posicionescorrectas = 0;
		
		do {
			// Genero una cifra
			cifra = ((int)(rnd.nextDouble()*100000.0))%10;
			// Compruebo si esta en el arraylist
			if (!numerocorrecto.contains(cifra)) {
				// Si no esta en el arraylist la agrego
				numerocorrecto.add(cifra);
			}
			
		} while (numerocorrecto.size()<4);
		
		// Muestro el numero generado
		System.out.println("Numero generado: " + numerocorrecto);
		
		// Creo un objeto de la clase escaner
		teclado = new Scanner(System.in);
		
		// Pido numeros de cuatro cifras hasta que se acierte el numero
		do {
			// Pedir numero por teclado
			System.out.println("Introduce un numero:" );
			numero = teclado.nextLine();
			if (numero.length() == 4) {
				// Si el numero tiene cuatro cifras
				// Compruebo si hay alguna cifra en el numero correcto
				// Por cada cifra indico si coincide la posicion
				for(int posicion = 0; posicion<4; posicion++) {
					cifra = numero.charAt(posicion)-'0';
					System.out.println("Cifra: " + cifra);
					// Compruebo si hay alguna cifra en el numero correcto
					posicioncorrecta = numerocorrecto.indexOf(cifra); // devuelve la posocion o -1 no la encuentra
					
					if(posicioncorrecta != -1) {
						// Compruebo si coincide la posicion
						cifrascorrectas = cifrascorrectas+ 1;
						if (posicion == posicioncorrecta) {
							// Si la posicion esta en la misma posicion
							posicionescorrectas = posicionescorrectas+ 1;
						}
					}
					
				}
			
				// Salida de texto del numero acertado
				System.out.println("Cifras correctas: "+ cifrascorrectas + ", Cifras en la posicion correcta: " + posicionescorrectas);
			
			}
		
		} while (posicionescorrectas < 4);
		
		//cierro teclado
		teclado.close();
	}

}
