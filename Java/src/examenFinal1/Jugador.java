package examenFinal1;

import java.io.Serializable;
import java.util.Scanner;

public class Jugador implements Comparable<Jugador>, Serializable {
	
	// Necesidades previas
	private static final long serialVersionUID = 6219468329342728591L;
	private String nombre;
	private int nivel;
	
	// Metodo por defecto
	public Jugador() {
		this.nombre = "Sin Nombre";
		this.nivel = 0;
	}
	
	// Metodo personalizado
	public Jugador(String n, int i) {
		this.nombre=n;
		this.nivel=i;
	}
	
	// Metodo copia
	public Jugador(Jugador j) {
		this.nombre=j.nombre;
		this.nivel=j.nivel;
	}
	
	// getters and setters
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getNivel() {
		return nivel;
	}
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}
	
	// hasCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + nivel;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Jugador other = (Jugador) obj;
		if (nivel != other.nivel)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	// compareTo
	@Override
	public int compareTo(Jugador j) {
		int n1, n2;
		n1 = this.nivel;
		n2 = this.nivel=j.nivel;
		if(n1<n2) {
			return -1;
		}
		else if(n1>n2) {
			return 1;
		}
		else {
			return 0;
		}
		
	}
	
	// Metodo para leer por teclado
	public void leer(Scanner teclado) {
		System.out.println("Nombre: ");
		this.nombre = teclado.nextLine();
		System.out.println("Nivel: ");
		this.nivel = teclado.nextInt();
	}
	
	// toString
	@Override
	public String toString() {
		return ("Nombre: " + this.nombre + " Nivel: " + this.nivel);
	}

}
