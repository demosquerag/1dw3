package basesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BDConexion2 {

	public static void main(String[] args) {
		
		try {
			
			// Conectar a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
			
			// Salida por consola
			System.out.println("Conexion correcta.");
			
			// Creo un statement
			Statement st = conexion.createStatement();
						
			// Preparo una consulta
			String consulta = "SELECT * FROM usuarios";
			// Ejecuto la consulta
			ResultSet rs = st.executeQuery(consulta);
			// RECORRO LOS REGISTROS DEVUELTOS
			while (rs.next()){
				System.out.println("Nick: " + rs.getObject("nickname") + ", Nombre: " + rs.getObject("nombre") + ", Apellidos: " + rs.getObject("apellidos") + ", Tipo: " + rs.getObject("tipo"));
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
