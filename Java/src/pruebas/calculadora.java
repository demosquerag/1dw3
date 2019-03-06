package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class calculadora {

	public static void main (String []args) {
		
		float operando1 = 0, operando2 = 0;
		double resultado = 0;
		String operacion="";
		
		calculadora calc = new calculadora();
			
		try{
			
			//Definicion de bufer de entrada
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			
			//primer operando
	        operando1 = calc.perdiNumero();
	        
	        //operacion
	        System.out.println("Inserta la operacion (+, -, /, *) por teclado");
	        operacion = bufferRead.readLine();
	        
	        //segundo operando
	        operando2 = calc.perdiNumDivision(operacion);

	    }
		
	    catch(IOException e)
	    {
	        e.printStackTrace();
	    }
		
		//hacemos la operacion correspondiente
		switch(operacion) {
		case "+":
			resultado = calc.suma (operando1, operando2);
			break;
		case "-":
			resultado = calc.resta(operando1, operando2);
			break;
		case "/":
			resultado = calc.division(operando1, operando2);
			break;
		case "*":
			resultado = calc.multiplicacion(operando1, operando2);
			break;
			default:
		}
		
		System.out.println("El resultado es: " + resultado);
		
		
	}

	private float perdiNumero() {
		float num;
		Scanner teclado = new Scanner (System.in);
		System.out.println("Inserta op1: ");
		num = teclado.nextFloat();
		teclado.close();
		return num;
	}

	private float perdiNumDivision(String operacion) {
		float num;
		Scanner teclado = new Scanner (System.in);
		do {
			System.out.println("Inserta op2: ");
			num = teclado.nextFloat();
			teclado.close();
		}while (operacion.equals("/") && num==0) ;
			return num;
	}

	public double suma (float num1, float num2) {
		return num1 + num2;
	}
	
	public double resta (float num1, float num2) {
		return num1 - num2;
	}
	
	public double division (float num1, float num2) {
		return num1 / num2;
	}
	
	public double multiplicacion (float num1, float num2) {
		return num1 * num2;
	}
}
