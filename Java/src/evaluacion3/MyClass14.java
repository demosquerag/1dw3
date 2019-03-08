package evaluacion3;

public class MyClass14 {

	public static void main(String[] args) {
		
		/**
		 * Bucles DO...WHILE
		 * 
		 * Se garantiza que el bucle se ejecute una vez
		 */
		
		int x = 1;
		do {
			System.out.println(x);
			x++;
		} while (x < 5);
		// Salida de texto:
		/**
		 * 1
		 * 2
		 * 3
		 * 4
		 */
		
		do {
			System.out.println(x);
			x++;
		} while (x < 0);
		// Salida de texto:
		/**
		 * 1
		 */
		
		/**
		 *  Declaracion con un BREAK
		 *  
		 *  Finaliza la ejeccion del bucle y transfiere la ejecucion
		 *  a la declaracion que sigue inmediatamente
		 */
		int y = 1;
		while (y > 0) {
			System.out.println(y);
			if (y == 4) {
				break;
			}
			y++;
		}
		
		/**
		 * Declaracion con n CONTINUE
		 * 
		 * Omite el resto de sus declaraciones y evalue nuevamente
		 * su condicion antes de reiterar. Hace que el bucle salte a su proxima iteracion.
		 */
		
		for (int z = 10; z <= 40; z = z + 10) {
			if (z == 30) {
				continue;
			}
			System.out.println(z);
		}
		// Salida de texto:
		/**
		 * 10
		 * 20
		 * 40
		 */

	}

}
