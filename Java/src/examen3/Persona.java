package examen3;

import java.io.Serializable;

public class Persona implements Comparable<Persona>, Serializable{

	private static final long serialVersionUID = 1543359510048065949L;
	private String Dni;
	private String Nombre;
	private String Apellido;
	
	// Lehenetsitako eraikitzailea
	Persona(){
		this.Dni = "";
		this.Nombre = "";
		this.Apellido="";
	}
	
	// Erabiltzaileen eraikitzaileak
	Persona(String Dni, String Nombre, String Apellido ){
		this.Dni = Dni;
		this.Nombre = Nombre;
		this.Apellido=Apellido;
	}
	
	// constructor copia
	Persona(Persona p){
		this.Dni = p.Dni;
		this.Nombre = p.Nombre;
		this.Apellido=p.Apellido;
	}

	// Getters and Setters
	public String getDni() {
		return Dni;
	}

	public void setDni(String dni) {
		Dni = dni;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}


	// hascode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
		result = prime * result + ((Dni == null) ? 0 : Dni.hashCode());
		result = prime * result + ((Nombre == null) ? 0 : Nombre.hashCode());
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
		Persona other = (Persona) obj;
		if (Apellido == null) {
			if (other.Apellido != null)
				return false;
		} else if (!Apellido.equals(other.Apellido))
			return false;
		if (Dni == null) {
			if (other.Dni != null)
				return false;
		} else if (!Dni.equals(other.Dni))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}

	//compareTo
	@Override
	public int compareTo(Persona p) {
		String n1,n2;
		n1 = this.Dni;
		n2 = p.Dni ;
		
		return n1.compareTo(n2);
	}
	
	@Override
	public String toString() {
		// return "Persona [Dni=" + Dni + ", Nombre=" + Nombre + ", Apellido=" + Apellido + "]";
		return (Dni+" | "+Nombre+" | "+Apellido);
	}
}
