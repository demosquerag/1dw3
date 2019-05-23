package basesdedatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.sql.rowset.CachedRowSet;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;

public class VentanaJTableAlumnosInsertar extends JFrame {

	private static final long serialVersionUID = -9077118071788019311L;
	private static JPanel Contenedor;
	private JLabel lblTexto;
	private JButton btnSalir;
	private DefaultTableModel dtmTabla;
	private JTable tabla;
	private JButton btnInsertar;
	private JPanel panel;
	boolean modificado = false;
	Connection conexion = null;
	CachedRowSet crs;
	ResultSet rs;
	Vector <String> columnas;
	Vector<Vector<String>> datosTabla;
	private JButton btnActualizarTabla;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJTableAlumnosInsertar frame = new VentanaJTableAlumnosInsertar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaJTableAlumnosInsertar() {
		setTitle("VentanaJTableAlumnosInsertar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Contenedor = new JPanel();
		Contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		Contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(Contenedor);
		
		lblTexto = new JLabel("Datos de los Alumnos");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		Contenedor.add(lblTexto, BorderLayout.NORTH);
		
		panel = new JPanel();
		Contenedor.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnSalir = new JButton("Salir");
		panel.add(btnSalir);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnInsertarAlumno();
			}
		});
		panel.add(btnInsertar);
		
		btnActualizarTabla = new JButton("ActuTabla");
		btnActualizarTabla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnActualizarTabla();
			}
		});
		panel.add(btnActualizarTabla);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Exit();
			}
		});
	
		//abro la concexion conectarse a MySQL
		try {
			// me conecto usando una conexion
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			//creo un Statement st = conexion.createStatement();
			Statement st = conexion.createStatement();
			//preparo la cosulta
			String Consulta = "SELECT * FROM alumnos";
			//ejecuto la consulta 
			ResultSet rs = st.executeQuery(Consulta);
			
			// cabeceras de las columnas
			ResultSetMetaData metaDatos = rs.getMetaData();
			// Se obtiene el número de columnas.
			int numeroColumnas = metaDatos.getColumnCount();
			columnas = new Vector<String>();
			// Se obtiene cada una de las etiquetas para cada columna
			for (int i = 0; i < numeroColumnas; i++){
			// cojo el valor de la etiqueta de la columna
			// los índices del rs empiezan en 1 pero los índices de las columnas empiezan en 0
			columnas.add(metaDatos.getColumnLabel(i + 1));
			}
			// creo el vector para los datos de la tabla
			datosTabla = new Vector<Vector<String>>();
			// añado uno a uno los alumnos al vector de datos
			while (rs.next()) {
				Vector<String> fila = new Vector<String>();
				fila.add(rs.getString("dni"));
				fila.add(rs.getString("nombre"));
				fila.add(rs.getString("apellidos"));
				fila.add(rs.getString("grupo"));
				fila.add("\n\n\n\n\n\n\n");
				datosTabla.add(fila);
			}
			// cierro el ResultSet
			rs.close();
			// cierro el Statement despues de realizar la consulta
			st.close();
			// cierro la conexion con la base de datos
			conexion.close();		
			// creo la JTable
			dtmTabla = new DefaultTableModel(datosTabla, columnas){
				private static final long serialVersionUID = -5029586722185735524L;
				@Override
				public boolean isCellEditable(int row, int column) {
				// hago que todas las celdas de la tabla NO sean editables
				return false;
				}
			};
			
			tabla = new JTable(dtmTabla);
			
			// creo el Scroll panel y le añado la tabla
			JScrollPane scrollPane = new JScrollPane(tabla);
			// añado el Scroll panel al panel principal
			Contenedor.add(scrollPane, BorderLayout.CENTER);
			
			// Podemos ordenar el contenido de la tabla de varias formas
			tabla.setAutoCreateRowSorter(true);
			tabla.getTableHeader().setReorderingAllowed(false);
			
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
				
	}
	
	public void Exit() {
		// Cerrar aplicacion
		dispose();
	}
	
	public void btnInsertarAlumno() {
		try{
			// Conectar a la base de datos
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// creo un Statement st = conexion.createStatement();
			Statement st = conexion.createStatement();
			// Crear los strings
			String dni = "00000000A";
			String nombre = "N0";
			String apellidos = "A0";
			String grupo = "1DW3";
			String Consulta = "INSERT INTO alumnos VALUES ('"+dni+"','"+nombre+"','"+apellidos+"','"+grupo+"')";
			//ejecuto la consulta 
			st.executeUpdate(Consulta);
			System.out.println(Consulta);
			// cierro el Statement despues de realizar la consulta
			st.close();
			// cierro la conexion con la base de datos
			conexion.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(Contenedor,(String)"Error. No se ha podido añadir el registro","Error",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	public void btnActualizarTabla() {
		//Mostrar la tabla Entera como al principio
	}
		
}

