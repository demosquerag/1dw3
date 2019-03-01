package BizkaiaBasket.copy;


public class GEquipos {
	
	static String equipo;
	static EquiposTableModel equipos = new EquiposTableModel();
	
	static void CrearEquipo(int codigo, String nombre, String municipio, String email, String terreno) {
		equipos.CrearEquipo(codigo, nombre, municipio, email, terreno);
	}
}