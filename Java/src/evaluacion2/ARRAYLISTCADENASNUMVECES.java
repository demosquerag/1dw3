package evaluacion2;

import java.util.ArrayList;
import java.util.Scanner;

public class ARRAYLISTCADENASNUMVECES {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n, valor;
		
		// CREO EL ARRAYLIST
		ArrayList<Integer> arrayListString = new ArrayList<Integer>();
		
		// INICIALIZO CON 10 ELEMENTOS
		for (int posicion=0; posicion < 10; posicion++) {
			arrayListString.add(0);
		}
		
		// CREAR OBJETO SCANNER
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		// LEER CADENA
		System.out.println("Introduce N: ");
		n = teclado.nextInt();
		
		
		while (n >=0 && n <=9) {
			// COJO EL VALOR DE N
			valor = arrayListString.get(n);
			// AÑADIR LA CADENA AL ARRAYLIST
			// arrayListString.add(n);
			// SUMO LA POSICION
			valor = valor + 1;
			// ACTUALIZO LA POSICION
			arrayListString.set(n, valor);
			if (n < 9) {
				// LEER CADENA
				System.out.println("Introduce N: ");
				n = teclado.nextInt();
			}
		}
		
		// BORAR MEMORIA DEL TECLADO
		teclado.close();
				
		// SALIDA DEL DICCIONARIO ORDENADO
		for (int posicion=0; posicion < arrayListString.size(); posicion++) {
			valor = arrayListString.get(posicion);
			System.out.println(posicion + ":" + valor + " Veces");
		}
			
	}

}
