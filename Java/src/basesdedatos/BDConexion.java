package basesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BDConexion {

	public static void main(String[] args) {
		
		try {
			
			// Conectar a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			
			// Salida por consola
			System.out.println("Conexion correcta.");
			
			// Creo un statement
			Statement st = conexion.createStatement();
			
			// Preparo una consulta
			String consulta = "SELECT * FROM alumnos";
			// Ejecuto la consulta
			ResultSet rs = st.executeQuery("SELECT * FROM alumnos");
			// RECORRO LOS REGISTROS DEVUELTOS
			while (rs.next()){
				System.out.println("DNI: " + rs.getObject("dni") + ", nombre: " + rs.getObject("nombre") + ", Apellidos: " + rs.getObject("apellidos") + ", Grupo: " + rs.getObject("grupo"));
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
		
	}

}
