package evaluacion2;

import java.util.ArrayList;
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
					break;
				}
			
			}
	    
		// BORAR MEMORIA DEL TECLADO
		teclado.close();
			
	}

	}
}
