package evaluacion2;

import java.util.Scanner;


public class Persona implements Comparable<Persona>{
	private String dni;
	private String nombre;
	private String apellido;
	private Fecha fechanacimiento;
	
	// Constructor por defecto
	public Persona(){
		this.dni = "";
		this.nombre = "";
		this.apellido = "";
		this.fechanacimiento = new Fecha();
	}
	
	// Constructor personalizado
	public Persona(String d, String n, String a, Fecha f){
		this.dni = d;
		this.nombre = n;
		this.apellido = a;
		this.fechanacimiento = new Fecha(f);
	}
	
	// Constructor copia
	public Persona(Persona p) {
		this.dni = p.dni;
		this.nombre = p.nombre;
		this.apellido = p.apellido;
		this.fechanacimiento = new Fecha (p.fechanacimiento);
	}

	// Getters and Setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Fecha getFechanacimiento() {
		return fechanacimiento;
	}

	public void setFechanacimiento(Fecha fechanacimiento) {
		this.fechanacimiento = new Fecha(fechanacimiento);
	}
	
	
	// hashCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido == null) ? 0 : apellido.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((fechanacimiento == null) ? 0 : fechanacimiento.hashCode());
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
		Persona other = (Persona) obj;
		if (apellido == null) {
			if (other.apellido != null)
				return false;
		} else if (!apellido.equals(other.apellido))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (fechanacimiento == null) {
			if (other.fechanacimiento != null)
				return false;
		} else if (!fechanacimiento.equals(other.fechanacimiento))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	// Constructor con el compareTo
	public int compareTo(Persona other) {
		return (this.dni.compareTo(other.dni));
	}

	// toString
	@Override
	public String toString() {
		// Salida de texto
		//System.out.println(this.dni+" "+this.nombre+" "+this.apellido+" "+this.fechanacimiento);
		return (this.dni+" "+this.nombre+" "+this.apellido+" "+this.fechanacimiento);
	}
	
	public void leer(Scanner teclado) {
		// Pedir DNI
		System.out.println("DNI :");
		this.dni = teclado.nextLine();
		// leo nombre
		System.out.println("Nombre :");
		this.nombre = teclado.nextLine();
		// leo apellido
		System.out.println("Apellido :");
		this.apellido = teclado.nextLine();
		// leo fechanacimiento
		System.out.println("Fecha Nacimieto :");
		this.fechanacimiento.leerf(teclado);
	}

	
}
