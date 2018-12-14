package evaluacion1;

import java.util.Scanner;

public class III_NXN {

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
		
		num = Math.pow(num, 2);
		
		if (num > 100) {
			resultado = num - 100;
		}
		
		else {
			resultado = num + 100;
		}
		
		// Pedimos el numero real
		System.out.printf("Resultado es "+ resultado);
				
		// Cerramos teclado
		teclado.close();

	}

}
