package evaluacion2;

import java.util.Scanner;

public class Fecha implements Comparable<Fecha>{
	int dia;
	int mes;
	int año;
	
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
	
	
	// hascode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + año;
		result = prime * result + dia;
		result = prime * result + mes;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fecha other = (Fecha) obj;
		if (año != other.año)
			return false;
		if (dia != other.dia)
			return false;
		if (mes != other.mes)
			return false;
		return true;
	}

	// Constructor de lectura por teclado
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

	// Constructor con el compareTo
	@Override
	public int compareTo(Fecha other) {
		// Comparo las propiedades de los objetos
		// de la clase Fecha
		int comparacion = 0;
		
		// comparacion
		if (this.año > other.año) {
			comparacion = 1;
		}
		else if (this.año < other.año) {
			comparacion = -1;
		}
		else {
			// si el año es igual // comparo el mes
			if (this.mes > other.mes) {
				comparacion = 1;
			}
			else if (this.mes < other.mes) {
				comparacion = -1;
			}
			else {
				// si el mes es igual // comparo el dia
				if (this.dia > other.dia) {
					comparacion = 1;
				}
				else if (this.dia < other.dia) {
					comparacion = -1;
				}
			}
		}
		return (comparacion);
	}

	
}
