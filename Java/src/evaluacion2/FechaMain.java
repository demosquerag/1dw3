package evaluacion2;

import java.util.Scanner;

public class FechaMain {

	public static void main(String[] args) {
		// Clase para probar la clase Fecha
		Fecha f1 = new Fecha(); // Llamada al constructor Racional por defecto
		System.out.println(f1);
		
		// Clase copia la clase Fecha
		Fecha f2 = new Fecha(10,11,1999); // Llamada al constructor Racional por defecto
		System.out.println(f2);
		
		// Clase copia la clase Fecha
		Fecha f3 = new Fecha(f2); // Llamada al constructor Racional por defecto
		System.out.println(f3);
		
		// Getter and Setter
		f1.setDia(10);
		f1.setMes(11);
		f1.setAño(1999);
		System.out.println(f1);
		
		
		// hascode and equals
		if(f3.equals(f2)) {
			System.out.println(f3 + " y " + f2 + " son iguales." );
		}
		else {
			System.out.println(f3 + " y " + f2 + " son diferentes." );
		}
		
		// compareTo
		if (f3.compareTo(f2) > 0) {
			System.out.println(f3 + " es MAYOR que "+ f2);
		}
		else if (f3.compareTo(f2) < 0) {
			System.out.println(f3 + " es MENOR que "+ f2);
		}
		else {
			System.out.println(f3 + " es IGUAL que "+ f2);
		}		
		
		// leer
		Scanner teclado = new Scanner (System.in);
		// leer f1
		f1.leerf(teclado);
		System.out.println("Fecha es: " + f1);
		// cerrar teclado
		teclado.close();	
		
	}

}
