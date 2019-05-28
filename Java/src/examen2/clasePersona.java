package examen2;

public class clasePersona {
	String dni;
	String nombre;
	String apellido1;
	String apellido2;
	
	// Constructor por defecto
	public clasePersona(){
		this.dni = "";
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
	}
	
	// Constructor copia
	public clasePersona(clasePersona p) {
		this.dni = p.dni;
		this.nombre = p.nombre;
		this.apellido1 = p.apellido1;
		this.apellido2 = p.apellido2;
	}

	// getters and setters
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

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellido1 == null) ? 0 : apellido1.hashCode());
		result = prime * result + ((apellido2 == null) ? 0 : apellido2.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
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
		clasePersona other = (clasePersona) obj;
		if (apellido1 == null) {
			if (other.apellido1 != null)
				return false;
		} else if (!apellido1.equals(other.apellido1))
			return false;
		if (apellido2 == null) {
			if (other.apellido2 != null)
				return false;
		} else if (!apellido2.equals(other.apellido2))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
	
	// Constructor con el compareTo
	public int compareTo(clasePersona other) {
		return (this.dni.compareTo(other.dni));
	}
	
	// toString
	@Override
	public String toString() {
		// Salida de texto
		//System.out.println(this.nombre+" "+this.apellido1+" "+this.apellido2+" "+this.dni);
		return ("Nombre: "+this.nombre+", Apellido1: "+this.apellido1+", Apellido2: "+this.apellido2+", DNI: "+this.dni);
	}
	
}
