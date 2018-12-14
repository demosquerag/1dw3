package evaluacion1;

import java.util.Scanner;

public class VII_Segundoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Iniciamos la variable del número entero		
		int hora, minutos, segundos;
				
		// Para que la consola lea lo que introducimos por teclado
		// Creamos la clase Scanner
		Scanner teclado = new Scanner(System.in);
		
		// Pedimos el numero entero Hora
		System.out.println("Introduce la hora: ");
		hora = teclado.nextInt();
		
		// Pedimos el numero entero Minutos
		System.out.println("Introduce los minutos: ");
		minutos = teclado.nextInt();
				
		// Pedimos el numero entero Segundos
		System.out.println("Introduce los segundos: ");
		segundos = teclado.nextInt();
		
		// Cerramos teclado
		teclado.close();
		
		// Comienzo de la condición
		while (segundos >= 60) {
			segundos = segundos - 60;
			minutos = minutos +1;
		}
		
		while (minutos >=60) {
				minutos = minutos - 60;
				hora = hora + 1;
		}
		
		// Sacamos Hora Minutos Segundos
		System.out.println("Son --> " + hora +"h " + minutos + "m " + segundos + "s");
	}

}
