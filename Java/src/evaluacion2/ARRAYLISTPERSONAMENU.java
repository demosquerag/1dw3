package evaluacion2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ARRAYLISTPERSONAMENU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int opcion;
		
		Persona valor = new Persona();
		ArrayList<Persona> personamenu = new ArrayList<Persona>();
		
		// CREAR OBJETO SCANNER
		Scanner teclado;
		teclado = new Scanner(System.in);
	    
		// OPCIONES A MOSTRAR EN PANTALLA
		System.out.println("<-- Opciones -->");
		System.out.println("1. Añadir Persona.");
		System.out.println("2. Buscar Persona.");
		System.out.println("3. Borrar Persona.");
		System.out.println("4. Listar Personas.");
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
					System.out.println("Añadir Persona: ");
					valor.leer(teclado);
					
					if (!personamenu.contains(valor)) {
						// AÑADIR LA CADENA AL ARRAYLIST
						personamenu.add(valor);
						
						System.out.println("La persona ( "+valor+" ) se ha añadido.");
					}
					else {
						System.out.println("Esa persona ya existe.");
					}
					break;
				}
				
				case 2: {  // ...
					// LIMPIAR BUFFER
					teclado.nextLine();
					// LEER CADENA
					System.out.println("Buscar Persona: ");
					valor.leer(teclado);
					
					if (personamenu.contains(valor)) {
						// AÑADIR LA CADENA AL ARRAYLIST
						System.out.println("La persona que has buscado es: "+valor);
					}
					else {
						System.out.println("Esa persona ( "+valor+" ) no existe.");
					}	
					break;
				}
				
				case 3: {  // ...
					// LIMPIAR BUFFER
					teclado.nextLine();
					// LEER CADENA
					System.out.println("Borrar Persona: ");
					valor.leer(teclado);
					
					if (personamenu.contains(valor)) {
						System.out.println("La persona ( "+valor+ " ) ha sido borrada.");
						// BORRAR LA PALABRA BUSACADA
						personamenu.remove(valor);
					}
					else {
						System.out.println("Esa persona( "+valor+" ) no existe.");
					}	
					break;
				}
				
				case 4: {  // ...
					// Para ordenar un ArrayList de menor a mayor podemos usar el método sort
					// de la clase Collections.
					Collections.sort(personamenu);
						
					// SALIDA DEL DICCIONARIO ORDENADO
					for (int posicion=0; posicion < personamenu.size(); posicion++) {
						System.out.println(personamenu.get(posicion));
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
