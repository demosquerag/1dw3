package BizkaiaBasket.copy;

public class Estadistica {
	
	public String equipo;
	public int faltac;
	public int faltar;
	public int triplec;
	public int tripler;
	
	public String getEquipo() {
		return equipo;
	}
	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}
	public int getFaltac() {
		return faltac;
	}
	public void setFaltac(int faltac) {
		this.faltac = faltac;
	}
	public int getFaltar() {
		return faltar;
	}
	public void setFaltar(int faltar) {
		this.faltar = faltar;
	}
	public int getTriplec() {
		return triplec;
	}
	public void setTriplec(int triplec) {
		this.triplec = triplec;
	}
	public int getTripler() {
		return tripler;
	}
	public void setTripler(int tripler) {
		this.tripler = tripler;
	}
	
	@Override
	public String toString() {
		return "Equipo: " + equipo + ", Faltas Cometidas: " + faltac + ", Faltas Recibidas: " + faltar + ", Triples Cometidos: " + triplec + ", Triples Recibidos: " + tripler;		
	}

}
