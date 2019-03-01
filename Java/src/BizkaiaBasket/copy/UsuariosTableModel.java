package BizkaiaBasket.copy;

import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class UsuariosTableModel extends AbstractTableModel { // Modelo de tabla para mostrar en ventana de gestiï¿½n y visualizaciï¿½n de usuarios en cualquier ventana
	
	// Variables
	
	private static final long serialVersionUID = 1L;
	private ArrayList<Usuario> usuarios;
	
	public UsuariosTableModel() {  // Constructor principal
		
		usuarios = new ArrayList<Usuario>();

		Administrador admin = new Administrador();  		// Usuario admin de tipo Usuario
		Usuario usuario = new Usuario();  		// Usuario usuario de tipo Usuario
		Observador observador = new Observador(); 	// Usuario observador de tipo Usuario
		
		admin.usuario = "Admin";				// Usuario
		admin.password = "admin";				// Contraseï¿½a
		usuario.usuario = "Usuario";		
		usuario.password = "usuario";		
		observador.usuario = "Observador";		
		observador.password = "";		
		
		usuarios.add(admin);					// Insertamos en usuario en el arrayList los usuarios con sus datos de login
		usuarios.add(usuario);			
		usuarios.add(observador);			
	}
	
	@Override
		public String getColumnName(int columna) { // Recoge el título de cada columna por posición 0-3

			switch (columna) {
			
				case 0:
					
					return "Usuario";
				
				case 1:
					
					return "Contraseña";
					
				case 2: 
					
					return "Tipo";
	
			}
			return null;
		}
	

	@Override
	public int getColumnCount() { // Recoge la cantidad de columnas
		
		return 3;				// Serían tres columnas
		
		// return Usuario.class.getDeclaredFields().length;  // Calcula cuantos campos tiene (atributos o vartiables) tiene la clase Usuario;
		
	}

	@Override
	public int getRowCount() { // Recoge la cantidad de filas (usuarios en el arraylist)
		
		return usuarios.size(); // Duelve cuantos usuarios hay almacenados para generar las filas de la tabla
		
	}

	@Override
	public Object getValueAt(int fila, int columna) {  // Inserta datos en la tablas

		//Object valor = null; // Object puede recoger cualquier tipo de dato
		
		Usuario usuario = usuarios.get(fila);
		
		switch (columna) {
		
			case 0: // Recoge el dato de la columna 1 (El nombre de usuario).
				
				return usuario.usuario;
			
			case 1: // Recoge el dato de la columna 2 (La contraseña de usuario).
				
				return usuario.password;
			
			case 2: // Recoge el dato de la columna 3 (El tipo de usuario).
				
				// Todos son un usuario por la herencia, se comprueba de la clase que más hereda a la que menos.
				if (usuario instanceof Administrador) { // Si es Administrador
					return "Administrador"; // Muestra "Administrador" como dato en la tabla
				}
				
				else if (usuario instanceof Observador) { // Si es Observador
					return "Observador"; // Muestra "Observador" como dato en la tabla
				}
				
				else {					// Si es Usuario
					return "Usuario";	// Muestra "Usuario" como dato en la tabla
				}

		}
		
		return null;
		
	}
	
	// Sobrecarga de método getUsuario(); (para utilizar en la selección de un usuario de la tabla).
	public Usuario getUsuario(int fila)
	{
		if (fila >= 0 && fila < usuarios.size()) { // Para cualquier objeto dentro del arraylist
			return usuarios.get(fila); // devuelve el objeto de la fila seleccionada
		}
		
		return null;			// Fuera del rango del arraylist, devuelve null.
	}
	
	public Usuario getUsuario(String usuario) { // Comprueba que el usuario tecleado existe en el ArrayList usuarios
		
		for(Usuario user:usuarios) {
			if (user.usuario.equals(usuario)) {
				
				return user; // y lo devuelve
			}
		}
		
		return null;		// Si no lo encuentra, devuelve null
	}

	public void EliminarUsuario(int fila)
	{
		if (!usuarios.get(fila).usuario.equals("Admin")) // Si no es Admin
		{
			usuarios.remove(fila);						// Se elimina la fila
		}
		else
		{
			// Mostramos mensaje de error, ya que el Admin inicial no puede ser eliminado
			JOptionPane.showMessageDialog(null, "No se puede eliminar el usuario \"Admin\".");
			return;	// Finalizamos el método para evitar recargar la tabla mostrada
		}
		
		fireTableDataChanged();							// Forzamos la actualización de la tabla a mostrar
	}
	

	public void CrearUsuario(String usuario, String password, String tipoUsuario) {

		if (getUsuario(usuario) == null)
		{
			switch (tipoUsuario){
				//Cargarse este caso si no se van a añadir administradores.
				case "A":
					Administrador admin = new Administrador();
					admin.usuario = usuario;
					admin.password = password;

					usuarios.add(admin);
					break;
				case "U":
					Usuario user = new Usuario();
					user.usuario = usuario;
					user.password = password;

					usuarios.add(user);
					break;
				//default:
					
				case "V":
					Observador observador = new Observador();
					observador.usuario = usuario;
					observador.password = password;

					usuarios.add(observador);
					break;
			}

			fireTableDataChanged();		// Forzamos la actualización de la tabla a mostrar
		}
		else
		{
			JOptionPane.showMessageDialog(null,"El usuario " + usuario + "  ya existe.");
		}
	}

	public void ModificarUsuario(int fila, String usuario, String password) {
		
		Usuario user = usuarios.get(fila);

		if (!user.usuario.equals("Admin")) // Si el usuario no es admin
		{
			if (password.isEmpty() && !(user instanceof Observador))		// Si recogemos una contraseña vacía y el usuario es diferente a observador
			{	// Mostramos mensaje de error sobre contraseñas vacías
				JOptionPane.showMessageDialog(null, "Solo los observadores pueden contener contraseñas vacias.");
				return; // Finalizamos el método para evitar recargar la tabla mostrada
			}
			else if (!password.equals(user.password)){ // SI la contraseña que recogemos es diferente a la almacenada en el arraylist
				user.password = password; // Modificamos la contraseña del arraylist
			}
			
			if (!usuario.equals(user.usuario)) // Si el nombre de usuario en el arraylist no es el mismo que el recogido
			{
				user.usuario = usuario; // Modificamos el Nombre de usuario del arraylist
			}
		}
		else		// SI se intenta modificar el usuario Admin
		{	
			// Mostramos mensaje de error, ya que el Admin inicial no puede ser modificado
			JOptionPane.showMessageDialog(null, "No se puede modificar el usuario \"Admin\".");
			return;	// Finalizamos el método para evitar recargar la tabla mostrada
		}
		
		fireTableDataChanged();	// Forzamos la actualización de la tabla a mostrar
	}
}
