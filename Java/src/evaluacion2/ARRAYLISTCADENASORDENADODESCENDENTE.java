package evaluacion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class ARRAYLISTCADENASORDENADODESCENDENTE {

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
		
		// Para ordenar de mayor a menor un ArrayList de nombre arrayListString escribimos
		Comparator<String> comparador = Collections.reverseOrder();
		Collections.sort(arrayListString, comparador);
		
		// SALIDA DEL DICCIONARIO ORDENADO
		for (int posicion=0; posicion < arrayListString.size(); posicion++) {
			System.out.println(arrayListString.get(posicion));
		}
			
	}

}
