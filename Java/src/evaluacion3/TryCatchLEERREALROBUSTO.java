package evaluacion3;

import java.util.Scanner;

public class TryCatchLEERREALROBUSTO {

	public static void main(String[] args) {

		// Necesidades previas
		Scanner teclado = new Scanner(System.in);
		String valor = "";
		double n = 0.0;

		// Leer por teclado un valor
		System.out.println("Introduce un valor: ");
		valor = teclado.nextLine();

		try {
			// Convertir valor a double
			n = Double.parseDouble(valor);

		} catch (NumberFormatException nfe) {

			// Necesidades previas
			String valorcorregido = "";
			char caracter;
			boolean separadordecimal = false;

			// Recorrer el caracter String valor:
			for (int posicion = 0; posicion < valor.length(); posicion++) {

				caracter = valor.charAt(posicion);
				// Comprobar si es un digito válido
				if (Character.isDigit(caracter)) {
					// Añadir caracter al valorcorregido
					valorcorregido += caracter;

				} else if (caracter == 'l') {

					valorcorregido += '1';

				} else if (caracter == 'o' || caracter == 'O') {

					valorcorregido += '0';

				} else if (caracter == ',' || caracter == '.') {
					
					if (separadordecimal == false) {
						
						valorcorregido += '.';
						// Actualizar la variable
						separadordecimal = true;
						
					}
				}
			}
			// Convertir el String valorcorregido a Real
			if (valorcorregido.length() > 0) {

				n = Double.parseDouble(valorcorregido);

			}
		}
		// Sacar por consola el valor n
		System.out.println("El valor de la variable es: " + n);

		// Cerrar teclado
		teclado.close();

	}
}
