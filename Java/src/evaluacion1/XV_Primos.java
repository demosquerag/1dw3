package evaluacion1;

import java.util.Scanner;

public class XV_Primos {

	public static void main(String[] args) {
		// Necesidades previas
		Scanner teclado = new Scanner(System.in);
		int num = 0, num2 = 0;
		
		// Pedir numero por teclado
		System.out.println("Ingresa un numero: ");
		num = teclado.nextInt();
		
		// Resto al numero divisible un numero
		num2 = num - 1;
		
		while ((num % num2) != 0) {
			num2--;
		}
		
		if (num2 == 1) {
			System.out.println("Es primo");
		} else {
			System.out.println("No es primo");
		}

		// Cierro el teclado
		teclado.close();
	}

}
