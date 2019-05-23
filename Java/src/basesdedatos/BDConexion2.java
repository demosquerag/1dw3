package basesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BDConexion2 {

	public static void main(String[] args) {
		
		// Arraylist
		ArrayList<Usuarios> usuario = new ArrayList<>();
		
		try {
			// Conectar a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
			// Salida por consola
			System.out.println("Conexion correcta.");
			System.out.println("---------- ---------- ---------- ----------");
			// Creo un statement
			Statement st = conexion.createStatement();
			// Preparo una consulta
			String consulta = "SELECT username,password,nombre,apellidos,telefono,email,tipo FROM usuarios";
			// Ejecuto la consulta
			ResultSet rs = st.executeQuery(consulta);
			// RECORRO LOS REGISTROS DEVUELTOS
			while (rs.next()){
				System.out.println("Usuario: " + rs.getObject("username") + ", Tipo: " + rs.getObject("tipo") + ".");
				// Nuevo usuario
				Usuarios valor = new Usuarios();
				valor.setUsername(rs.getObject("username").toString());
				valor.setPassword(rs.getObject("password").toString());
				valor.setNombre(rs.getObject("nombre").toString());
				valor.setApellidos(rs.getObject("apellidos").toString());
				valor.setTelefono(rs.getInt("telefono"));
				valor.setEmail(rs.getObject("email").toString());
				valor.setTipo(rs.getObject("tipo").toString());
				// Comprobar si la persona existe e insertarla
				if (!usuario.contains(valor)) {
					// AÑADIR LA CADENA AL ARRAYLIST
					usuario.add(valor);
					// Salida por consola					
					System.out.println("La persona ( "+valor+" ) se ha añadido.");
				}
				else {
					System.out.println("Esa persona ya existe.");
				}
				
			}
			
			// cierro el ResultSet
			rs.close();
			// cierro el Statement despues de realizar la consulta
			st.close();
			// Cierro conexion
			conexion.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
		
		
		System.out.println("---------- ---------- ---------- ----------");
		for (int i = 0; i < usuario.size(); i++) {
			if (usuario.get(i).getNombre().equals("Administrador")) {
				System.out.println(usuario.get(i));
			}
		}
		
	}

}
