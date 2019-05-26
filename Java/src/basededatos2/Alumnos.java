package basededatos2;

public class Alumnos implements Comparable<Alumnos>{
	
	// Necesidades previas
	private String dni;
	private String nombre;
	private String apellidos;
	private String grupo;
	
	// Metodo-Constructor por defecto
	public Alumnos() {
		this.dni = "";
		this.nombre = "";
		this.apellidos = "";
		this.grupo = "";
	}
	
	// Metodo-Constructor copia
	public Alumnos(Alumnos a) {
		this.dni = a.dni;
		this.nombre = a.nombre;
		this.apellidos = a.apellidos;
		this.grupo = a.grupo;
	}
	
	// Metodo-Constructor personalizado
	public Alumnos(String d, String n, String a, String g) {
		this.dni = d;
		this.nombre = n;
		this.apellidos = a;
		this.grupo = g;
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

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getGrupo() {
		return grupo;
	}

	public void setGrupo(String grupo) {
		this.grupo = grupo;
	}

	// hascode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apellidos == null) ? 0 : apellidos.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((grupo == null) ? 0 : grupo.hashCode());
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
		Alumnos other = (Alumnos) obj;
		if (apellidos == null) {
			if (other.apellidos != null)
				return false;
		} else if (!apellidos.equals(other.apellidos))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (grupo == null) {
			if (other.grupo != null)
				return false;
		} else if (!grupo.equals(other.grupo))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

	// Metodo-Constructor con el compareTo
	@Override
	public int compareTo(Alumnos other) {
		return (this.dni.compareTo(other.dni));
	}

	// toString
	@Override
	public String toString() {
		// return "Alumnos [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", grupo=" + grupo + "]";
		return (this.dni+" "+this.nombre+" "+this.apellidos+" "+this.grupo);
	}
	
	
	

}
