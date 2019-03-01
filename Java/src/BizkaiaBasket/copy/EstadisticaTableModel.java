package BizkaiaBasket.copy;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class EstadisticaTableModel extends AbstractTableModel {
	
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Estadistica> estadisticas;
	
	public EstadisticaTableModel() {
		
		estadisticas = new ArrayList<Estadistica>();
		
		Estadistica A = new Estadistica();  	// Recoja los datos desde el array partidos
		
		/*A.equipo = Equipo.getNombre();
		A.faltac = 1;
		A.faltar = 2;
		A.triplec = 1;
		A.tripler = 2;*/
		
		estadisticas.add(A); // Insertamos en estadistica en el arrayList los usuarios con sus datos de login
		
	}				
	
	@Override
	public int getColumnCount() {
		
		return 5;				// Serán dos columnas
		
		// return Usuario.class.getDeclaredFields().length;  // Calcula cuantos campos tiene (atributos o vartiables) tiene la clase Usuario;
		
	}
	
	@Override
	public int getRowCount() {
		
		return estadisticas.size(); // Duelve cuantos usuarios hay almacenados para generar las filas de la tabla
		
	}
	
	@Override
	public Object getValueAt(int fila, int columna) {  // Inserta datos en la tablas

		Object valor = null; // Object puede recoger cualquier tipo de dato
		
		Estadistica est = estadisticas.get(fila);
		
		switch (columna) {
		
			case 0:
				
				valor = est.equipo;
				
				break;
			
			case 1:
				
				valor = est.faltac;
				
				break;
			
			case 2:
				
				valor = est.faltar;
				
				break;
				
			case 3:
				
				valor = est.triplec;
				
				break;
				
			case 4:
				
				valor = est.tripler;
				
				break;
		
		}		
		return valor;
		
	}
	
	public Estadistica getEstadistica(String estadi) { // Comprueba que el usuario tecleado existe en el ArrayList usuarios
		
		for(Estadistica ju:estadisticas) {
			
			if (ju.equipo.equals(estadi)) {
				
				return ju; // y lo devuelve
			}
			
		}
		
		return null;		// Si no lo encuentra, devuelve null
		
	}

}
