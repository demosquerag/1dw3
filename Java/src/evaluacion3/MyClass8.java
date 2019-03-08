package evaluacion3;

public class MyClass8 {

	public static void main(String[] args) {

		/**
		 * Declaraciones IF anidadas
		 * 
		 * Se puede usa una declaracion IF-ELSE dentro de otra delcaracion IF-ELSE
		 */

		int age = 25;
		if (age > 0) {
			if (age > 16) {
				System.out.println("Welcome!");
			} else {
				System.out.println("Demasiado joven");
			}
		} else {
			System.out.println("Error");
		}

		// Salida de texto: Welcome!

	}

}
