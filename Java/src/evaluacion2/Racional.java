package evaluacion2;

public class Racional implements Comparable<Racional>{
	// Defino la clase Racional con sus propiedades
	private int numerador;
	private int denominador;
	
	// Metodos
	// Creacion de un constructor publico por defecto
	Racional(){
		this.numerador = 0;
		this.denominador = 1;
	}

	// Creacion de un constructor publico con dos valores enteros
	public Racional(int n, int d) {
		this.numerador = n;
		this.denominador = d;
	}

	// Creacion de un constructor publico con un valor entero
	public Racional(int n) {
		this.numerador = n;
		this.denominador = 1;
	}

	// Creacion de un constructor publico copiado de otro constructor
	public Racional(Racional r2) {
		this.numerador = r2.numerador;
		this.denominador = r2.denominador;
	}

	// ToString
	@Override
	public String toString() {
		//return "Racional [numerador=" + numerador + ", denominador=" + denominador + "]";
		return (this.numerador+"/"+this.denominador);
	}
	
	// Getters and Setters
	public double getNumerador() {
		return numerador;
	}

	public void setNumerador(int numerador) {
		this.numerador = numerador;
	}

	public double getDenominador() {
		return denominador;
	}

	public void setDenominador(int denominador) {
		this.denominador = denominador;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			// Si es el mismo objeto 
			return true;
		if (obj == null)
			// Si el objeto que recibo NO existe
			return false;
		if (getClass() != obj.getClass())
			// Si los objetos NO son de la misma clase
			return false;
		// Comparo las propiedades de los objetos
		// Convierto el objeto a la clase a comparar
		Racional other = (Racional) obj;
		//double d1 = this.numerador / this.denominador;
		//double d2 = other.numerador / other.denominador;
		if ((this.numerador * other.denominador) == (other.numerador * this.denominador)) {
			return true;
		}
		return false;

		// Metodo dificil
		/*
		 * if (Double.doubleToLongBits(denominador) != Double.doubleToLongBits(other.denominador))
			return false;
		if (Double.doubleToLongBits(numerador) != Double.doubleToLongBits(other.numerador))
			return false;
		return true;
		*/
		
	}

	// CompareTo
	@Override
	public int compareTo(Racional other) {
		// TODO Auto-generated method stub
		if ((this.numerador * other.denominador) > (other.numerador * this.denominador)) {
			return 1;
		}
			
		else if ((this.numerador * other.denominador) < (other.numerador * this.denominador)) {
			return -1;
		}
		return 0;
	}

}
