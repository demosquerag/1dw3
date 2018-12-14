package evaluacion2;

public class RacionalMain {

	public static void main(String[] args) {
		// Clase para probar la clase Racional
		Racional r1 = new Racional(); // Llamada al constructor Racional por defecto
		System.out.println(r1);
		Racional r2 = new Racional(1,2); // Llamada al constructor Racional con dos valores enteros
		System.out.println(r2);
		Racional r3 = new Racional(3); // Llamada al constructor Racional con un valor entero
		System.out.println(r3);
		Racional r4 = new Racional(r2); // Llamada al constructor Racional copiado de otro contructor
		System.out.println(r4);
		
		
	}

}
