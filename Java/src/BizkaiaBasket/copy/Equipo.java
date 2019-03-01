package BizkaiaBasket.copy;

public class Equipo {

	public int codigo;
	public String nombre;
	public String municipio;
	public String email;
	public String terreno;
		
	Equipo(){
		this.codigo = 0;
		this.nombre = "";
		this.municipio = "";
		this.email = "";
		this.terreno = "";
	}
	
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Codigo: " + codigo + ", Nombre: " + nombre + ", Municipio: " + municipio + ", Email: " + email + ", Terreno: " + terreno;		
	}
	
	
	
	
}
