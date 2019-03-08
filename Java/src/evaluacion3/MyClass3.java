package evaluacion3;

public class MyClass3 {

	public static void main(String[] args) {
		
		/**
		 * Incremento  o decremento
		 * 
		 * Una manera de aumentar o disminuir el valor de una variable
		 */
		
		// Incremento
		int test1 = 3;
		// Ahora es 4
		++test1;
		
		// Decremento
		int test2 = 3;
		// Ahora en 2
		--test2;
		
		/**
		 * Prefijo y Sufijo
		 * 
		 * Pueden ser utilizadas con ambos operadores de incremento o decremento
		 */
		
		/**
		 * Prefijo
		 * 
		 * Incrementa el valor de la variable y utiliza el nuevo valor
		 */
		int x1 = 34;
		// Ahora es 35
		int y1 = ++x1;
		
		/**
		 * Sufijo
		 * 
		 * El valor de la variable es primero utilizado en la expresion y luego es incrementado
		 */
		int x2 = 34;
		// Ahora es 34
		int y2 = x2++;

	}

}
