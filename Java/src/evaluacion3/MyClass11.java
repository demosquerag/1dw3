package evaluacion3;

public class MyClass11 {

	public static void main(String[] args) {
		
		/**
		 * La declaracion switch
		 * 
		 * Valida una variable por igualdad contra una lsita de valores.
		 * Cada valor es llamado CASE, y la variable que esta siendo
		 * evaluada es comparada contra cada CASE.
		 */
		
		int day = 3;
		
		switch (day) {
		
		case 1:
			System.out.println("Lunes");
			break;
		case 2:
			System.out.println("Martes");
			break;
		case 3:
			System.out.println("Miercoles");
			break;
		}
		
		// Salida de texto: Miercoles
		
		/**
		 * Una declaracion switch puede tener un case DEFAULT opcional.
		 * 
		 * La declaracion DEFAULT puede ser utilizada para realizar una actividad
		 * cuando ninguno de los cases es igualado
		 */
		
		int day1 = 3;
		
		switch (day1) {
		
		case 4:
			System.out.println("Sabado");
			break;
		case 5:
			System.out.println("Domindo");
			break;
		default:
			System.out.println("Weekday");
		}
		
		// Salida de texto: Weekday

	}

}
