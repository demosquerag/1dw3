package evaluacion2;

import java.util.Scanner;

public class Fecha {
	private int dia;
	private int mes;
	private int año;
	
	// Metodos
	// Creacion de un constructor publico por defecto
	Fecha(){
		this.dia = 10;
		this.mes = 11;
		this.año = 1999;
	}
	
	// Creacion de un constructor publico personalizado
	public Fecha(int d, int m, int a){
		this.dia = d;
		this.mes = m;
		this.año = a;
	}
	
	// Creacion de un constructor publico copiado
	public Fecha(Fecha f){
		this.dia = f.dia;
		this.mes = f.mes;
		this.año = f.año;
	}
	
	// ToString
	@Override
	public String toString() {
		// Salida de texto
		return (this.dia+"/"+this.mes+"/"+this.año);
	}

	// Setter and Getter
	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAño() {
		return año;
	}

	public void setAño(int año) {
		this.año = año;
	}

	public void leerf(Scanner teclado) {
		// lee por teclado las propiedades
		// leo dia
		System.out.println("Dia :");
		this.dia = teclado.nextInt();
		// leo mes
		System.out.println("Mes :");
		this.mes = teclado.nextInt();
		// leo año
		System.out.println("Año :");
		this.año = teclado.nextInt();
	}

	
}
