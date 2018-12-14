package evaluacion2;

import java.util.Scanner;

public class Bucle_1aN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Necesidades previas
		int cont,num;
		
		// Crear variable
		Scanner teclado = new Scanner(System.in);
		
		// Leer número
		System.out.print("Introduce un número: ");
		num=teclado.nextInt();
		cont=1;
		
		// Cerrar teclado
		teclado.close();
		
		// i es el contador que tomará los valores de 1 a n
		while(cont<=num){
		System.out.println(cont);
		cont++;
		}
	
	}

}
