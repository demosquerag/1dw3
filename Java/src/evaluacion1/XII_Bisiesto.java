package evaluacion1;

import java.util.Scanner;

public class XII_Bisiesto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int anio;
		
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		
		// Pedimos el numero real A
		System.out.println("Introduce el año que quieres comprobar: ");
		anio = teclado.nextInt();
		
		// Cerramos teclado
		teclado.close();
		
		// Cómo saber si un año es bisiesto o no, con esta linea de código
		if ((anio % 4 == 0) && ((anio % 100 != 0) || (anio % 400 == 0))){
			System.out.println("El año es bisiesto.");
		}
			
		else {
			System.out.println("El año no es bisiesto.");
		}
		
		/**
		// Java nos ofrece una forma todavía más sencilla de resolver si un año es bisiesto. 
		// Y es que nos proporciona la clase GregorianCalendar y en concreto el método .isLeapYear(anio).
		// Este método devolverá true o false, según corresponda.
		//
		//GregorianCalendar calendar = new GregorianCalendar();
		// 
		//if (calendar.isLeapYear(anio))
		//	System.out.println("El año es bisiesto");
		//else
		//	System.out.println("El año no es bisiesto");
		*/			
	}

}
