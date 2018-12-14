package evaluacion1;

import java.util.Scanner;

public class XI_Notavali {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double nota;
		
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		
		// Pedimos el numero entero para elegir la funcion
		System.out.printf("Ingerese la nota del/la alumn@: ");
		nota = teclado.nextDouble();
		
		// Cerramos teclado
		teclado.close();
		
		if (nota >=0 && nota <=10) {
			System.out.print("La nota del/la alumn@ es valida.");
		}
		
		else {
			System.out.print("La nota del/la alumn@ no es valida.");
		}
	}

}
