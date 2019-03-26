package evaluacion3;

import java.io.Serializable;
import java.util.Scanner;

public class Complejo implements Comparable<Complejo>,Serializable{
	
	private static final long serialVersionUID = -2794389061398872678L;
	private double real;
	private double imaginario;
	
	Complejo(){
		this.real = 1.0;
		this.imaginario = 2.0;
	}

	public Complejo(double r, double i) {
		this.real = r;
		this.imaginario = i;
	}
	
	public Complejo(double r) {
		this.real = r;
		this.imaginario = 2.0;
	}

	public Complejo(Complejo r2) {
		this.real = r2.real;
		this.imaginario = r2.imaginario;
	}

	

	@Override
	public String toString() {
		return (real + " + " + imaginario + "i");
	}
	
	void escribir() {
		System.out.println(real + " + " + imaginario + "i");
	}

	// Getters and Setters
	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImaginario() {
		return imaginario;
	}

	public void setImaginario(double imaginario) {
		this.imaginario = imaginario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(imaginario);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(real);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			// Si es el mismo objeto 
			return true;
		if (obj == null)
			// Si el objeto que recibo NO existe
			return false;
		if (getClass() != obj.getClass())
			// Si los objetos NO son de la misma clase
			return false;
		// Comparo las propiedades de los objetos
		// Convierto el objeto a la clase a comparar
		Complejo other = (Complejo) obj;
		if(this.real == other.real && this.imaginario == other.imaginario) {
			// Si los valores de las propiedades son iguales
			return true;
		}
		return false;
		
		// Metodo dificil
		/*
		 * if (Double.doubleToLongBits(imaginario) != Double.doubleToLongBits(other.imaginario))
			return false;
		if (Double.doubleToLongBits(real) != Double.doubleToLongBits(other.real))
			return false;
		return true;
		*/
		
	}

	// CompareTo
	@Override
	public int compareTo(Complejo other) {
		// TODO Auto-generated method stub
		if (this.real > other.real) {
			return 1;
		}
		
		else if (this.real < other.real) {
			return -1;
		}
		
		else {
			// Si la parte imaginaria es igual
			if (this.imaginario > other.imaginario) {
				return 1;
			}
			else if (this.imaginario < other.imaginario) {
				return -1;
			}
			
		}
		return 0;
	}
	
	// leer
	public void leer (Scanner teclado){
		// lee por teclado las propiedades
		// leo real
		System.out.println("Real :");
		this.real = teclado.nextDouble();
		// leo imaginario
		System.out.println("Imaginario :");
		this.imaginario = teclado.nextDouble();
	}

}
