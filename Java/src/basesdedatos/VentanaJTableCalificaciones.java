package basesdedatos;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class VentanaJTableCalificaciones extends JFrame {

	private static final long serialVersionUID = -9077118071788019311L;
	private static JPanel Contenedor;
	private JLabel lblTexto;
	private JButton btnSalir;
	private DefaultTableModel dtmTabla;
	private JTable tabla;
	private TableRowSorter<TableModel> metodoOrdenacion;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJTableCalificaciones frame = new VentanaJTableCalificaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public VentanaJTableCalificaciones() {
		setTitle("VentanaJTableCalificaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		Contenedor = new JPanel();
		Contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		Contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(Contenedor);
		
		lblTexto = new JLabel("Datos de los Alumnos");
		lblTexto.setHorizontalAlignment(SwingConstants.CENTER);
		Contenedor.add(lblTexto, BorderLayout.NORTH);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Exit();
			}
		});
		Contenedor.add(btnSalir, BorderLayout.SOUTH);
	
		//abro la concexion (conectarse a MySQL
		try {
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// si se ha conectado correctamente
			// System.out.println("Conexión Correcta.");
			
			//creo un Statement st = conexion.createStatement();
			Statement st = conexion.createStatement();
			//preparo la cosulta
			String Consulta = "SELECT * FROM calificaciones";
			//ejecuto la consulta 
			ResultSet rs = st.executeQuery(Consulta);
			
			// cabeceras de la tabla columnas
			Vector <String> columnas = new Vector<String>();
			columnas.add("DNI");
			columnas.add("Codigo Asignatura");
			columnas.add("Nota");
			
			// creo el vector para los datos de la tabla
			Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
			// añado uno a uno los alumnos al vector de datos
			while (rs.next()) {
				Vector<String> fila = new Vector<String>();
				fila.add(rs.getString("dni"));
				fila.add(rs.getString("codasignatura"));
				fila.add(rs.getString("nota"));
				fila.add("\n\n\n\n\n\n\n");
				datosTabla.add(fila);
			}
			// cierro el ResultSet
			rs.close();
			// cierro el Statement despues de realizar la consulta
			st.close();
			// cierro la conexion
			//cierro la conexion 
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
			// Después de crear la tabla
			// Instanciamos el TableRowSorter y lo añadimos al JTable
			metodoOrdenacion = new TableRowSorter<TableModel>(dtmTabla);
			tabla.setRowSorter(metodoOrdenacion);
			// A partir de aquí podemos definir un filtro basado en metodoOrdenacion
			// cambio el filtro de la tabla de calificaciones
			metodoOrdenacion.setRowFilter(RowFilter.regexFilter("11111111A", 0));
			
			// creo el Scroll panel y le añado la tabla
			JScrollPane scrollPane = new JScrollPane(tabla);
			// añado el Scroll panel al panel principal
			Contenedor.add(scrollPane, BorderLayout.CENTER);
			
			// Podemos ordenar el contenido de la tabla de varias formas
			// tabla.setAutoCreateRowSorter(true);		
			} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void Exit() {
		// Salir de la aplicacion
		// VentanaJTableRowSet vl = new VentanaJTableRowSet();
		// vl.setVisible(false);
		dispose();
	}
}

