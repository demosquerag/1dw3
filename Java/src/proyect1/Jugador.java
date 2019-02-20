package proyect1;

public class Jugador extends Persona{
	
	private String equipo;
	private int dorsal;
	
	// Constructor publico por defecto
	Jugador() {
		this.equipo =  "";
		this.dorsal = 0;		
	}
	
	// Contructor personalizado
	Jugador(Jugador j){
		this.equipo =  j.equipo;
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

	// hasCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + dorsal;
		result = prime * result + ((equipo == null) ? 0 : equipo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		if (dorsal != other.dorsal)
			return false;
		if (equipo == null) {
			if (other.equipo != null)
				return false;
		} else if (!equipo.equals(other.equipo))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return ("DNI: "+this.getDni()+", Nombre: "+this.getNombre()+", Apellido1: "+this.getApellido1()+", Apellido2: "+this.getApellido2()+", Equipo: "+this.getEquipo()+", Dorsal: "+this.getDorsal());
	}

	
}
