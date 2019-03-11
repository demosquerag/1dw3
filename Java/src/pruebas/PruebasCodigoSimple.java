package pruebas;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PruebasCodigoSimple {

	public static void main(String[] args) {
		
		// Metemos en una lista los números del 1 al 40.
		List<Integer> numbers = new ArrayList<>(40);
		for (int i=1;i<41;i++){
		   numbers.add(i);
		}

		// Instanciamos la clase Random
		Random random = new Random();

		// Mientras queden cartas en el mazo (en la lista de numbers)
		while (numbers.size()>1){
		   // Elegimos un índice al azar, entre 0 y el número de cartas que quedan por sacar
		   int randomIndex = random.nextInt(numbers.size());

		   // Damos la carta al jugador (sacamos el número por pantalla)
		   System.out.println("Not Repeated Random Number "+numbers.get(randomIndex));

		   // Y eliminamos la carta del mazo (la borramos de la lista)
		   numbers.remove(randomIndex);
		}
		
		
		String cadena ="Una cadena de caracteres";
		char[] arrayChar = cadena.toCharArray();
 
		for(int i=0; i<arrayChar.length; i++){
 
			if( arrayChar[i] == 'a')
				System.out.println( arrayChar[i] + " -> es la vocal a");
			else
				System.out.println( arrayChar[i] + " -> no es la vocal a");
		}

	}

}
