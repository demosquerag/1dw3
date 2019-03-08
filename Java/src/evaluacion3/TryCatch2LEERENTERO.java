package evaluacion3;

import java.util.Scanner;

public class TryCatch2LEERENTERO {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner (System.in);
		System.out.println("Introduce entero: ");
		int n = teclado.nextInt();
		teclado.close();
		System.out.println(n);

	}

}
