package pruebas;

import java.util.Scanner;

public class DevolverNumero {

	public static void main (String []args) {
		
		// Necesidades previas
		double res = 0, op1 = 0;
		
		DevolverNumero devnum = new DevolverNumero();
		
		res = devnum.pedirnum(op1);
		
		System.out.println("El número que has introducido es: " + res);
		
	}

	private double pedirnum (double num1) {		
	    // Crear variable
	 	// Teclado por consola
	 	Scanner teclado = new Scanner(System.in);
	 	
	 	// Leer numero
	 	System.out.println("Inserta un número por teclado: ");
	 	num1 = teclado.nextDouble();
	 	
	 	// Cerrar teclado
	 	teclado.close();
		
	 	// Devolver numero
	 	return 0;
	}

}
