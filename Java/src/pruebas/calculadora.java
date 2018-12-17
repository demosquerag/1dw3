package pruebas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class calculadora {

	public static void main (String []args) {
		
		float op1 = 0, op2 = 0;
		double res = 0;
		String operacion="";
		
		calculadora calc = new calculadora();
			
		try{
			
			//Definicion de bufer de entrada
			BufferedReader bufferRead = new BufferedReader(new InputStreamReader(System.in));
			
			//primer operando
	        System.out.println("Inserta el primer operando por teclado");
	        op1 = Float.parseFloat(bufferRead.readLine());
	        
	        //segundo operando
	        System.out.println("Inserta el segundo operando por teclado");
	        op2 = Float.parseFloat(bufferRead.readLine());
	        
	        //operacion
	        System.out.println("Inserta la operacion (+, -, /, *) por teclado");
	        operacion = bufferRead.readLine();

	    }
	    catch(IOException e)
	    {
	        e.printStackTrace();
	    }
		
		//hacemos la operacion correspondiente
		switch(operacion) {
		case "+":
			res = calc.suma (op1, op2);
			break;
		case "-":
			res = calc.resta(op1, op2);
			break;
		case "/":
			res = calc.division(op1, op2);
			break;
		case "*":
			res = calc.multiplicacion(op1, op2);
			break;
			default:
		}
		
		System.out.println("El resultado es: " + res);
		
		
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
