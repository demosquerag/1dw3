package evaluacion1;

import java.util.Scanner;

public class I_Valorabs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Iniciamos la variable del numero real
		double num;
		
		// Pedimos el numero real
		System.out.println("Inserta un numero: ");
		
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		num = teclado.nextInt();
		
		// Sacamos por consola el número
		System.out.println("El número que has introducido es " +num);
		
		// Cerramos el teclado
		teclado.close();
		
	}

}
