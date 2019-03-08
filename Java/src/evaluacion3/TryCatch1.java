package evaluacion3;

import java.io.IOException;

public class TryCatch1 {

	public static void main(String[] args) {
		
		try {
			byte[] nombre = new byte[30];
			System.out.println("Introduce tu nombre: ");
			System.in.read(nombre);
			System.out.println("Hola "+ new String(nombre));
		} catch (IOException ioe) {
			// muestro el error
			System.out.println("Error al leer los datos");
		}

	}

}
