package examenFinal1;

public class Vehiculos implements Comparable<Vehiculos> {

	private String matricula;
	private String marca;
	private String modelo;
	
	public Vehiculos() {
		this.matricula = "";
		this.marca = "";
		this.modelo = "";
	}
	
	public Vehiculos(String m, String a, String o) {
		this.matricula = m;
		this.marca = a;
		this.modelo = o;
	}
	
	public Vehiculos(Vehiculos v) {
		this.matricula = v.matricula;
		this.marca = v.marca;
		this.modelo = v.modelo;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((marca == null) ? 0 : marca.hashCode());
		result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
		result = prime * result + ((modelo == null) ? 0 : modelo.hashCode());
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
		Vehiculos other = (Vehiculos) obj;
		if (marca == null) {
			if (other.marca != null)
				return false;
		} else if (!marca.equals(other.marca))
			return false;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		if (modelo == null) {
			if (other.modelo != null)
				return false;
		} else if (!modelo.equals(other.modelo))
			return false;
		return true;
	}
	
	// Constructor con el compareTo
	public int compareTo(Vehiculos other) {
		return (this.matricula.compareTo(other.matricula));
	}

	@Override
	public String toString() {
		return ("Matricula: "+ matricula +" Marca: "+ marca +" Modelo "+ modelo);
	}
	
}
