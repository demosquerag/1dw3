package examenFinal2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExamenFinal2BDAlumnos extends JFrame{

	private static final long serialVersionUID = -221219774027956173L;
	private JPanel contenedor;
	private JButton btnSalir;
	
	private JPanel panelBotones;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnActualizar;
		
	private JPanel panelCampos;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellidos;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellidos;
	
	private JPanel panelNavegacion;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JLabel lblRegistros;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	
	private ArrayList<Alumnos> alumno = new ArrayList<>();
	private int registroActual = 0;
	private int numeroRegistros = 0;
	private boolean modificado = false;
	private boolean comprobado = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamenFinal2BDAlumnos frame = new ExamenFinal2BDAlumnos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ExamenFinal2BDAlumnos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (modificado == true) {
					guardarDatos();
					JOptionPane.showMessageDialog(contenedor,(String)"Los cambios se han guardado correctamente.",":)",JOptionPane.ERROR_MESSAGE,null);
				}
				// Cerrar aplicaion
				System.exit(0);
			}
			@Override
			public void windowOpened(WindowEvent arg0) {
				cargarDatosArrayList();
			}
		});
		setTitle("ExamenFinal2BDAlumnos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 209);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
		
		panelBotones = new JPanel();
		contenedor.add(panelBotones, BorderLayout.SOUTH);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnInsertar();
			}
		});
		panelBotones.add(btnInsertar);
		
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnBorrar();
			}
		});
		panelBotones.add(btnBorrar);
		
		btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnActualizar();
			}
		});
		panelBotones.add(btnActualizar);
		
		btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSalir();
			}
		});
		panelBotones.add(btnSalir);
		
		panelCampos = new JPanel();
		contenedor.add(panelCampos, BorderLayout.CENTER);
		GridBagLayout gbl_panelCampos = new GridBagLayout();
		gbl_panelCampos.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelCampos.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelCampos.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCampos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
		GridBagConstraints gbc_txtDni = new GridBagConstraints();
		gbc_txtDni.anchor = GridBagConstraints.NORTH;
		gbc_txtDni.insets = new Insets(0, 0, 5, 0);
		gbc_txtDni.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtDni.gridx = 2;
		gbc_txtDni.gridy = 1;
		panelCampos.add(txtDni, gbc_txtDni);
		txtDni.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 1;
		gbc_lblNombre.gridy = 2;
		panelCampos.add(lblNombre, gbc_lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtNombre = new GridBagConstraints();
		gbc_txtNombre.insets = new Insets(0, 0, 5, 0);
		gbc_txtNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNombre.gridx = 2;
		gbc_txtNombre.gridy = 2;
		panelCampos.add(txtNombre, gbc_txtNombre);
		txtNombre.setColumns(10);
		
		lblApellidos = new JLabel("Apellidos");
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 1;
		gbc_lblApellidos.gridy = 3;
		panelCampos.add(lblApellidos, gbc_lblApellidos);
		
		txtApellidos = new JTextField();
		txtApellidos.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtApellidos = new GridBagConstraints();
		gbc_txtApellidos.insets = new Insets(0, 0, 5, 0);
		gbc_txtApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtApellidos.gridx = 2;
		gbc_txtApellidos.gridy = 3;
		panelCampos.add(txtApellidos, gbc_txtApellidos);
		txtApellidos.setColumns(10);
		
		panelNavegacion = new JPanel();
		contenedor.add(panelNavegacion, BorderLayout.NORTH);
		
		btnPrimero = new JButton("<<");
		btnPrimero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnPrimero();
			}
		});
		panelNavegacion.add(btnPrimero);
		
		btnAnterior = new JButton("<");
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAnterior();
			}
		});
		panelNavegacion.add(btnAnterior);
		
		lblRegistros = new JLabel("No hay registros");
		panelNavegacion.add(lblRegistros);
		
		btnSiguiente = new JButton(">");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSiguiente();
			}
		});
		panelNavegacion.add(btnSiguiente);
		
		btnUltimo = new JButton(">>");
		btnUltimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUltimo();
			}
		});
		panelNavegacion.add(btnUltimo);
		
		
	}
	
	// Metodo para cargar los datos
	private void cargarDatosArrayList() {
		// Abro la concexion conectarse a MySQL
		try {
			// Creo la conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdfinal2", "root", "");
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
				alumno.add(alu);
			}
			
			// Cierro el ResultSet
			rs.close();
			// Cierro el ResultSet
			st.close();
			// Cierro la conexion
			conexion.close();
		  	
			// Cambiar lblTexto
			btnPrimero();
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
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdfinal2", "root", "");
				// Creo un Statement st = conexion.createStatement();
				Statement st = conexion.createStatement();
				// Preparo la cosulta
				String ConsultaDelete = "DELETE FROM bdfinal2.alumnos";
				// Ejecuto la consulta 
				st.executeUpdate(ConsultaDelete);
				
				// Necesidades previas
				String dni = "", nombre = "", apellido = "";
				
				// Recorrer el array
				for (int i = 0; i < alumno.size(); i++) {
					Alumnos valor = new Alumnos();
					valor = alumno.get(i);
					dni = valor.getDni();
					nombre = valor.getNombre();
					apellido = valor.getApellidos();
					// Creo una nueva consulta
					String ConsultaInsert = "INSERT INTO alumnos VALUES ('"+dni+"','"+nombre+"','"+apellido+"')";
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
		lblRegistros.setText("Registro: " + registroActual + " de " + numeroRegistros);
		
		Alumnos valor;
		String DNI;
		String Nombre;
		String Apellidos;

		valor = alumno.get(registroActual - 1);
		DNI = valor.getDni();
		Nombre = valor.getNombre();
		Apellidos = valor.getApellidos();

		txtDni.setText(DNI);
		txtNombre.setText(Nombre);
		txtApellidos.setText(Apellidos);
	}
		
	// Metodo ir al primer registro
	private void btnPrimero() {
		if (!alumno.isEmpty()){
			// Posicionar en la primera posicion
			registroActual = 1;
			// Actualizar los campos
			actualizarCampos();
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"La lista esta vacia.",":)",JOptionPane.ERROR_MESSAGE,null);
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
			JOptionPane.showMessageDialog(contenedor,(String)"La lista esta vacia.",":)",JOptionPane.ERROR_MESSAGE,null);
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
			} else if (registroActual > alumno.size()) {
				// Restar una posicion
				registroActual--;
				// Actualizar los campos y lbltexto
				actualizarCampos();
			}
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"No hay mas registros.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	// Metodo ir al anterior registro
	private void btnAnterior() {
		if (!alumno.isEmpty()) {
			if (registroActual <= 0) {
				// Restar una posicion
				registroActual = 1;
				// Actualizar los campos y lbltexto
				actualizarCampos();
			} else if (!(registroActual == 1)) {
				// Sumar una posicion
				registroActual--;
				// Actualizar los campos y lbltexto
				actualizarCampos();
			}
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"No hay mas registros.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	// Metodo para insertar un nuevo vehiculo
	private void btnInsertar() {
		// Creo un nuevo vehiculo
		Alumnos alu = new Alumnos();
		alu.setDni(txtDni.getText());
		alu.setNombre(txtNombre.getText());
		alu.setApellidos(txtApellidos.getText());
		
		if (txtDni.getText().equals("") || txtNombre.getText().equals("") || txtApellidos.getText().equals("")) {
			JOptionPane.showMessageDialog(contenedor,(String)"Los campos estan vacios.",":)",JOptionPane.ERROR_MESSAGE,null);
			comprobado = true;
		} else {
			// recorro la lista
			for (int i = 0; i < alumno.size(); i++) {
				if (alumno.get(i).getDni().equals(txtDni.getText())) {
					JOptionPane.showMessageDialog(contenedor,(String)"Ya hay un alumno con ese DNI.",":)",JOptionPane.ERROR_MESSAGE,null);
					comprobado = true;
					break;
				}
			}
		}
		
		if (comprobado == false) {
			alumno.add(new Alumnos(alu));
			// Actualizar los campos y lbltexto
			actualizarCampos();
			JOptionPane.showMessageDialog(contenedor,(String)"Se ha insertado el alumno.",":)",JOptionPane.ERROR_MESSAGE,null);
			modificado = true;
		}
	}
	
	// Metodo para borrar un vehiculo
	private void btnBorrar() {
		Alumnos alu = new Alumnos();
		alu.setDni(txtDni.getText());
		alu.setNombre(txtNombre.getText());
		alu.setApellidos(txtApellidos.getText());
		if (alumno.isEmpty()) {
			JOptionPane.showMessageDialog(contenedor,(String)"No hay registros.",":)",JOptionPane.ERROR_MESSAGE,null);
			numeroRegistros = alumno.size();
			lblRegistros.setText("Registro: " + registroActual + " de " + numeroRegistros);
			txtDni.setText("");
			txtNombre.setText("");
			txtApellidos.setText("");
		} else {
			// recorro la lista
			for (int i = 0; i < alumno.size(); i++) {
				if (alumno.get(i).getDni().equals(txtDni.getText())) {
					JOptionPane.showMessageDialog(contenedor,(String)"Se ha elimiado el alumno.",":)",JOptionPane.ERROR_MESSAGE,null);
					alumno.remove(alu);
					modificado = true;
					btnAnterior();
					break;
				}
			}
		}
		
	}
	
	// Metodo para actualizar vehiculo
	private void btnActualizar() {
		Alumnos alu = new Alumnos();
		alu.setDni(txtDni.getText());
		alu.setNombre(txtNombre.getText());
		alu.setApellidos(txtApellidos.getText());
		// recorro la lista
		for (int i = 0; i < alumno.size(); i++) {
			if (alumno.get(i).getDni().equals(alu.getDni())) {
				alumno.set(i, alu);
				JOptionPane.showMessageDialog(contenedor,(String)"Se ha modificado el alumno.",":)",JOptionPane.ERROR_MESSAGE,null);
				modificado = true;
			}
		}
		
	}
	
	// Metodo para salir de la aplicacion
	private void btnSalir() {
		// Salir de la aplicacion
		if (modificado == true) {
			JOptionPane.showMessageDialog(contenedor,(String)"Se ha creado el fichero correctamente.",":)",JOptionPane.ERROR_MESSAGE,null);
			guardarDatos();
		}
		// Cerrar la aplicacion
		System.exit(0);
	}
		
}
