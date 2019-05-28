package examen2;


public class claseJugador extends clasePersona {
	
	String equipo;
	int dorsal;
	
	// Constructor por defecto
	public claseJugador() {
		this.equipo = "";
		this.dorsal = 9;
	}
	
	// Constructor copia
	public claseJugador(claseJugador j) {
		this.equipo = j.equipo;
		this.dorsal = j.dorsal;
	}

	// Getters and setters
	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public int getDorsal() {
		return dorsal;
	}

	public void setDorsal(int dorsal) {
		this.dorsal = dorsal;
	}
	
	// Constructor con el compareTo
	public int compareTo(claseJugador other) {
		return (this.dni.compareTo(other.dni));
	}
	
	// toString
	@Override
	public String toString() {
		// Salida de texto
		//System.out.println("Nombre: "+this.nombre+", Apellido1: "+this.apellido1+", Apellido2: "+this.apellido2+", DNI: "+this.dni+", Equipo: "+this.equipo+", Dorsal: "+this.dorsal);
		return ("Nombre: "+this.nombre+", Apellido1: "+this.apellido1+", Apellido2: "+this.apellido2+", DNI: "+this.dni+", Equipo: "+this.equipo+", Dorsal: "+this.dorsal);
	}

}
