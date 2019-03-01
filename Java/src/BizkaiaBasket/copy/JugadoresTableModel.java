package BizkaiaBasket.copy;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class JugadoresTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 2183436995229399228L;
	protected static ArrayList<Jugador> jugadores;
	
	public JugadoresTableModel() {  // Constructor principal
		
		jugadores = new ArrayList<Jugador>();
		
		Jugador A = new Jugador();
		Jugador B = new Jugador();
		Jugador C = new Jugador();
		Jugador D = new Jugador();
				
		A.Dni = "10101010A";				// DNI
		A.Nombre = "Daniel";				// Nombre
		A.Apellido = "Mosquera";		// Apellido
		A.Equipo = "Bilbao Basket"; // Equipo
		
		B.Dni = "01010101A"; // DNI
		B.Nombre = "Amaro";	// Nombre
		B.Apellido = "Martinez";	// Apellido
		B.Equipo = "Villasana BC"; // Equipo
		
		C.Dni = "11001100A"; // DNI
		C.Nombre = "Salomon"; // Nombre
		C.Apellido = "Nzo Nsue"; // Apellido
		C.Equipo = "San Francisco BC"; // Equipo
		
		D.Dni = "00110011A"; // DNI
		D.Nombre = "Aitor";	// Nombre
		D.Apellido = "Bartolome";	// Apellido
		D.Equipo = "Bermeo BC"; // Equipo
		
		jugadores.add(A);					// Insertamos en jugador
		jugadores.add(B);
		jugadores.add(C);
		jugadores.add(D);
		
	}
	
	@Override
	public int getColumnCount() {
		
		return 4;				// Serán dos columnas
		
		// return Usuario.class.getDeclaredFields().length;  // Calcula cuantos campos tiene (atributos o vartiables) tiene la clase Usuario;
		
	}
	
	@Override
	public int getRowCount() {
		
		return jugadores.size(); // Duelve cuantos usuarios hay almacenados para generar las filas de la tabla
		
	}
	
	@Override
	public Object getValueAt(int fila, int columna) {  // Inserta datos en la tablas

		Object valor = null; // Object puede recoger cualquier tipo de dato
		
		Jugador ju = jugadores.get(fila);
		
		switch (columna) {
		
			case 0:
				
				valor = ju.Dni;
				
				break;
			
			case 1:
				
				valor = ju.Nombre;
				
				break;
			
			case 2:
				
				valor = ju.Apellido;
				
				break;
				
			case 3:
				
				valor = ju.Equipo;
				
				break;
		
		}
		
		return valor;
		
	}
	
	public Jugador getJugador(String jugador) { // Comprueba que el usuario tecleado existe en el ArrayList usuarios
		
		for(Jugador ju:jugadores) {
			
			if (ju.Dni.equals(jugador)) {
				
				return ju; // y lo devuelve
			}
			
		}
		
		return null;		// Si no lo encuentra, devuelve null
		
	}
		
	public void CrearJugador(String dni, String nombre, String apellido, String equipo) {

		if (getJugador(dni) == null) {
			
			//Cargarse este caso si no se van a añadir jugaodes
			Jugador jug = new Jugador();
			jug.Dni = dni;
			jug.Nombre = nombre;
			jug.Apellido = apellido;
			jug.Equipo = equipo;

			jugadores.add(jug);

			fireTableDataChanged();
		
		}
		else {
			JOptionPane.showMessageDialog(null,"El usuario " + dni + "  ya existe.");
		}
	}

	public void removeRow(Integer i) {
		
		i = VentanaGJugadores.getTblGJugadores().getSelectedRow();
		
		if (i >= 0) {
			GJugadores.jugadores.removeRow(i);
		}
		else {
			JOptionPane.showMessageDialog(null,"No hay datos a eliminar");
		}
	
	}

}
