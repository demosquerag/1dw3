package evaluacion3;

public class MyClass9 {

	public static void main(String[] args) {
		
		/**
		 * Declaracion ELSE-IF
		 * 
		 * En lugar de utilizar declaraciones IF-ELSE anidadas
		 * puede utilizar la declaracion ELSE-IF para validar varias condiciones
		 */
		
		int age = 25;
		if (age <= 0) {
			System.out.println("Error");
		} else if (age <= 16) {
			System.out.println("Demasiado joven");
		} else if (age < 100) {
			System.out.println("Welcome!");
		} else {
			System.out.println("Enserio?");
		}
		
		// Salida de texto: Welcome!

	}

}
