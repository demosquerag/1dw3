package evaluacion2;

import java.util.Scanner;

public class Bucle_SumaNum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Pedir números hasta que se teclee un 0, 
		// mostrar la suma de todos los números introducidos.
		
		// Necesidades previas
		int num,suma;
		suma=0;
		
		// Crear variable
		Scanner teclado = new Scanner(System.in);
		
		do {
			// Leer número
			System.out.print("Introduzca un número: ");
			num=teclado.nextInt();
			suma=suma+num;
		}
		while(num!=0);
		
		// Cerrar teclado
		teclado.close();
		
		// Sacar texto o solución)
		System.out.println("La suma de todos los números es: "+suma);
	}

}
