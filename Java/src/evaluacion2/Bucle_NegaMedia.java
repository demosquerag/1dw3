package evaluacion2;

import java.util.Scanner;

public class Bucle_NegaMedia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Necesidades previas
		int num, suma, elementos;
		float media; // la media puede tener decimales
		// num: guardará los números introducidos por el usuario
		// suma: almacenará la suma de todos los números introducidos
		// elementos: será un contador que indicará el números de números 8o elementos) introducidos.
		
		// Crear variable
		Scanner teclado = new Scanner(System.in);
		
		System.out.print("Introduzca un número: ");
		num=teclado.nextInt();
		
		// Inicializar variables
		suma= 0;
		elementos= 0;
		
		// Solo interesan los numeros positivos y el cero
		while(num>=0) {
			suma+=num;
			elementos++;
			System.out.print("Introduzca otro número: ");
			num=teclado.nextInt();
		}
		
		// Cerrar teclado
		teclado.close();
		
		// Dará un error de división por cero
		if (elementos == 0) {
			System.out.println("Imposible hacer la media.");
		}
		
		else {
		media= (float)suma/elementos;
		System.out.println("La media es de: " + media);
		}
		
	}

}
