package evaluacion3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class RANDOMMASTERMIND {

	public static void main(String[] args) {
		
		// Necesidades previas
		Scanner teclado = new Scanner(System.in);
		Random rnd = new Random();
		ArrayList<String> arraymastermind = new ArrayList<String>();
		
		String numerovalidoS = "";
		String numero = "";
		int numerovalido = 0;
		
		// Generar numeros aleatorios que no se repitan en el arraylist
		for (int i=0;i<4;i++){
			// Generar numero aleatoriamente y sacar texto por consola del 0-9
			numerovalido = ((int)(rnd.nextDouble()*100000.0))%9;
			// Pasar numerovalido a String
			numerovalidoS = String.valueOf(numerovalido);
			if (arraymastermind.contains(numerovalidoS)) {
				// Si es igual resto 1
		        i--;
		    } else {
		    	arraymastermind.add(numerovalidoS);
		    }
		}
		
		// Realizar la repetitiva al menos una vez
		do {
			// Pedir numero por teclado de 4 digitos
			System.out.println("Inserta un numero: ");
			numero = teclado.nextLine();
			
			if (numero.equals(numerovalidoS)) {
				
				for(int i=0; i<arraymastermind.size(); i++){
					 
					if(numero.equals(numerovalidoS.length()))
						System.out.println( numero + " es igual a -> " + numerovalidoS);
					else
						System.out.println( numero + " es igual a -> "+ numerovalidoS);
				}
				// Salida de texto de los numeros generados en el ArrayList
				System.out.println("Numeros aleatorios generados son:");
				for (String n : arraymastermind) {
				    System.out.println(n + "");
				}
				break;
			} 						
			
		} while(!(numero.equals(numerovalidoS)));
		
		teclado.close();
		
		System.out.println("Has acertado, tu numero es: "+ numero + " y el numero secreto es: "+ numerovalidoS);
	

	}

}
