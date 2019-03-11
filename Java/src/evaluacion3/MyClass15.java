package evaluacion3;

public class MyClass15 {

	public static void main(String[] args) {
		
		/**
		 * Array
		 * 
		 * Es una coleccion de variables del mismo tipo.
		 * 
		 * Array simple:
		 * 
		 * int [] array;
		 */
		int [] arra = new int[5];
		arra[2] = 88;
		
		/**
		 * Array de Strings
		 */
		String[] nombres = {"A", "B", "C", "D"};
		System.out.println(nombres[2]);
		
		/**
		 * Longitud de un array
		 */
		int [] intArr = new int [5];
		System.out.println(intArr.length);
		// Salida de texto: 5
		
		/**
		 * Suma del array con un bucle FOR
		 * 
		 * Se puede usar la logitud del array para determinar
		 * cuantas veces ejecutamos el bucle.
		 * 
		 */
		int [] myArr = {6, 42, 3, 7};
		int sum = 0;
		for (int x = 0; x < myArr.length; x++) {
			System.out.println(sum);
		}
		// Salida de texto: 58
		
		/**
		 * Nota:
		 * 
		 * La condicion bucle FOR es 
		 * x < myArr.length
		 * ya que el indice del ultimo elemento es myArr.length-1
		 * 
		 */
		
		/**
		 * Bucle FOR mejorado
		 * 
		 * Declara una variable de un tipo compatible.
		 * Las ventajas son que elimina la posibilidad de errores en el codigo y
		 * lo hace mas sencillo de leer.
		 */
		int [] primes = {2,3,5,7};
		for (int t: primes) {
			System.out.println(t);
		}
		// Salida de texto:
		/**
		 * 2
		 * 3
		 * 4
		 * 5
		 * 7
		 */
		
		/**
		 * Array multidimensional
		 * 
		 * Son array que contienen otros arrays
		 * 
		 * int [][] ejemplo = { {1, 2, 3}, {4, 5, 6} };
		 */
		int [][] sample = { {1, 2, 3}, {4, 5, 6} };
		int ejem = sample [1][0];
		System.out.println(ejem);
		// Salida de texto: 4

	}

}
