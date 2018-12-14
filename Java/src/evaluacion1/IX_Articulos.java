package evaluacion1;

import java.util.Scanner;

public class IX_Articulos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double articulo, resultado;
		
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		
		// Pedimos el numero real A
		System.out.println("Introduce el precio del articulo: ");
		articulo = teclado.nextDouble();
		
		// Cerramos teclado
		teclado.close();
		
		// Empezamos con las condiciones
		if ( articulo >100) {
			resultado = articulo * 40 / 100;
			
			System.out.println("Tu precio total de "+ articulo +"€ con un descuento de 40% se resta "+ resultado +"€");
		}
				
		else if(articulo >25 && articulo <=100) {
			resultado = articulo * 20 / 100;
			
			System.out.println("Tu precio total de "+ articulo +"€ con un descuento de 20% se resta "+ resultado +"€" );
		}
				
		else if (articulo >10 && articulo <=25) {
			resultado = articulo * 10 / 100;
			
			System.out.println("Tu precio total de "+ articulo +"€ con un descuento de 10% se resta "+ resultado +"€");
		}
		
		else if (articulo <=10) {
			resultado = articulo;
			
			System.out.println("Tu precio total de "+ articulo +"€ con un descuento de 0%, con un total de "+ resultado +"€");
		}
		
	}

}
