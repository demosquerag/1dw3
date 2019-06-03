package pruebas;

import java.util.Scanner;

public class X1A1000 {

	public static void main(String[] args) {
		
		/**
		 * Sacar la suma de los primeros 10 numeros entre 1 y 1000
		 * que sean divisibles entre el numero introducido.
		 */
		
		// Necesidades previas
		Scanner teclado = new Scanner(System.in);
		int x = 0;
		int suma = 0;
		int intentos = 0;
		
		// Pedir numero
		System.out.println("Introduce un numero: ");
		x = teclado.nextInt();
		
		// Comprobar que el numero introducido esta comprendido entre 1 y 1000
		if (x < 1 || x >= 1000) {
			// Salida del numeor introducido 
			System.out.println(x);
			// Cerrar teclado
			teclado.close();
		} else {
			// Coger las posiciones o numero divisibles al numero introducido
			for (int pos = 1; pos < 1000; pos++) {
				if (intentos == 10 || suma >= 1000) {
					break;
				}
				if (x / pos == 0) {
					suma += pos;
					intentos++;
				}
				
			}
			
		}
		
		// Saco por pantalla el numero introducido
		System.out.println("La suma de los numeros divisibles de: "+x+" es :"+suma);
		
	}

}
