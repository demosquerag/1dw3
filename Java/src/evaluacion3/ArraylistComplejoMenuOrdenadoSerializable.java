package evaluacion3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArraylistComplejoMenuOrdenadoSerializable {

	public static void main(String[] args) {
		
		// Necesidades previas
		Complejo valor = new Complejo();
		ArrayList<Complejo> alcomplejo = new ArrayList<Complejo>();
		// grabo los datos en complejos.dat
		FileOutputStream fos;
		ObjectOutputStream oos;
		FileInputStream fis;
		ObjectInputStream ois;
		int opcion;
		
		// CREAR OBJETO SCANNER
		Scanner teclado;
		teclado = new Scanner(System.in);
	    
		// OPCIONES A MOSTRAR EN PANTALLA
		System.out.println("<-- Opciones -->");
		System.out.println("1. Añadir número.");
		System.out.println("2. Buscar número.");
		System.out.println("3. Borrar número.");
		System.out.println("4. Listar numeración.");
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
					System.out.println("AÑADIR NÚMERO: ");
					valor.leer(teclado);
					try {
						fos = new FileOutputStream("alcomplejos.dat");
						oos = new ObjectOutputStream (fos);
						if (!alcomplejo.contains(valor)) {
							// AÑADIR LA CADENA AL ARRAYLIST
							alcomplejo.add(new Complejo(valor));
							// lo grabo
							oos.writeObject(valor);
							oos.flush();
							// cierro el fichero
							oos.close();
							fos.close();
							// Salida por consola
							System.out.println("El número ( "+ valor + " ) se ha añadido.");
						}
						else {
							System.out.println("Ese número ya existe.");
						}
					}
					catch (FileNotFoundException fnfe) {
						fnfe.printStackTrace();
					}
					catch (IOException ioe) {
						ioe.printStackTrace();
					}
					
					break;
				}
			
				case 2: {  // ...
					// LIMPIAR BUFFER
					teclado.nextInt();
					// LEER CADENA
					System.out.println("BURCAR NÚMERO: ");
					valor.leer(teclado);
					
					if (alcomplejo.contains(valor)) {
						// AÑADIR LA CADENA AL ARRAYLIST
						System.out.println("El número que has buscado es: " + valor);
					}
					else {
						System.out.println("Ese número ( " + valor + " ) no existe.");
					}	
					break;
				}

				case 3: {  // ...
					// LIMPIAR BUFFER
					teclado.nextInt();
					// LEER CADENA
					System.out.println("BORRAR NÚMERO: ");
					valor.leer(teclado);
					
					if (alcomplejo.contains(valor)) {
						System.out.println("El número ( " + valor + " ) ha sido borrado.");
						// BORRAR LA PALABRA BUSACADA
						alcomplejo.remove(valor);
					}
					else {
						System.out.println("Ese numero ( " + valor + " ) no existe.");
					}
				
					break;
				}

				case 4: {  
					// ...
					// Para ordenar un ArrayList de menor a mayor podemos usar el método sort
					// de la clase Collections.
					Collections.sort(alcomplejo);
					
					try {
						fis = new FileInputStream("alcomplejos.dat");
						ois = new ObjectInputStream(fis);
						// SALIDA DEL DICCIONARIO ORDENADO
						for (int posicion=0; posicion < alcomplejo.size(); posicion++) {
							System.out.println(alcomplejo.get(posicion));
						}
						while(fis.available() > 0){
							// Convierte los bytes leídos en un objeto de la clase Complejo
							valor = (Complejo) ois.readObject();
							// Salida por consola
							System.out.println("Valor leido: " + valor);
						}
						ois.close();
						fis.close();
					}
					catch (FileNotFoundException fnfe) {
						fnfe.printStackTrace();
					}
					catch (IOException ioe) {
						ioe.printStackTrace();
					}
					catch (ClassNotFoundException cnfe) {
						cnfe.printStackTrace();
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
