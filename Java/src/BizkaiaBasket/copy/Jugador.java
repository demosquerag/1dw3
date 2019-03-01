package BizkaiaBasket.copy;

public class Jugador {
	
	public String Dni;
	public String Nombre;
	public String Apellido;
	public String Equipo;
	

	//Getters and setters
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
	public String getEquipo() {
		return Equipo;
	}
	public void setEquipo(String equipo) {
		Equipo = equipo;
	}
	
	// hasCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Apellido == null) ? 0 : Apellido.hashCode());
		result = prime * result + ((Dni == null) ? 0 : Dni.hashCode());
		result = prime * result + ((Equipo == null) ? 0 : Equipo.hashCode());
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
		Jugador other = (Jugador) obj;
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
		if (Equipo == null) {
			if (other.Equipo != null)
				return false;
		} else if (!Equipo.equals(other.Equipo))
			return false;
		if (Nombre == null) {
			if (other.Nombre != null)
				return false;
		} else if (!Nombre.equals(other.Nombre))
			return false;
		return true;
	}
	
	//CompareTo
	public int compareTo(Jugador other) {
		// comparo SOLO el dni
		return (this.Dni.compareTo(other.Dni));
	}
	
	// toString
	@Override
	public String toString() {
		return "Dni: " + Dni + ", Nombre: " + Nombre + ", Apellido: " + Apellido + ", Equipo: " + Equipo;		
	}
	
}
