package basesdedatos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class BDConexion2 {

	public static void main(String[] args) {
		
		// Necesidades previas
		FileWriter fichero = null;
		PrintWriter pw = null;
		BufferedWriter bw = null;
		String ruta = "usuarios.txt";
		// leo datos desde el fichero
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
		// Arraylist
		ArrayList<Usuarios> usuario = new ArrayList<>();
		
		try {
			
			// Conectar a la base de datos
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bizkaiabasket", "root", "");
			// Salida por consola
			System.out.println("Conexion correcta.");
			// Creo un statement
			Statement st = conexion.createStatement();
			// Preparo una consulta
			String consulta = "SELECT username,password,nombre,apellidos,telefono,email,tipo FROM usuarios";
			// Ejecuto la consulta
			ResultSet rs = st.executeQuery(consulta);
			archivo = new File(ruta);
			fichero = new FileWriter(archivo);
			pw = new PrintWriter(fichero);
			bw = new BufferedWriter(pw);
			// RECORRO LOS REGISTROS DEVUELTOS
			while (rs.next()){
				System.out.println("Usuario: " + rs.getObject("username") + ", Tipo: " + rs.getObject("tipo") + ".");
				/**
				if (rs.getObject("usuario").equals("Daniel") && rs.getObject("tipo").equals("U")) {
					System.out.println("Perfes");
				}
				*/
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
			
			/**
			for (int i = 0; i < usuario.size(); i++) {
				System.out.println(usuario.get(i));
			}
			*/
			for(int i=0;i<usuario.size();i++){
		        bw.write(String.valueOf(usuario.get(i)));
		        bw.newLine();

		    }
			// cierro los recursos utilizados
			bw.close();
			pw.close();
			fichero.close();
			
			
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("--------------------- Lectura -------------------------");
		
		archivo = new File ("usuarios.txt");
		try {
			fr = new FileReader (archivo);
			br = new BufferedReader (fr);
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
			// cierro los recursos utilizados
			br.close();
			fr.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("--------------------- Muestra -------------------------");
		
		try {
			fr = new FileReader (archivo);
			br = new BufferedReader (fr);
			String firstLine = br.readLine().trim();
            String[] columnsName = firstLine.split(",");
			DefaultTableModel model = new DefaultTableModel();
            model.setColumnIdentifiers(columnsName);
            Object[] tableLines = br.lines().toArray();
            for(int i = 0; i < tableLines.length; i++)
            {
                String line = tableLines[i].toString().trim();
                String[] dataRow = line.split("/");
                model.addRow(dataRow);
            }
		} catch(Exception ex) {
			ex.printStackTrace();
			//Logger.getLogger(BDConexion2.class.getName()).log(Level.SEVERE, null, ex);
		}
		
	}

}
