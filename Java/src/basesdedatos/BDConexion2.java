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
			String consulta = "SELECT usuario,tipo FROM usuarios";
			// Ejecuto la consulta
			ResultSet rs = st.executeQuery(consulta);
			// RECORRO LOS REGISTROS DEVUELTOS
			while (rs.next()){
				System.out.println("Usuario: " + rs.getObject("usuario") + ", Tipo: " + rs.getObject("tipo") + ".");
				if (rs.getObject("usuario").equals("Daniel") && rs.getObject("tipo").equals("U")) {
					System.out.println("Perfes");
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
		
	}

}
