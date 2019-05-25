package basesdedatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class BDUpdateAlumnoRowset {

	public static void main(String[] args) {
		Connection conexion;
		boolean modificado;
		
		// Separar acciones
		System.out.println("---------- ---------- ---------- ---------- ---------- ----------");
		System.out.println("---------- ----- Vizualizar tabla no actualizada ----- ----------");
		// Modificar los datos pedidos
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root","");
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(false);
			// creo el CachedRowSet
			CachedRowSet crs;
			RowSetFactory myRowSetFactory = null;
			myRowSetFactory = RowSetProvider.newFactory();
			crs = myRowSetFactory.createCachedRowSet();
			// selecciono todos los alumnos
			// usando la conexion anterior
			crs.setCommand("SELECT * FROM alumnos");
			crs.execute(conexion);
			// cierro la conexion con la base de datos
			conexion.close();
			
			// RECORRO LOS REGISTROS DEVUELTOS
			while (crs.next()){
				System.out.println("DNI: " + crs.getObject("dni") + ", nombre: " + crs.getObject("nombre") + ", Apellidos: " + crs.getObject("apellidos") + ", Grupo: " + crs.getObject("grupo"));
			}
			
			// Crear un string con el nuevo valor
			String valor ="2DW3";
			// actualizo en el crs el valor del grupo que está en la columna 4
			// del registro que está en la primera posicion
			crs.absolute(1);
			crs.updateString(4, valor);
			crs.updateRow();
			// actualizo el valor de modificado
			modificado = true;
			
			// Guardar los cambios realizados en el CachedRowset a la base de datos
			if (modificado){
				try{
					// Class.forName("com.mysql.jdbc.Driver");
					conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
					// si se ha conectado correctamente
					// desactivo la actualizacion automatica de datos
					conexion.setAutoCommit(false);
					crs.acceptChanges(conexion);
				} catch (SQLException sqle) {
				// JOptionPane.showMessageDialog(contenedor,(String)"Error. No se han podido grabar los datos","Error",JOptionPane.ERROR_MESSAGE,null);
				}
			}
			// Cerrar CachedRowSet
			crs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Se ha producido un error.");
		}
		
		// Separar acciones
		System.out.println("---------- ---------- ---------- ---------- ---------- ----------");
		System.out.println("---------- ------ Vizualizar tabla actualizada ------- ----------");
		
		// Visualizar la tabla con el/los dato/s actualizado/s
		try {
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root","");
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(false);
			// creo el CachedRowSet
			CachedRowSet crs;
			RowSetFactory myRowSetFactory = null;
			myRowSetFactory = RowSetProvider.newFactory();
			crs = myRowSetFactory.createCachedRowSet();
			// selecciono todos los alumnos
			// usando la conexion anterior
			crs.setCommand("SELECT * FROM alumnos");
			crs.execute(conexion);
			// cierro la conexion con la base de datos
			conexion.close();
			
			// RECORRO LOS REGISTROS DEVUELTOS
			while (crs.next()){
				System.out.println("DNI: " + crs.getObject("dni") + ", nombre: " + crs.getObject("nombre") + ", Apellidos: " + crs.getObject("apellidos") + ", Grupo: " + crs.getObject("grupo"));
			}
			
			// Cerrar CachedRowSet
			crs.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Se ha producido un error.");
		}
		
	}

}
