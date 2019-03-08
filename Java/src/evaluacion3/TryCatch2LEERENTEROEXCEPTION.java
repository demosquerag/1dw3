package evaluacion3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch2LEERENTEROEXCEPTION {

	public static void main(String[] args) {
		
		// Necesidades previas
		Scanner teclado = new Scanner ( System.in);
		int n;
		
		try {
			System.out.println("Introduce entero: ");
			n = teclado.nextInt();
			teclado.close();
			System.out.println(n);
		} catch(InputMismatchException ime) {
			// Salida del error
			System.out.println("Error al leer entero.");
		}

	}

}
