package evaluacion3;

public class MyClass12 {

	public static void main(String[] args) {
		
		/**
		 * Un bucle permite ejecutar rapidamente una declaracion o grupo de declaraciones
		 * 
		 * Un bucle WHILE ejecuta rapidamente una declaracion
		 * siempre que una condicion dad sea verdadera 
		 */
		
		int x = 3;
		while (x > 0) {
			System.out.println(x);
			x--;
		}
		System.out.println("----------");
		
		// Salida de texto:
		/**
		 * 3
		 * 2
		 * 1
		 * ----------
		 */
		
		int y = 6;
		while (y < 10) {
			System.out.println(y);
			y++;
		}
		System.out.println("Bucle terminado");
		
		// Salida de texto:
		/**
		 * 6
		 * 7
		 * 8
		 * 9
		 * Bucle terminado
		 */

	}

}
