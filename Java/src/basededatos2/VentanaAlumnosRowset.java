package basededatos2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaAlumnosRowset extends JFrame {

	// Necesidades previas
	private static final long serialVersionUID = -6750350292260968293L;
	private JPanel contenedor;
	private JPanel pnlBotones;
	private JPanel pnlTabla;
	private JScrollPane scpAlumnos;
	private JTable tblAlumnos;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtGrupo;
	private JLabel lblTitulo;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblGrupo;
	private JButton bntGuardar;
	private JButton btnEliminar;
	private JButton bntModificar;
	private JButton bntActualizar;
	private DefaultTableModel dtmTabla;
	private CachedRowSet crs;
	private boolean modificado = false;
	

	// Main-Inicializador de la ventana
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAlumnosRowset frame = new VentanaAlumnosRowset();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public VentanaAlumnosRowset() {
		setResizable(false);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 591, 350);
		contenedor = new JPanel();
		contenedor.setBackground(Color.WHITE);
		contenedor.setBorder(null);
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
		
		lblTitulo = new JLabel("Datos de los alumnos");
		lblTitulo.setBackground(Color.WHITE);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 14));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		contenedor.add(lblTitulo, BorderLayout.NORTH);
		
		pnlBotones = new JPanel();
		pnlBotones.setBackground(Color.WHITE);
		pnlBotones.setBorder(null);
		contenedor.add(pnlBotones, BorderLayout.SOUTH);
		pnlBotones.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		bntGuardar = new JButton("Guardar");
		bntGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnInsertarAlumnos();
			}
		});
		bntGuardar.setBackground(Color.WHITE);
		pnlBotones.add(bntGuardar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEliminarAlumnos();
			}
		});
		btnEliminar.setBackground(Color.WHITE);
		pnlBotones.add(btnEliminar);
		
		bntModificar = new JButton("Modificar");
		bntModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnModificarAlumnos();
			}
		});
		bntModificar.setBackground(Color.WHITE);
		pnlBotones.add(bntModificar);
		
		bntActualizar = new JButton("Actualizar");
		bntActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Guardar la modificacion en el CachedRowSet
				JTableActualizarCachedRowset();
			}
		});
		bntActualizar.setBackground(Color.WHITE);
		pnlBotones.add(bntActualizar);
		
		pnlTabla = new JPanel();
		pnlTabla.setBorder(null);
		pnlTabla.setBackground(Color.WHITE);
		contenedor.add(pnlTabla, BorderLayout.CENTER);
		pnlTabla.setLayout(null);
		
		scpAlumnos = new JScrollPane();
		scpAlumnos.setBounds(61, 5, 453, 185);
		pnlTabla.add(scpAlumnos);
		
		tblAlumnos = new JTable();
		tblAlumnos.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JTableToJTextField();
			}
		});
		tblAlumnos.setBackground(Color.WHITE);
		scpAlumnos.setViewportView(tblAlumnos);
		
		txtDni = new JTextField();
		txtDni.setBounds(61, 222, 114, 20);
		pnlTabla.add(txtDni);
		txtDni.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(192, 222, 114, 20);
		pnlTabla.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellidos = new JTextField();
		txtApellidos.setBounds(324, 222, 114, 20);
		pnlTabla.add(txtApellidos);
		txtApellidos.setColumns(10);
		
		txtGrupo = new JTextField();
		txtGrupo.setBounds(454, 222, 60, 20);
		pnlTabla.add(txtGrupo);
		txtGrupo.setColumns(10);
		
		lblDni = new JLabel("DNI");
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setBounds(90, 202, 55, 16);
		pnlTabla.add(lblDni);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(224, 202, 55, 16);
		pnlTabla.add(lblNombre);
		
		lblApellidos = new JLabel("Apellidos");
		lblApellidos.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellidos.setBounds(352, 202, 55, 16);
		pnlTabla.add(lblApellidos);
		
		lblGrupo = new JLabel("Grupo");
		lblGrupo.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrupo.setBounds(456, 202, 55, 16);
		pnlTabla.add(lblGrupo);
		
		
		// Try- Catch para mostrar la tabla
		// Abro la concexion conectarse a MySQL
		try {
			// Creo la conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// Si se ha conectado correctamente 
			// System.out.println("Conexión Correcta.");
			
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(false);
			// creo el CachedRowSet
			RowSetFactory myRowSetFactory = null;
			myRowSetFactory = RowSetProvider.newFactory();
			crs = myRowSetFactory.createCachedRowSet();
			// selecciono todos los alumnos
			// usando la conexion anterior
			crs.setCommand("SELECT * FROM alumnos");
			crs.execute(conexion);
			
			// Cabeceras de la tabla columnas
			Vector <String> columnas = new Vector<String>();
			columnas.add("DNI");
			columnas.add("Nombre");
			columnas.add("Apellidos");
			columnas.add("Grupo");
			
			// Creo el vector para los datos de la tabla
			Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
			
			// Agrego uno a uno los alumnos al vector de datos
			while (crs.next()) {
				Vector<String> fila = new Vector<String>();
				fila.add(crs.getString("dni"));
				fila.add(crs.getString("nombre"));
				fila.add(crs.getString("apellidos"));
				fila.add(crs.getString("grupo"));
				fila.add("\n\n\n\n\n\n\n");
				datosTabla.add(fila);
			}
			
			// Cierro el ResultSet
			crs.close();
			// Cierro la conexion
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
			tblAlumnos.setModel(dtmTabla);
			// Podemos ordenar el contenido de la tabla de varias formas
			tblAlumnos.setAutoCreateRowSorter(true);
			tblAlumnos.getTableHeader().setReorderingAllowed(false);
		  				
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
		
	}
	
	// Metodo para recoger los datos de la JTable y pasarlos a JTextFields
	private void JTableToJTextField() {
		// Necesidades previas
		int rec = this.tblAlumnos.getSelectedRow();
		// Llenar los campos
		this.txtDni.setText(tblAlumnos.getValueAt(rec, 0).toString());
		this.txtNombre.setText(tblAlumnos.getValueAt(rec, 1).toString());
		this.txtApellidos.setText(tblAlumnos.getValueAt(rec, 2).toString());
		this.txtGrupo.setText(tblAlumnos.getValueAt(rec, 3).toString());
	}
	
	// Metodo para actualizar la tabla con los datos
	private void JTableActualizarJtable() {
		try {
			// Creo la conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// Si se ha conectado correctamente 
			// System.out.println("Conexión Correcta.");
			
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(false);
			// creo el CachedRowSet
			RowSetFactory myRowSetFactory = null;
			myRowSetFactory = RowSetProvider.newFactory();
			crs = myRowSetFactory.createCachedRowSet();
			// selecciono todos los alumnos
			// usando la conexion anterior
			crs.setCommand("SELECT * FROM alumnos");
			crs.execute(conexion);
			
			// Cabeceras de la tabla columnas
			Vector <String> columnas = new Vector<String>();
			columnas.add("DNI");
			columnas.add("Nombre");
			columnas.add("Apellidos");
			columnas.add("Grupo");
			
			// Creo el vector para los datos de la tabla
			Vector<Vector<String>> datosTabla = new Vector<Vector<String>>();
			
			// Agrego uno a uno los alumnos al vector de datos
			while (crs.next()) {
				Vector<String> fila = new Vector<String>();
				fila.add(crs.getString("dni"));
				fila.add(crs.getString("nombre"));
				fila.add(crs.getString("apellidos"));
				fila.add(crs.getString("grupo"));
				fila.add("\n\n\n\n\n\n\n");
				datosTabla.add(fila);
			}
			
			// Cierro el ResultSet
			crs.close();
			// Cierro la conexion
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
			tblAlumnos.setModel(dtmTabla);
			// Podemos ordenar el contenido de la tabla de varias formas
			tblAlumnos.setAutoCreateRowSorter(true);
			tblAlumnos.getTableHeader().setReorderingAllowed(false);
		  				
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}
	
	// Metodo para actualizar la tabla con los datos en el CachedRowSet
	private void JTableActualizarCachedRowset() {
		if (modificado){
			try {
				// Creo la conexion
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos","root","");
				// si se ha conectado correctamente
				// desactivo la actualizacion automatica de datos
				conexion.setAutoCommit(false);
				
				// Aceptar los cambios
				crs.acceptChanges(conexion);
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Se ha producido un error");
				JOptionPane.showMessageDialog(contenedor,(String)"Error. No se han podido grabar los datos","Error",JOptionPane.ERROR_MESSAGE,null);
				JTableActualizarJtable();
			}
		}
		
	}
	
	// Metodo para limpiar los campos de texto
	private void ClearFields() {
		// Necesidades previas
		this.txtDni.setText("");
		this.txtNombre.setText("");
		this.txtApellidos.setText("");
		this.txtGrupo.setText("");
	}
	
	// Metodo insertar alumnos en la basededatos y en la tabla
	private void btnInsertarAlumnos() {
		JTableActualizarJtable();
		try {
			// añado el registro al CachedRowSet
			crs.moveToInsertRow();
			crs.updateString(1, this.txtDni.getText());
			crs.updateString(2, this.txtNombre.getText());
			crs.updateString(3, this.txtApellidos.getText());
			crs.updateString(4, this.txtGrupo.getText());
			crs.insertRow();
			crs.moveToCurrentRow();
			// actualizo el valor de modificado
			modificado = true;
			// Limpio los campos de texto
			ClearFields();
			// Guardar los cambios
			JTableActualizarCachedRowset();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
			JOptionPane.showMessageDialog(contenedor,(String)"Error. No se ha podido añadir el registro","Error",JOptionPane.ERROR_MESSAGE,null);
		}
		
	}
	
	// Metodo eliminar alumnos en la basededatos y en la tabla
	private void btnEliminarAlumnos() {
		// Conectar a la base de datos
		try {
			// Borro del crs el registro que está en la primera posición que es la posicion 1
			// Voy a la posición 1
			crs.absolute(1);
			// Borro el registro de esa posicion
			crs.deleteRow();
			// Me posiciono en el primer registro para que los cambios tengan efecto
			crs.first();
			// Actualizo el valor de modificado
			modificado = true;
			// Limpio los campos de texto
			ClearFields();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}
	
	// Metodo modificar alumnos en la basededatos y en la tabla
	private void btnModificarAlumnos() {
		// Conectar a la base de datos
		try {
			String valor ="ADW3";
			// actualizo en el crs el valor del grupo que está en la columna 4
			// del registro que está en la primera posicion
			crs.absolute(1);
			crs.updateString(4, valor);
			crs.updateRow();
			// actualizo el valor de modificado
			modificado = true;
			// Limpio los campos de texto
			ClearFields();
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}
	
}
