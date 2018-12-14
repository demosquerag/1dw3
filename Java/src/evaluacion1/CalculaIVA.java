package evaluacion1;

import java.util.Scanner;

public class CalculaIVA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// Iniciamos la variable del número entero
		double num;
		double resultado;
						
		// Pedimos el numero real
		System.out.println("Inserta un numero: ");
				
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		num = teclado.nextInt();
		
		// Cerramos teclado
		teclado.close();
		
		// Comprobamos si el número es menor que 20000, entre 10
		if (num < 20000) {
			resultado = (num * 10 / 100);
		}
		
		// En caso que no sea, entre 21
		else {
			resultado = (num * 21 / 100);
		}
		
		// Sacamos el resultado
		System.out.printf("\nEl IVA es %.2f€", resultado);
		

	}

}
