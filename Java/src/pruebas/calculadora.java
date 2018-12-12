package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class calculadora {

	public static void main (String []args) {
		
		double op1 = 0, op2 = 0, res = 0;
		
		calculadora calc = new calculadora();
		
		DevolverNumero devnum = new DevolverNumero();
			
		res = devnum.pedirnum(op1);
		
		System.out.println("El resultado es: " + res);
		
		
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
	 	return num1;
	}
	
	public double suma (float num1, float num2) {
		String operacion="";
		//hacemos la operacion correspondiente
		switch(operacion) {
			case "+":
				res = calc.suma (op1, op2);
				break;
			case "-":
				res = calc.resta (op1, op2);
				break;
			case "/":
				res = calc.division (op1, op2);
				break;
			case "*":
				res = calc.multiplicacion (op1, op2);
				break;
			default:
		
		}
		
		return num1 + num2;
	}
		
	
}
