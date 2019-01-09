package evaluacion2;

import java.util.Scanner;

public class PersonaMain {

	public static void main(String[] args) {
		// Clase para probar la clase Fecha
		Persona p1 = new Persona(); // Llamada al constructor Racional por defecto
		System.out.println(p1);
		
		Persona p2 = new Persona("00000000A","Acacia","Abad", new Fecha()); // Llamada al constructor Racional por defecto
		System.out.println(p2);
		
		Persona p3 = new Persona(); // Llamada al constructor Racional por defecto
		System.out.println(p2);
		
		// Getters and Setters
		p2.setDni("00000001A");
		p2.setApellido("Anteiku");
		p3.setNombre("Alicia");
		Fecha f1 = new Fecha(1,1,1);
		p3.setFechanacimiento(f1);
		f1.setAño(2);
		System.out.println("Modificado --> " + p2);
		System.out.println("Modificado --> " + p3);
		System.out.println("Modificado --> " + f1);

		// hashCode adn equals
		if(p3.equals(p2)) {
			System.out.println(p3 + " y " + p2 + " son iguales." );
		}
		else {
			System.out.println(p3 + " y " + p2 + " son diferentes." );
		}
		
		// compareTo
		if (p3.compareTo(p2) == 1) {
			System.out.println(p3 + " es IGUAL que "+ p2);
		}
		else {
			System.out.println(p3 + " es DIFERENTE que "+ p2);
		}
		
		// leer
		Scanner teclado = new Scanner (System.in);
		// leer f1
		p1.leer(teclado);
		System.out.println("Persona: " + p1);
		// cerrar teclado
		teclado.close();
		
	}

}
