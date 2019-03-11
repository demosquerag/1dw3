package evaluacion3;

import java.util.Scanner;

public class TryCatch5LEERENTEROSTRINGDIGITOSCORRECTOS2 {

	public static void main(String[] args) {

		// Necesidades previas
		String valor = "";
		int n = 0;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Introduce entero: ");
		valor = teclado.nextLine();
		teclado.close();

		try {
			// Convierto valor a int
			n = Integer.parseInt(valor);
		} catch (NumberFormatException nfe) {
			
			// Si se produce un Excepcion Corrijo el valor introducido en un entero valido
			String valorcorregido = "";
			char caracter;

			// Recorro caracter a caracter el String valor
			for (int p = 0; p < valor.length(); p++) {
				valor = valor.replace('l', '1').replace('o', '0').replace('O', '0');
				caracter = valor.charAt(p);
				
				// Compreubo si es un digito valido
				if (Character.isDigit(caracter)) {
					valorcorregido += caracter;
				} 
			}

			// Convierto el String valorcorregido en entero
			if (valorcorregido.length() > 0) {

				// Si valorcorregido tiene caracteres
				n = Integer.parseInt(valorcorregido);
			}

			// Salida del texto corregido
			System.out.println(n);

		}

	}

}
