package evaluacion2;

import java.util.Scanner;

public class NUMVECES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, posicion;
		int [] arrayenteros = new int [10];
		
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		System.out.println("Introduce N: ");
		n = teclado.nextInt();
		
		while (n >=0 && n <= 9) {
			arrayenteros[n] = arrayenteros[n] + 1;
			
			if (n < 9) {
				System.out.println("Introduce N: ");
				n = teclado.nextInt();
			}
		}
		
		teclado.close();
		
		posicion = 0;
		
		while (posicion < 10) {
			
			System.out.println(+ posicion + ":" + arrayenteros[posicion] + " Veces");
			posicion = posicion + 1;
			
		}
	
	}
		

}


