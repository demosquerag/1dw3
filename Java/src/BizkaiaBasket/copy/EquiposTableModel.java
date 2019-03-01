package BizkaiaBasket.copy;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class EquiposTableModel extends AbstractTableModel { // Modelo de tabla para mostrar en ventana de gestión y visualización de usuarios en cualquier ventana
	
	// Variables
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Equipo> equipos;
	
	public EquiposTableModel() {  // Constructor principal
		
		equipos = new ArrayList<Equipo>();
		
		Equipo cbpadura = new Equipo();  		// Usuario admin de tipo Usuario
		Equipo paules = new Equipo();  		// Usuario usuario de tipo Usuario
		Equipo jarrilleros = new Equipo(); 	// Usuario observador de tipo Usuario
		
		cbpadura.codigo = 001;				// Usuario
		cbpadura.nombre = "C.B. PADURA";				// Contraseña
		cbpadura.municipio = "Arrigorriaga";
		cbpadura.email = "padura@bizkaiabasket.com";
		cbpadura.terreno = "UDAL KIROLDEGIA";
		
		paules.codigo = 002;				// Usuario
		paules.nombre = "PAULES";				// Contraseña
		paules.municipio = "Barakaldo";
		paules.email = "paules@bizkaiabasket.com";
		paules.terreno = "COLEGIO PAULES";
		
		jarrilleros.codigo = 003;				// Usuario
		jarrilleros.nombre = "JARRILLEROS S.K.";				// Contraseña
		jarrilleros.municipio = "Portugalete";
		jarrilleros.email = "jarrilleros@bizkaiabasket.com";
		jarrilleros.terreno = "POL.PANDO AISIA";
		
		equipos.add(cbpadura);					// Insertamos en usuario en el arrayList los usuarios con sus datos de login
		equipos.add(paules);			
		equipos.add(jarrilleros);			
	}
	
	

	@Override
	public int getColumnCount() {
		
		return 5;				// Serán dos columnas
		
		// return Usuario.class.getDeclaredFields().length;  // Calcula cuantos campos tiene (atributos o vartiables) tiene la clase Usuario;
		
	}

	@Override
	public int getRowCount() {
		
		return equipos.size(); // Duelve cuantos usuarios hay almacenados para generar las filas de la tabla
		
	}

	@Override
	public Object getValueAt(int fila, int columna) {  // Inserta datos en la tablas

		Object valor = null; // Object puede recoger cualquier tipo de dato
		
		Equipo equipo = equipos.get(fila);
		
		switch (columna) {
		
			case 0:
				
				valor = equipo.codigo;
				
				break;
			
			case 1:
				
				valor = equipo.nombre;
				
				break;
				
			case 2:
				
				valor = equipo.municipio;
				
				break;
				
			case 3:
				
				valor = equipo.email;
				
				break;
				
			case 4:
				
				valor = equipo.terreno;
				
				break;
				
				
		
		}
		
		return valor;
		
	}
	
	
	public Equipo getEquipo(int cod) { // Comprueba que el equipo tecleado existe en el ArrayList equipos
		
		for(Equipo team:equipos) {
			
			if (team.codigo == cod) {
				
				return team; // y lo devuelve
			}
			
		}
		
		return null;		// Si no lo encuentra, devuelve null
		
	}
	
	public void CrearEquipo(int codigo, String nombre, String municipio, String email, String terreno) {
		
		
		if (getEquipo(codigo) == null) {
		Equipo equipo = new Equipo();

		equipo.codigo = codigo;				
		equipo.nombre = nombre;				
		equipo.municipio = municipio;
		equipo.email = email;
		equipo.terreno = terreno;
		
		equipos.add(equipo);
		
		fireTableDataChanged();
		}
		else {
			JOptionPane.showMessageDialog(null,"El Equipo " + nombre + "  ya existe.");
		}

	}
	

}
