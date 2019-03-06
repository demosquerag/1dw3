package evaluacion3;

import java.util.Scanner;

public class TryCatch1 {

	public static void main(String[] args) {
		
		int n = 0;
		String valido = "";
		
		Scanner teclado = new Scanner(System.in);
		char [] array;
		
		System.out.println("Introduce un entero: ");
		valido = teclado.nextLine();
		n = Integer.parseInt(valido);
		array = valido.toCharArray();
		
		//System.out.println("Insertar dato: ");
		for (int p=0; p<valido.length();p++) {
			// Salida del array
			p = p + 1;			
			System.out.println(p);
		}

	}

}
