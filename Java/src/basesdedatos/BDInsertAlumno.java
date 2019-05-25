package basesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BDInsertAlumno {

	public static void main(String[] args) {
		
		try {
			
			// Conectar a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			
			// Salida por consola
			System.out.println("Conexion correcta.");
			
			// Creo un statement
			Statement st = conexion.createStatement();
			
			// Preparo una consulta
			String consulta = "INSERT INTO alumnos VALUES ('12345678A', 'Nuevo', 'Alumno', '1AS3')";
			// Ejecuto la consulta
			st.executeUpdate(consulta);
			// cierro el Statement despues de realizar la consulta
			st.close();
			// Creo un nuevo statement
			Statement st2 = conexion.createStatement();
			// Preparo una consulta
			String consulta2 = "SELECT * FROM alumnos";
			// Ejecuto la consulta
			ResultSet rs = st2.executeQuery(consulta2);
			// RECORRO LOS REGISTROS DEVUELTOS
			while (rs.next()){
				System.out.println("DNI: " + rs.getObject("dni") + ", nombre: " + rs.getObject("nombre") + ", Apellidos: " + rs.getObject("apellidos") + ", Grupo: " + rs.getObject("grupo"));
			}
			// cierro el Statement despues de realizar la consulta
			st.close();
			// cierro el ResultSet
			rs.close();
			// Cierro conexion
			conexion.close();
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.out.println("Se ha producido un error.");
		}

	}

}
