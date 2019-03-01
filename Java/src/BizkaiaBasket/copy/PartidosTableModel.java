package BizkaiaBasket.copy;


import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class PartidosTableModel extends AbstractTableModel { // Modelo de tabla para mostrar en ventana de gestión y visualización de partidos en cualquier ventana
	
	// Variables	
	private static final long serialVersionUID = 1L;
	private ArrayList<Partido> partidos;
	
	public PartidosTableModel() {  // Constructor principal
		
		partidos = new ArrayList<Partido>();
		
		Partido p1 = new Partido();  		// Nuevo partido p1
		p1.codigo = 001;				
		p1.equipoloc = "C.B. PADURA";				
		p1.equipovis = "PAULES";
		p1.fecha = "10/02/2019";
		p1.faltasloc = 0;		
		p1.faltasvis = 0;		
		p1.triplesloc = 0;	
		p1.triplesvis = 0;		
		p1.puntosloc = 0;		
		p1.puntosvis = 0;		
		
		Partido p2 = new Partido();  		// Nuevo partido p2
		
		p2.codigo = 001;				
		p2.equipoloc = "PAULES";				
		p2.equipovis = "JARRILLEROS S.K.";
		p1.fecha = "17/02/2019";
		p2.faltasloc = 6;		
		p2.faltasvis = 2;		
		p2.triplesloc = 3;	
		p2.triplesvis = 5;		
		p2.puntosloc = 47;		
		p2.puntosvis = 65;	

		
		partidos.add(p1);					// Insertamos en el arraylist los partidos
		partidos.add(p2);			
	}
	
	@Override
	public int getColumnCount() {
		
		return 9;				// Serán nueve columnas
		
		// return Usuario.class.getDeclaredFields().length;  // Calcula cuantos campos tiene (atributos o vartiables) tiene la clase Partido;
		
	}

	@Override
	public int getRowCount() {
		
		return partidos.size(); // Devuelve cuantos partidos hay almacenados para generar las filas de la tabla
		
	}

	@Override
	public Object getValueAt(int fila, int columna) {  // Inserta datos en la tablas

		Object valor = null; // Object puede recoger cualquier tipo de dato
		
		Partido partido = partidos.get(fila);
		
		switch (columna) {
		
			case 0:
				
				valor = partido.codigo;
				
				break;
			
			case 1:
				
				valor = partido.equipoloc;
				
				break;
				
			case 2:
				
				valor = partido.equipovis;
				
				break;
			
			case 3:
				
				valor = partido.faltasloc;
				
				break;
			case 4:
				
				valor = partido.faltasvis;
				
				break;
			
			case 5:
				
				valor = partido.triplesloc;
				
				break;
				
			case 6:
				
				valor = partido.triplesvis;
				
				break;
			
			case 7:
				
				valor = partido.puntosloc;
				
				break;
				
			case 8:
				
				valor = partido.puntosvis;
				
				break;
		
		
		}
		
		return valor;
		
	}
	
	
	public Partido getPartido(int codigo) { // Comprueba que el partido tecleado existe en el ArrayList partidos
		
		for(Partido match:partidos) {
			
			if (match.codigo == codigo) {
				
				return match; // y lo devuelve
			}
			
		}
		
		return null;		// Si no lo encuentra, devuelve null
		
	}
	
	public void CrearPartido(Integer codigo, String equipoloc, String equipovis, String fecha, Integer faltasloc, Integer faltasvis, Integer triplesloc, Integer triplesvis, Integer puntosloc, Integer puntosvis) {

		if (getPartido(codigo) == null) {
			
			//Cargarse este caso si no se van a añadir jugaodes
			Partido part = new Partido();
			part.codigo = codigo;
			part.equipoloc = equipoloc;
			part.equipovis = equipovis;
			part.fecha = fecha;
			part.faltasloc = faltasloc;
			part.faltasvis = faltasvis;
			part.triplesloc = triplesloc;
			part.triplesvis = triplesvis;
			part.puntosloc = puntosloc;
			part.puntosvis = puntosvis;

			partidos.add(part);

			fireTableDataChanged();
		
		}
		else {
			JOptionPane.showMessageDialog(null,"El partido " + codigo + "  ya existe.");
		}
	
	}
	

}
