package evaluacion1;

import java.util.Scanner;

public class IV_MayorMenor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Iniciamos la variable del número entero		
		double a, b;
		
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
						
		// Pedimos el numero real A
		System.out.println("Inserta el número A: ");
		a = teclado.nextInt();		
		
		// Cerramos teclado
		teclado.close();
			
		// Pedimos el numero real B
		System.out.println("Inserta el número B: ");
		b = teclado.nextInt();
		
		// Empezamos con las condiciones
		if (a == b) {
			System.out.println("A y B son iguales");
		}
		
		else if(a > b) {
			System.out.println("A es mayor que B");
		}
		
		else if (a < b) {
			System.out.println("A es menor que B");
		}

	}

}
