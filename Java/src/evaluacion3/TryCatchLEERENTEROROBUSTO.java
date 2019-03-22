package evaluacion3;

import java.util.Scanner;

public class TryCatchLEERENTEROROBUSTO {

	public static void main(String[] args) {
		
		// Necesidades previas
		Scanner teclado = new Scanner(System.in);
		String valor = "";
		int n = 0;
		
		// Leer por teclado un valor
		System.out.println("Introduce un valor: ");
		valor = teclado.nextLine();
		
		
		try {
			// Convertir valor a int
			n = Integer.parseInt(valor);
			
		} catch (NumberFormatException nfe) {
			
			// Necesidades previas
			String valorcorregido = "";
			char caracter;
			
			// Recorrer el caracter String valor:
			for (int posicion = 0; posicion < valor.length(); posicion++) {
				
				caracter = valor.charAt(posicion);
				// Comprobar si es un digito válido
				if (Character.isDigit(caracter)) {
					
					valorcorregido += caracter;
					
				} else if (caracter == 'l') {
					
					valorcorregido += '1';
					
				} else if (caracter == 'o' || caracter == 'O') {
					
					valorcorregido += '0';
					
				}
				
			}
			// Convertir el String valorcorregido a Entero
			if (valorcorregido.length() > 0) {
				
				n = Integer.parseInt(valorcorregido);
				
			}
		}
		// Sacar por consola el valor n
		System.out.println("El valor de la variable es: " + n);
		
		// Cerrar teclado
		teclado.close();

	}

}
