package evaluacion1;

import java.util.Scanner;

public class XIII_Capicua {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num;
		int dm, um, c, d, u;
		// 9 9 . 9 9 9 a cada guarismo lo llamaremos:
		//dm um c d u: dm (decenas de millar), um:(unidades de millar)
		// c: (centenas), d: (decenas), u: (unidades)
		Scanner teclado = new Scanner(System.in);
		System.out.print("Introduzca un número entre 0 y 99.999: ");
		num=teclado.nextInt();
		
		teclado.close();
		
		// unidad
		u = num % 10;
		num = num / 10;
		
		// decenas
		d = num % 10;
		num = num / 10;
		
		// centenas
		c = num % 10;
		num = num / 10;
		
		// unidades de millar
		um = num % 10;
		num = num / 10;
		
		// decenas de millar
		dm = num;
		
		// el número será capicúa si las cifras son iguales dos a dos por los extremos
		// las centenas no las tenemos en cuenta
		if (dm == u && um == d) {
			System.out.println ("El número es capicúa.");
		}
			
		else {
			System.out.println ("el número NO es capicúa");
		}
		
		// hay que tener en cuenta que en este ejercicio el número 121 es similar al 00121 y
		// resulta que 121 es capicúa, pero nuestro código lo identifica como NO capicúa. Ya
		// que trabajamos con el 00121. No tendremos en cuenta este pequeño error.
	}

}
