package examenFinal2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class BDAlumnosCalificaciones extends JFrame {

	// Necesidades previas
	private static final long serialVersionUID = 8417722061589465918L;
	private JPanel contenedor;
	private JPanel panelNavegacion;
	private JPanel panelBotones;
	private JPanel panelInformacion;
	private JPanel panelTabla;
	private JPanel panelCampos;
	
	private JLabel lblRegistros;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JLabel lblGrupo;
	
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	private JTextField txtGrupo;
	
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnActualizar;
	private JButton btnSalir;
	
	private JScrollPane scrollPane;
	private JTable tablaCalificaciones;
	
	private DefaultTableModel dtmTabla;
	
	ArrayList<Calificaciones> calificacion = new ArrayList<>();
	ArrayList<Alumnos> alumno = new ArrayList<>();
	private TableRowSorter<TableModel> metodoOrdenacion;
	
	private int registroActual = 0;
	private int numeroRegistros = 0;
	private boolean modificado = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDAlumnosCalificaciones frame = new BDAlumnosCalificaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BDAlumnosCalificaciones() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cargarDatosTabla();
				cargarDatosArrayList();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				if (modificado == true) {
					guardarDatos();
					JOptionPane.showMessageDialog(contenedor,(String)"Se ha creado el fichero correctamente.",":)",JOptionPane.ERROR_MESSAGE,null);
				}
				// Cerrar aplicaion
				System.exit(0);
			}
		});
		setTitle("BDAlumnosCalificaciones");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 546, 439);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
		
		panelNavegacion = new JPanel();
		contenedor.add(panelNavegacion, BorderLayout.NORTH);

		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrimero();
			}
		});
		panelNavegacion.add(btnPrimero);

		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAnterior();
			}
		});
		panelNavegacion.add(btnAnterior);

		lblRegistros = new JLabel("No hay registros");
		panelNavegacion.add(lblRegistros);

		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSiguiente();
			}
		});
		panelNavegacion.add(btnSiguiente);

		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUltimo();
			}
		});
		panelNavegacion.add(btnUltimo);

		panelBotones = new JPanel();
		contenedor.add(panelBotones, BorderLayout.SOUTH);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bntInsertar();
			}
		});
		panelBotones.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorrar();
			}
		});
		panelBotones.add(btnBorrar);

		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnActualizar();
			}
		});
		panelBotones.add(btnActualizar);

		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalir();
			}
		});
		panelBotones.add(btnSalir);

		panelInformacion = new JPanel();
		contenedor.add(panelInformacion, BorderLayout.CENTER);
		panelInformacion.setLayout(null);

		panelCampos = new JPanel();
		panelCampos.setBounds(93, 11, 335, 124);
		panelInformacion.add(panelCampos);
		GridBagLayout gbl_panelCampos = new GridBagLayout();
		gbl_panelCampos.columnWidths = new int[] { 15, 64, 285, 0 };
		gbl_panelCampos.rowHeights = new int[] { 0, 0, 0, 0, 0, 0 };
		gbl_panelCampos.columnWeights = new double[] { 1.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panelCampos.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelCampos.setLayout(gbl_panelCampos);

		lblDni = new JLabel("DNI");
		GridBagConstraints gbc_lblDni = new GridBagConstraints();
		gbc_lblDni.anchor = GridBagConstraints.EAST;
		gbc_lblDni.insets = new Insets(0, 0, 5, 5);
		gbc_lblDni.gridx = 1;
		gbc_lblDni.gridy = 1;
		panelCampos.add(lblDni, gbc_lblDni);

		txtDni = new JTextField();
		txtDni.setHorizontalAlignment(SwingConstants.LEFT);
		txtDni.setColumns(10);
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.insets = new Insets(0, 0, 5, 0);
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 1;
		panelCampos.add(txtDni, gbc_txtDni);

		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		panelCampos.add(lblNombre, gbc_lblNombre);

		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		txtNombre.setColumns(10);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		panelCampos.add(txtNombre, gbc_txtNombre);

		lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 3;
		panelCampos.add(lblApellidos, gbc_lblApellidos);

		txtApellidos = new JTextField();
		txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		txtApellidos.setColumns(10);
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellidos.gridx = 2;
		gbc_txtApellidos.gridy = 3;
		panelCampos.add(txtApellidos, gbc_txtApellidos);

		lblGrupo = new JLabel("Grupo");
		GridBagConstraints gbc_lblGrupo = new GridBagConstraints();
		gbc_lblGrupo.anchor = GridBagConstraints.EAST;
		gbc_lblGrupo.insets = new Insets(0, 0, 0, 5);
		gbc_lblGrupo.gridx = 1;
		gbc_lblGrupo.gridy = 4;
		panelCampos.add(lblGrupo, gbc_lblGrupo);

		txtGrupo = new JTextField();
		GridBagConstraints gbc_txtGrupo = new GridBagConstraints();
		gbc_txtGrupo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtGrupo.gridx = 2;
		gbc_txtGrupo.gridy = 4;
		panelCampos.add(txtGrupo, gbc_txtGrupo);
		txtGrupo.setColumns(10);

		panelTabla = new JPanel();
		panelTabla.setBounds(12, 146, 496, 160);
		panelInformacion.add(panelTabla);
		panelTabla.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panelTabla.add(scrollPane);
		
		tablaCalificaciones = new JTable();
		scrollPane.setViewportView(tablaCalificaciones);
	}
	
	// Metodo para cargar los datos a la tabla
	private void cargarDatosTabla() {
		// Abro la concexion conectarse a MySQL
		try {
			// Creo la conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// Creo un Statement st = conexion.createStatement();
			Statement st = conexion.createStatement();
			// Preparo la cosulta
			String Consulta = "SELECT * FROM calificaciones";
			// Ejecuto la consulta 
			ResultSet rs = st.executeQuery(Consulta);

			// cabeceras de las columnas
			ResultSetMetaData metaDatos = rs.getMetaData();
			// Se obtiene el número de columnas.
			int numeroColumnas = metaDatos.getColumnCount();
			Vector <String> columnas = new Vector<String>();
			// Se obtiene cada una de las etiquetas para cada columna
			for (int i = 0; i < numeroColumnas; i++){
			// cojo el valor de la etiqueta de la columna
			// los índices del rs empiezan en 1 pero los índices de las columnas empiezan en 0
			columnas.add(metaDatos.getColumnLabel(i + 1));
			}
			
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
			
			// Cierro el ResultSet
			rs.close();
			// Cierro el ResultSet
			st.close();
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
			tablaCalificaciones.setModel(dtmTabla);
			// creo el Scroll panel y le añado la tabla
			//JScrollPane scrollPane = new JScrollPane(tablaCalificaciones);
			// añado el Scroll panel al panel principal
			//panelTabla.add(scrollPane, BorderLayout.CENTER);
			
			// Podemos ordenar el contenido de la tabla de varias formas
			tablaCalificaciones.setAutoCreateRowSorter(true);
			tablaCalificaciones.getTableHeader().setReorderingAllowed(false);
			// Cambiar lblTexto
			// numeroRegistros = coches.size();
			// lblRegistros.setText("Vehiculo Registro: " + registroActual + " de " + numeroRegistros);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}
	
	// Metodo para cargar los datos
	private void cargarDatosArrayList() {
		// Abro la concexion conectarse a MySQL
		try {
			// Creo la conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdalumnos", "root", "");
			// Creo un Statement st = conexion.createStatement();
			Statement st = conexion.createStatement();
			// Preparo la cosulta
			String Consulta = "SELECT * FROM alumnos";
			// Ejecuto la consulta 
			ResultSet rs = st.executeQuery(Consulta);

			// Agrego uno a uno las personas
			while (rs.next()) {
				// Creo una nueva persona
				Alumnos alu = new Alumnos();
				alu.setDni(rs.getString("dni").toString());
				alu.setNombre(rs.getString("nombre").toString());
				alu.setApellidos(rs.getString("apellidos").toString());
				alu.setGrupo(rs.getString("grupo").toString());
				alumno.add(alu);
			}
			
			// Cierro el ResultSet
			rs.close();
			// Cierro el ResultSet
			st.close();
			// Cierro la conexion
			conexion.close();
		  	
			// Cambiar lblTexto
			numeroRegistros = alumno.size();
			lblRegistros.setText("Alumno Registro: " + registroActual + " de " + numeroRegistros);
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}
	
	// Metodo para guardar los datos
	private void guardarDatos() {
		if (modificado == true){
			try {
				// Creo la conexion
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdalumnos", "root", "");
				// Creo un Statement st = conexion.createStatement();
				Statement st = conexion.createStatement();
				// Preparo la cosulta
				String ConsultaDelete = "DELETE FROM bdalumnos.calificaciones";
				// Ejecuto la consulta 
				st.executeUpdate(ConsultaDelete);
				
				// Necesidades previas
				String dni = "", codasignatura = "";
				Integer nota = 0;
				
				// Recorrer el array
				for (int i = 0; i < calificacion.size(); i++) {
					Calificaciones valor = new Calificaciones();
					valor = calificacion.get(i);
					dni = valor.getDni();
					codasignatura = valor.getCodigoasignatura();
					nota = valor.getNota();
					// Creo una nueva consulta
					String ConsultaInsert = "INSERT INTO calificaciones VALUES ('"+dni+"','"+codasignatura+"','"+nota+"')";
					// Conslta para insertar los valores nuevos
					st.executeUpdate(ConsultaInsert);
				}
				// Cierro el ResultSet
				st.close();
				// Cierro la conexion
				conexion.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Metodo para actualizar el lbltexto
	private void actualizarCampos() {
		numeroRegistros = alumno.size();
		lblRegistros.setText("Alumno Registro: " + registroActual + " de " + numeroRegistros);
		
		Alumnos valor;
		String DNI;
		String Nombre;
		String Apellidos;
		String Grupo;

		valor = alumno.get(registroActual - 1);
		DNI = valor.getDni();
		Nombre = valor.getNombre();
		Apellidos = valor.getApellidos();
		Grupo = valor.getGrupo();

		txtDni.setText(DNI);
		txtNombre.setText(Nombre);
		txtApellidos.setText(Apellidos);
		txtGrupo.setText(Grupo);
		
		// Ordenar la tabla por dni seleccionado
		metodoOrdenacion = new TableRowSorter<TableModel>(dtmTabla);
		tablaCalificaciones.setRowSorter(metodoOrdenacion);
		metodoOrdenacion.setRowFilter(RowFilter.regexFilter(txtDni.getText(), 0));
	}
	
	// Metodo ir al primer registro
	private void btnPrimero() {
		if (!alumno.isEmpty()){
			// Posicionar en la primera posicion
			registroActual = 1;
			// Actualizar los campos
			actualizarCampos();
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. La lista esta vacia.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
		
	}
	
	// Metodo ir al ultimo registro
	private void btnUltimo() {
		if (!alumno.isEmpty()){
			// Posicionar en la primera posicion
			registroActual = alumno.size();
			// Actualizar los campos y lbltexto
			actualizarCampos();
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. La lista esta vacia.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	// Metodo ir al siguiente registro
	private void btnSiguiente() {
		if (!alumno.isEmpty()) {
			if (!(registroActual == numeroRegistros)) {
				// Sumar una posicion
				registroActual++;
				// Actualizar los campos y lbltexto
				actualizarCampos();
			}
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. No hay mas registros.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	// Metodo ir al anterior registro
	private void btnAnterior() {
		if (!alumno.isEmpty()) {
			if (!(registroActual == 1)) {
				// Restar una posicion
				registroActual--;
				// Actualizar los campos y lbltexto
				actualizarCampos();
			}
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. No hay mas registros.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	// Metodo para insertar un nuevo vehiculo
	private void bntInsertar() {
		// Creo un nuevo vehiculo
		Alumnos alu = new Alumnos();
		alu.setDni(txtDni.getText());
		alu.setNombre(txtNombre.getText());
		alu.setApellidos(txtApellidos.getText());
		alu.setGrupo(txtGrupo.getText());
		// recorro la lista
		for (int i = 0; i < alumno.size(); i++) {
			if (alumno.get(i).getDni().equals(txtDni.getText())) {
				JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. Ya hay un alumno con ese DNI",":)",JOptionPane.ERROR_MESSAGE,null);
				break;
			} else {
				alumno.add(new Alumnos(alu));
				JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. Se ha insertado el alumno",":)",JOptionPane.ERROR_MESSAGE,null);
				modificado = true;
			}
		}
		
	}
	
	// Metodo para borrar un vehiculo
	private void btnBorrar() {
		Alumnos alu = new Alumnos();
		alu.setDni(txtDni.getText());
		alu.setNombre(txtNombre.getText());
		alu.setApellidos(txtApellidos.getText());
		alu.setGrupo(txtGrupo.getText());
		// recorro la lista
		for (int i = 0; i < alumno.size(); i++) {
			if (alumno.get(i).getDni().equals(txtDni.getText())) {
				JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. Se ha elimiado el vehiculo",":)",JOptionPane.ERROR_MESSAGE,null);
				alumno.remove(alu);
				modificado = true;
				break;
			} else {
				JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. No hay coche con esa matricula",":)",JOptionPane.ERROR_MESSAGE,null);
			}
		}
	}
	
	// Metodo para actualizar vehiculo
	private void btnActualizar() {
		Alumnos alu = new Alumnos();
		alu.setDni(txtDni.getText());
		alu.setNombre(txtNombre.getText());
		alu.setApellidos(txtApellidos.getText());
		alu.setGrupo(txtGrupo.getText());
		// recorro la lista
		for (int i = 0; i < alumno.size(); i++) {
			if (alumno.get(i).getDni().equals(alu.getDni())) {
				alumno.set(i, alu);
				modificado = true;
			}
		}
		
	}
	
	// Metodo para salir de la aplicacion
	private void btnSalir() {
		// Salir de la aplicacion
		if (modificado == true) {
			guardarDatos();
		} else {
			dispose();
		}
	}

}
