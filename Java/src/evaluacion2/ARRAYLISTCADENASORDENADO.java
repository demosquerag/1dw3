package evaluacion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ARRAYLISTCADENASORDENADO {

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
		
		// Para ordenar un ArrayList de menor a mayor podemos usar el método sort
		// de la clase Collections.
		Collections.sort(arrayListString);
		
		// SALIDA DEL DICCIONARIO ORDENADO
		for (int posicion=0; posicion < arrayListString.size(); posicion++) {
			System.out.println(arrayListString.get(posicion));
		}
			
	}

}
