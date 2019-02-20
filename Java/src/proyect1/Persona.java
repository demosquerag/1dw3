package proyect1;

public class Persona {
	
	private String dni;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	Persona(){
		this.dni = "";
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
	}
	
	Persona (Persona p){
		this.dni = p.dni;
		this.nombre = p.nombre;
		this.apellido1 = p.apellido1;
		this.apellido2 = p.apellido2;
	}

	// Getters and setters
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

	// HasCode and equals
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
		Persona other = (Persona) obj;
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

	// toString
	@Override
	public String toString() {
		return ("DNI: "+this.dni+", Nombre: "+this.nombre+", Apellido1: "+this.apellido1+", Apellido2: "+this.apellido2);
	}
	
	// Constructor con el compareTo
	public int compareTo(Persona other) {
		if (this.dni.equals(other.dni)) {
			return -1;
		}
		else {
			return 1;
		}
		
	}
	
	

}
