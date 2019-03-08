package evaluacion3;

public class MyClass13 {

	public static void main(String[] args) {
		
		/**
		 * Bucle FOR
		 * 
		 * Permite escribir eficientemente un bucle
		 * que necesita ser ejecuado un numero especifico de veces
		 */
		
		/**
		 * Sintaxis:
		 * 	
		 * 	for (inicializacion; condicion; incremento o decremento) {}
		 */
		
		for (int x = 1; x<= 5; x++) {
			System.out.println(x);
		}
		// Salida de texto
		/**
		 * 1
		 * 2
		 * 3
		 * 4
		 * 5
		 */
		
		for (int x = 0; x <= 10; x = x + 2) {
			System.out.println(x);
		}
		// Salida de texto
		/**
		 * 0
		 * 2
		 * 4
		 * 6
		 * 8
		 * 10
		 */

	}

}
