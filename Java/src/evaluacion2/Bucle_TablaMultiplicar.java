package evaluacion2;

import java.util.Scanner;

public class Bucle_TablaMultiplicar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Necesidades previas
		int num;
		
		// Crear variable
		Scanner teclado = new Scanner(System.in);
		
		
		
		do {
		System.out.print("Introduce número (de 0 a 10): ");
		num=teclado.nextInt();
		
		// Cerrar teclado
		teclado.close();
		}
		
		// Mientras que sea diferente de...
		while ( ! (0<=num && num<=10));
		System.out.println("\n\nTabla del " + num);
		
		// Sacar la tabla por pantalla
		for (int i=1;i<=10;i++) {
		System.out.println(num + " x " + i + " = " + num*i);
		}
	
	}

}
