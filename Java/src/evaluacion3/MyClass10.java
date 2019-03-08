package evaluacion3;

public class MyClass10 {

	public static void main(String[] args) {

		/**
		 * Operadores logicos
		 * 
		 */
		int age = 19;
		double money = 800;

		
		/**
		 * // Operador logico AND
		 * 
		 * Si las dos condiciones se cumplen
		 */
		if (age > 18 && money > 500) {
			System.out.println("Welcome!");
		}

		/**
		 * // Operador logico OR
		 * Si una de la condiciones se cumple
		 */
		if (age > 18 || money > 500) {
			System.out.println("Welcome!");
		}

		/**
		 * // Operador logico NOT
		 * 
		 * Si no se cumple la condicion
		 * Se lee como si la edad no es mayor que 18
		 */
		if (!(age > 18)) {
			System.out.println("Demasiado joven");
		} else {
			System.out.println("Welcome!");
		}

	}

}
