package evaluacion1;

import java.util.Scanner;

public class II_ParImpar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Iniciamos la variable del número entero
		int num;
				
		// Pedimos el numero real
		System.out.println("Inserta un numero: ");
		
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		num = teclado.nextInt();
		
		// Hacemos la comprobación con un IF(Si...)
		// Para ello comprobamos i el número es divisible entre 2 (%2)
		if (num %2 == 0) {
			// Sacamos resultado
			System.out.println("El número que has introducido es PAR.");
		}
		
		// Si no cumple la condición ELSE(...)
		else {
			// Sacamos resultado
			System.out.println("El número que has introducido es IMPAR.");
		}
		
		// Cerramos teclado
		teclado.close();

	}

}
