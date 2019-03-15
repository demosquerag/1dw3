package evaluacion3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RANDOMMASTERMINDCLASE {

	public static void main(String[] args) {
		
		//genero un numero de 4 cifras diferentes
		ArrayList<Integer> numerocorrecto = new ArrayList<Integer>();
			
			Random rnd = new Random();
			int cifra;
			String numero = "";
			int posicioncorrecta;
			
			do {
			//genero una cifra
			cifra = ((int)(rnd.nextDouble()*100000.0))%10;
			//compruebo si esta en el arraylist
			if(!numerocorrecto.contains(cifra)) {
				//si no esta en el arraylist
				//la añado
				numerocorrecto.add(cifra);
			 }
			}
			while (numerocorrecto.size()<4);
			
			//muestro el numero generado
			System.out.println("Numero generado: " + numerocorrecto);
			
			//defino un objeto de la clase escaner
			Scanner teclado;
			//creo un objeto de la clase escaner
			teclado = new Scanner(System.in);
			
			//pido numeros de cuatro cifras
			//hasta wue se acierte el numero
			System.out.println("Introduce un numero:" );
			numero = teclado.nextLine();
			if(numero.length()==4) {
				//si el numero tiene cuatro cifras
				//compruebo si hay alguna cifra en el numero correcto
				//por cada cifra indico si coincide la posicion
				for(int posicion = 0; posicion<4; posicion++) {
				cifra = numero.charAt(posicion)-'0';
				System.out.println("Cifra: " + cifra);
				//compruebo si hay alguna cifra en el numero correcto
				posicioncorrecta = numerocorrecto.indexOf(cifra); // devuelve la posocion o -1 no la encuentra
					if(posicioncorrecta != 1) {
						// compruebo si coincide la posicion
						if (posicion == posicioncorrecta) {
							//si la posicion esta en la misma posicion
							
						}
					}
				}
			}
			
		//cierro teclado
		teclado.close();
	}

}
