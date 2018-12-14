package evaluacion1;

import java.util.Scanner;

public class X_Menuif {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int tipo;
		double num1, num2, resultado = 0;
		
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		
		// Pedimos el numero entero para elegir la funcion
		System.out.println("Elige entre las siguientes funciones");
		System.out.println("1.Suma");
		System.out.println("2.Resta");
		System.out.println("3.Multiplicar");
		System.out.println("4.Dividir");
		System.out.println("5.Resto (%)");
		System.out.println("0.Salir");
		tipo = teclado.nextInt();
		
		if (tipo == 1) {
			System.out.println("Introduzca x: ");
			num1 = teclado.nextInt();
			
			System.out.println("Introduzca y: ");
			num2 = teclado.nextInt();
			
			resultado = num1 + num2;
		}
		
		else if (tipo == 2) {
			System.out.println("Introduzca x: ");
			num1 = teclado.nextInt();
			
			System.out.println("Introduzca y: ");
			num2 = teclado.nextInt();
			
			resultado = num1 - num2;
		}
		
		else if (tipo == 3) {
			System.out.println("Introduzca x: ");
			num1 = teclado.nextInt();
			
			System.out.println("Introduzca y: ");
			num2 = teclado.nextInt();
			
			resultado = num1 * num2;
		}
		
		else if (tipo == 4) {
			System.out.println("Introduzca x: ");
			num1 = teclado.nextInt();
			
			System.out.println("Introduzca y: ");
			num2 = teclado.nextInt();
			
			resultado = num1 / num2;
		}
		
		else if (tipo == 5) {
			System.out.println("Introduzca x: ");
			num1 = teclado.nextInt();
			
			System.out.println("Introduzca y: ");
			num2 = teclado.nextInt();
			
			resultado = num1 * num2 / 100;
			
		}
		
		else if (tipo == 0) {
			System.out.println("Exit");
			System.exit(0);
		}
		
		else {
			System.out.println("Error. No ha elegido ninguna opción");
			System.exit(0);
		}
		
		// Cerramos teclado
		teclado.close();
		
		System.out.println("Su calculo es: "+ resultado);
		
	}

}
