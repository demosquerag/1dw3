package evaluacion2;

import java.util.ArrayList;
import java.util.Scanner;

public class ARRAYLISTCADENASFOREACH {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String cadena;
		ArrayList<String> arrayListString = new ArrayList<String>();
		
		// CREAR OBJETO SCANNER
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		// LEER CADENA
		System.out.println("Introduce PALABRA: ");
		cadena = teclado.nextLine();
		
		
		while (!cadena.isEmpty()) {
			// AÑADIR LA CADENA AL ARRAYLIST
			arrayListString.add(cadena);
			
			// LEER CADENA
			System.out.println("Introduce PALABRA: ");
			cadena = teclado.nextLine();
		}
		
		// BORAR MEMORIA DEL TECLADO
		teclado.close();
		
		// SALIDA DEL DICCIONARIO ORDENADO
		for (String valor : arrayListString) {
			System.out.println(valor);
		}
			
	}

}
