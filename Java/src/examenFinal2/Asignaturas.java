package examenFinal2;

public class Asignaturas {
	
	// Necesidades previas
	private String codigoasignatura;
	private String nombreasignatura;
	private String descripcion;
	
	// Metodo por defecto
	public Asignaturas() {
		this.codigoasignatura = "";
		this.nombreasignatura = "";
		this.descripcion = "";
	}
	
	// Metodo personalizado
	public Asignaturas(String c, String n, String d) {
		this.codigoasignatura = c;
		this.nombreasignatura = n;
		this.descripcion = d;
	}
	
	// Metodo copia
	public Asignaturas(Asignaturas a) {
		this.codigoasignatura = a.codigoasignatura;
		this.nombreasignatura = a.nombreasignatura;
		this.descripcion = a.descripcion;
	}

	
	// getters and setters
	public String getCodigoasignatura() {
		return codigoasignatura;
	}

	public void setCodigoasignatura(String codigoasignatura) {
		this.codigoasignatura = codigoasignatura;
	}

	public String getNombreasignatura() {
		return nombreasignatura;
	}

	public void setNombreasignatura(String nombreasignatura) {
		this.nombreasignatura = nombreasignatura;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	// hasCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigoasignatura == null) ? 0 : codigoasignatura.hashCode());
		result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + ((nombreasignatura == null) ? 0 : nombreasignatura.hashCode());
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
		Asignaturas other = (Asignaturas) obj;
		if (codigoasignatura == null) {
			if (other.codigoasignatura != null)
				return false;
		} else if (!codigoasignatura.equals(other.codigoasignatura))
			return false;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (nombreasignatura == null) {
			if (other.nombreasignatura != null)
				return false;
		} else if (!nombreasignatura.equals(other.nombreasignatura))
			return false;
		return true;
	}

	// toString
	@Override
	public String toString() {
		return ("Codigo Asignatura: "+this.codigoasignatura+" Nombre Asignatura: "+this.nombreasignatura+" Descripcion: "+this.descripcion);
	}
	
	

}
