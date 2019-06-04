package examenFinal2;

public class Calificaciones {
	
	// Necesidades previas
	private String dni;
	private String codigoasignatura;
	private Integer nota;
	
	// Metodo por defecto
	public Calificaciones() {
		this.dni = getDni();
		this.codigoasignatura = getCodigoasignatura();
		this.nota = 0;
	}
	
	// Metodo personalizado
	public Calificaciones(Alumnos a, Asignaturas c, Integer n) {
		// super(a);
		this.dni = a.getDni();
		this.codigoasignatura = c.getCodigoasignatura();
		this.nota = n;
	}
	
	// Metodo copia
	public Calificaciones(Calificaciones c) {
		// super(c);
		this.dni = c.getDni();
		this.codigoasignatura = c.getCodigoasignatura();
		this.nota = c.nota;
	}

	// getters and setters
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getCodigoasignatura() {
		return codigoasignatura;
	}

	public void setCodigoasignatura(String codigoasignatura) {
		this.codigoasignatura = codigoasignatura;
	}

	public Integer getNota() {
		return nota;
	}

	public void setNota(Integer nota) {
		this.nota = nota;
	}

	// hasCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((codigoasignatura == null) ? 0 : codigoasignatura.hashCode());
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
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
		Calificaciones other = (Calificaciones) obj;
		if (codigoasignatura == null) {
			if (other.codigoasignatura != null)
				return false;
		} else if (!codigoasignatura.equals(other.codigoasignatura))
			return false;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return ("DNI: "+getDni()+" Codigo Asignatura: "+getCodigoasignatura()+" Nota: "+this.nota);
	}
	

}
