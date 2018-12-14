package evaluacion2;

import java.util.Scanner;

public class Bucle_1aNPrimos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Necesidades previas
		int j,num,cont_pri;
		boolean primo;
		cont_pri=0;
		
		Scanner teclado = new Scanner(System.in);
		
		// Leer número
		System.out.print("Introduce numero: ");
		num=teclado.nextInt();
		
		// Cerrarmos teclado
		teclado.close();
		
		// vamos procesando todos los números entre 1..num
		for(int i=1;i<=num;i++){
			// para cada número i, calcularemos si es primo
			// veremos si el número i es divisible en el rango 2..i-1
			// El bucle while se puede hacer con menos vuelta... consultar algoritmos para primos
			
			primo=true;
			j=2;
		
			while (j<=i-1 && primo==true) {
				if (i%j==0) {
					primo=false;
					j++;
				}
				
			}
			
			if (primo==true){
				// si es primo incrementamos el contador de primos
				cont_pri++; 
				System.out.println(i+(" es primo."));
			}
		
		}
		
		System.out.println("En el rango 1.." + num + ", hay "+ cont_pri + " números primos.");
	}

}
