package evaluacion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ARRAYLISTDICCIONARIO {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion;
		
		String palabra;
		ArrayList<String> arrayListString = new ArrayList<String>();
		
		// CREAR OBJETO SCANNER
		Scanner teclado;
		teclado = new Scanner(System.in);
	    
		// OPCIONES A MOSTRAR EN PANTALLA
		System.out.println("<-- Opciones -->");
		System.out.println("1. Añadir palabra.");
		System.out.println("2. Buscar palabra.");
		System.out.println("3. Borrar palabra.");
		System.out.println("4. Listar Diccionario.");
		System.out.println("5. Salir.");
		
		// LEER OPCION
		System.out.println("Opcion --> ");
	    opcion = teclado.nextInt();
	    
	    while (opcion != 0) {
		    	
			switch(opcion) {  // En caso de...
				
				case 1: {  // ...
					// LIMPIAR BUFFER
					teclado.nextLine();
					// LEER CADENA
					System.out.println("AÑADIR PALABRA: ");
					palabra = teclado.next();
					
					if (!arrayListString.contains(palabra)) {
						// AÑADIR LA CADENA AL ARRAYLIST
						arrayListString.add(palabra);
						
						System.out.println("La palabra ( "+palabra+" ) se ha añadido.");
					}
					else {
						System.out.println("Esa palabra ya existe.");
					}
					
					break;
				}
			
				case 2: {  // ...
					// LIMPIAR BUFFER
					teclado.nextLine();
					// LEER CADENA
					System.out.println("BURCAR PALABRA: ");
					palabra = teclado.next();
					
					if (arrayListString.contains(palabra)) {
						// AÑADIR LA CADENA AL ARRAYLIST
						System.out.println("La palabra que has buscado es: "+palabra);
					}
					else {
						System.out.println("Esa palabra ( "+palabra+" ) no existe.");
					}	
					break;
				}

				case 3: {  // ...
					// LIMPIAR BUFFER
					teclado.nextLine();
					// LEER CADENA
					System.out.println("BORRAR PALABRA: ");
					palabra = teclado.nextLine();
					
					if (arrayListString.contains(palabra)) {
						System.out.println("La palabra ( "+palabra + " ) ha sido borrada.");
						// BORRAR LA PALABRA BUSACADA
						arrayListString.remove(palabra);
					}
					else {
						System.out.println("Esa palabra ( "+palabra+" ) no existe.");
					}
				
					break;
				}

				case 4: {  // ...
					// Para ordenar un ArrayList de menor a mayor podemos usar el método sort
					// de la clase Collections.
					Collections.sort(arrayListString);
						
					// SALIDA DEL DICCIONARIO ORDENADO
					for (int posicion=0; posicion < arrayListString.size(); posicion++) {
						System.out.println(arrayListString.get(posicion));
					}
						
					break;
				}
				
				case 5: {  // ...
					// Salir del programa
					System.exit(0);
					break;
				}
			
			}
			
			// LEER OPCION
			System.out.println("Opcion --> ");
		    opcion = teclado.nextInt();
	    }
	    
		// BORAR MEMORIA DEL TECLADO
		teclado.close();
			
	}

}
