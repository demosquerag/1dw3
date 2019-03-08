package evaluacion3;

public class MyClass7 {

	public static void main(String[] args) {
		
		/**
		 * Las declaraciones condicionaes son usadas para ejecutar acciones diferentes
		 * basadas en condiciones diferentes
		 */
		
		/**
		 * La declaracion IF
		 * 
		 * Menor que <
		 * Mayor que >
		 * No igual que !=
		 * igual que ==
		 * Menor o igual que <=
		 * Mayor o igual que >=
		 */
		
		/**
		 * Recordatorio:
		 * Se necesita los dos signos == para probar equidad
		 * ya que si se usa un solo = es signo de asignacion
		 */
		
		int x = 8;
		if (x < 42) {
			System.out.println("Hola");
		}
		
		/**
		 * Una declaracion IF puede venir seguida por una declaracion opcional ELSE
		 * la cual se ejecuta cuando la condicion se evalua como falsa
		 */
		
		int age = 30;
		if (age < 16) {
			System.out.println("Demasiado joven");
		} else {
			System.out.println("Wellcome!");
		}

	}

}
