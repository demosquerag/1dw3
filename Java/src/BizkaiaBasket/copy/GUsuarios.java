package BizkaiaBasket.copy;

//import java.util.ArrayList;


public class GUsuarios {
	
	static Usuario usuarioActivo;
	static UsuariosTableModel usuarios = new UsuariosTableModel();

	static String Login(String usuario, String password) {
		Usuario user = usuarios.getUsuario(usuario);

		// Si el nombre de usuario existe:
		if (user != null)
		{
			// Si la contrase√±a es correcta:
			if (user.password.equals(password))
			{
				// Login correcto.
				usuarioActivo = user;
				return "OK";
			}

			// La contrase√±a no es correcta
			return "La contrase√±a no es correcta.";
		}

		// El usuario no existe.
		return "No se ha encontrado el usuario " + usuario + ".";
	}

	static void Logout() {
		usuarioActivo = null;
		AbrirVentanas.cerrar();
	}

	static void IrAPrincipal() {
		usuarioActivo.AbrirPrincipal();
	}

	static void CrearUsuario(String usuario, String password, String tipoUsuario) {
		usuarios.CrearUsuario(usuario, password, tipoUsuario);
	}

	public static void EliminarUsuario(int fila) {
		// Si hay seleccionado un usuario, se llama al metodo de eliminar usuarios.
		if (fila != -1) // Si no hay seleccionado, devuelve -1. Por lo tanto aquÌ se comprueba si est· seleccionado.
		{
			usuarios.EliminarUsuario(fila);
		}
	}

	public static void ModificarUsuario(int fila, String usuario, String password) {
		// Si hay seleccionado un usuario, se llama al metodo de modificar usuarios.
		if (fila != -1) // Si no hay seleccionado, devuelve -1. Por lo tanto aquÌ se comprueba si est· seleccionado.
		{
			usuarios.ModificarUsuario(fila, usuario, password);
		}
	}
	
}
