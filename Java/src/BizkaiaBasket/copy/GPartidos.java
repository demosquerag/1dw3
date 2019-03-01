package BizkaiaBasket.copy;

public class GPartidos {
	
	//clase con el arraylist partido y un metodo para crear partidos (añadir partidos al array)
	static String partido;
	// static ArrayList<Partido> partidos = new ArrayList<Partido>();
	static PartidosTableModel partidos = new PartidosTableModel();
	
	static void CrearPartido(Integer codigo, String equipoloc, String equipovis, String fecha, Integer faltasloc, Integer faltasvis, Integer triplesloc, Integer triplesvis, Integer puntosloc, Integer puntosvis)
	{
		partidos.CrearPartido(codigo, equipoloc, equipovis, fecha, faltasloc, faltasvis,  triplesloc, triplesvis, puntosloc, puntosvis);
	}
	
}



