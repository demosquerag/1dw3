package BizkaiaBasket.copy;


public class Partido {
	
	public int codigo;
	public String equipoloc;
	public String equipovis;
	public String fecha;
	public int faltasloc;
	public int faltasvis;
	public int triplesloc;
	public int triplesvis;
	public int puntosloc;
	public int puntosvis;
	
	// Getters and Setters
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getEquipoloc() {
		return equipoloc;
	}
	public void setEquipoloc(String equipoloc) {
		this.equipoloc = equipoloc;
	}
	public String getEquipovis() {
		return equipovis;
	}
	public void setEquipovis(String equipovis) {
		this.equipovis = equipovis;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getFaltasloc() {
		return faltasloc;
	}
	public void setFaltasloc(int faltasloc) {
		this.faltasloc = faltasloc;
	}
	public int getFaltasvis() {
		return faltasvis;
	}
	public void setFaltasvis(int faltasvis) {
		this.faltasvis = faltasvis;
	}
	public int getTriplesloc() {
		return triplesloc;
	}
	public void setTriplesloc(int triplesloc) {
		this.triplesloc = triplesloc;
	}
	public int getTriplesvis() {
		return triplesvis;
	}
	public void setTriplesvis(int triplesvis) {
		this.triplesvis = triplesvis;
	}
	public int getPuntosloc() {
		return puntosloc;
	}
	public void setPuntosloc(int puntosloc) {
		this.puntosloc = puntosloc;
	}
	public int getPuntosvis() {
		return puntosvis;
	}
	public void setPuntosvis(int puntosvis) {
		this.puntosvis = puntosvis;
	}
	
	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Equipo Local: " + equipoloc + ", Equipo Visitante: " + equipovis + ", Fecha: " + fecha + ", Faltas Local: " + faltasloc + ", Faltas Visitante: " + faltasvis + ", Triples Local: " + triplesloc + ", Triples Visitante: " + triplesvis + ", Puntos Local: " + puntosloc + ", Puntos Visitante: " + puntosvis;		
	}


}
