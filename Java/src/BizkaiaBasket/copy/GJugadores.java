package BizkaiaBasket.copy;

public class GJugadores {
	
	static String jugador;
	static JugadoresTableModel jugadores = new JugadoresTableModel();
	
	static void CrearJugador(String dni, String nombre, String apellido, String equipo) {
		jugadores.CrearJugador(dni, nombre, apellido, equipo);
	}
		
}

