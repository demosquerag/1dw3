package evaluacion1;

import java.util.Scanner;

public class VIII_Tabnotas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double nota;
		
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		
		// Pedimos el numero real A
		System.out.println("Introduce la calificación del alumno: ");
		nota = teclado.nextDouble();
		
		// Cerramos teclado
		teclado.close();
		
		// Empezamos con las condiciones
		if ( nota >=0 && nota <3) {
			System.out.print("MD");
		}
				
		else if(nota >=3 && nota <5) {
			System.out.print("INS");
		}
				
		else if (nota >=5 && nota <6) {
			System.out.print("SUF");
		}
		
		else if (nota >=6 && nota <7) {
			System.out.print("BIEN");
		}
		
		else if (nota >=7 && nota <9){
			System.out.print("NOT");
		}
		
		else if (nota >=9 && nota <=10) {
			System.out.print("SOBRE");
		}
		
		else {
			System.out.print("Error. Te has equivocado de valor, solo admite de 0 a 10.");
		}
		
	}

}
