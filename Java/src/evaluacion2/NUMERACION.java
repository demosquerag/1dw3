package evaluacion2;

import java.util.Arrays;

public class NUMERACION {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Array de String
        int[] numeros = {4, 8, 2, 6};

        //Ordena el array
        Arrays.sort(numeros);

        //Mostramos el array ya ordenado
        for (int i : numeros) {
            System.out.print(i + ", ");
        }

	}

}
