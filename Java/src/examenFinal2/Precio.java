package examenFinal2;

import java.io.Serializable;

public class Precio implements Serializable, Comparable <Precio>{

	// Necesidades preivas
	private static final long serialVersionUID = -7950311716753704312L;
	private double valor;
	
	// Metodo por defecto
	public Precio() {
		this.valor=1.0;
	}
	
	// Metodo personalizado
	public Precio(double v) {
		this.valor=v;
	}
	
	// Metodo copia
	public Precio(Precio p) {
		this.valor=p.valor;
	}
	
	// getters and setters
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	// hasCode and equals
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(valor);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Precio other = (Precio) obj;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	
	// compareTo
	@Override
	public int compareTo(Precio other) {
		Double p1=new Double(this.valor);
		Double p2= new Double(other.valor);
		return(-p1.compareTo(p2));
	}
	
	// toString
	@Override
	public String toString() {
		return ("Valor: "+ this.valor);
	}
	
}
