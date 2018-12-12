package evaluacion2;

import java.util.Scanner;

public class DICCIONARIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int posicion, elementos;
		
		String [] arraydiccionario = new String [10];
		String cadena = new String();
		
		// CREAR OBJETO SCANNER
		Scanner teclado;
		teclado = new Scanner(System.in);
		
		// LEER CADENA
		System.out.println("Introduce PALABRA: ");
		cadena = teclado.nextLine();
		
		// INICIAMOS LA VARIABLE
		elementos = 0;
		
		while (!cadena.isEmpty() && elementos < 10) {
			// BUSCAR LA POSICION
			posicion = 0;
			while(posicion < elementos) {
				// COMPRUEBO LA POSICION
				// COMPARAR ELEMENTOS DE TIPO STRING ALAFABETICAMENTE
				if (cadena.compareTo(arraydiccionario[posicion]) < 0) {
					// SI ES LA POSICION CORRECTA
					break;
				}
				
				// IR A LA SIGUIENTE POSICION
				posicion = posicion + 1;
			}
						
			// DESPLAZAR LOS ELEMENTOS DESDE LA POSICION UNA A LA DERECHA
			for (int posmov = elementos; posmov > posicion; posmov --) {
				arraydiccionario[posmov] = arraydiccionario[posmov - 1];
			}
			
			// INSERTAR LA CEDANA EN EL POSICION
			arraydiccionario[posicion] = cadena;
			
			// INCREMENTAR EL NUMERO DE ELEMENTOS
			elementos = elementos + 1;
			
			// LEER CADENA
			System.out.println("Introduce PALABRA: ");
			cadena = teclado.nextLine();
		}
		
		// BORAR MEMORIA DEL TECLADO
		teclado.close();
		
		// SALIDA DEL DICCIONARIO ORDENADO
		for (posicion = 0; posicion < elementos; posicion ++) {
			System.out.println(arraydiccionario[posicion]);
		}
			
	}

}
