package examenFinal1;

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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ExamenFinal1BDVehiculos extends JFrame{

	private static final long serialVersionUID = -221219774027956173L;
	private JPanel contenedor;
	private JButton btnSalir;
	
	private JPanel panelBotones;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnActualizar;
	
	private JPanel panelCampos;
	private JLabel lblMatricula;
	private JLabel lblMarca;
	private JLabel lblModelo;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtModelo;
	
	private JPanel panelNavegacion;
	private JButton btnPrimero;
	private JButton btnAnterior;
	private JLabel lblRegistros;
	private JButton btnSiguiente;
	private JButton btnUltimo;
	
	
	private boolean modificado = false;
	private boolean comprobado = false;
	private int registroActual = 0;
	private int numeroRegistros = 0;
	ArrayList<Vehiculos> coches = new ArrayList<>();
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamenFinal1BDVehiculos frame = new ExamenFinal1BDVehiculos();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Interfaz grafica
	public ExamenFinal1BDVehiculos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				cargarDatos();
			}
			@Override
			public void windowClosing(WindowEvent e) {
				if (modificado == true) {
					guardarDatos();
					JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. Se ha creado el fichero correctamente.",":)",JOptionPane.ERROR_MESSAGE,null);
				}
				// Cerrar aplicaion
				System.exit(0);
			}
		});
		setTitle("ExamenFinal1BDVehiculos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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
		
		panelCampos = new JPanel();
		contenedor.add(panelCampos, BorderLayout.CENTER);
		GridBagLayout gbl_panelCampos = new GridBagLayout();
		gbl_panelCampos.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panelCampos.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelCampos.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCampos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCampos.setLayout(gbl_panelCampos);
		
		lblMatricula = new JLabel("Matr\u00EDcula");
		GridBagConstraints gbc_lblMatricula = new GridBagConstraints();
		gbc_lblMatricula.anchor = GridBagConstraints.EAST;
		gbc_lblMatricula.insets = new Insets(0, 0, 5, 5);
		gbc_lblMatricula.gridx = 1;
		gbc_lblMatricula.gridy = 1;
		panelCampos.add(lblMatricula, gbc_lblMatricula);
		
		txtMatricula = new JTextField();
		txtMatricula.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtMatricula = new GridBagConstraints();
		gbc_txtMatricula.anchor = GridBagConstraints.NORTH;
		gbc_txtMatricula.insets = new Insets(0, 0, 5, 0);
		gbc_txtMatricula.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMatricula.gridx = 2;
		gbc_txtMatricula.gridy = 1;
		panelCampos.add(txtMatricula, gbc_txtMatricula);
		txtMatricula.setColumns(10);

		
		lblMarca = new JLabel("Marca");
		GridBagConstraints gbc_lblMarca = new GridBagConstraints();
		gbc_lblMarca.anchor = GridBagConstraints.EAST;
		gbc_lblMarca.insets = new Insets(0, 0, 5, 5);
		gbc_lblMarca.gridx = 1;
		gbc_lblMarca.gridy = 2;
		panelCampos.add(lblMarca, gbc_lblMarca);
		
		txtMarca = new JTextField();
		txtMarca.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtMarca = new GridBagConstraints();
		gbc_txtMarca.insets = new Insets(0, 0, 5, 0);
		gbc_txtMarca.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtMarca.gridx = 2;
		gbc_txtMarca.gridy = 2;
		panelCampos.add(txtMarca, gbc_txtMarca);
		txtMarca.setColumns(10);
		
		lblModelo = new JLabel("Modelo");
		GridBagConstraints gbc_lblModelo = new GridBagConstraints();
		gbc_lblModelo.anchor = GridBagConstraints.EAST;
		gbc_lblModelo.insets = new Insets(0, 0, 5, 5);
		gbc_lblModelo.gridx = 1;
		gbc_lblModelo.gridy = 3;
		panelCampos.add(lblModelo, gbc_lblModelo);
		
		txtModelo = new JTextField();
		txtModelo.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_txtModelo = new GridBagConstraints();
		gbc_txtModelo.insets = new Insets(0, 0, 5, 0);
		gbc_txtModelo.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtModelo.gridx = 2;
		gbc_txtModelo.gridy = 3;
		panelCampos.add(txtModelo, gbc_txtModelo);
		txtModelo.setColumns(10);
		
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

	}
	
	// Metodo para cargar los datos
	private void cargarDatos() {
		// Abro la concexion conectarse a MySQL
		try {
			// Creo la conexion
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bdfinal1", "root", "");
			// Creo un Statement st = conexion.createStatement();
			Statement st = conexion.createStatement();
			// Preparo la cosulta
			String Consulta = "SELECT * FROM vehiculos";
			// Ejecuto la consulta 
			ResultSet rs = st.executeQuery(Consulta);

			// Agrego uno a uno las personas
			while (rs.next()) {
				// Creo una nueva persona
				Vehiculos coche = new Vehiculos();
				coche.setMatricula(rs.getString("matricula").toString());
				coche.setMarca(rs.getString("marca").toString());
				coche.setModelo(rs.getString("modelo").toString());
				coches.add(coche);
			}
			
			// Cierro el ResultSet
			rs.close();
			// Cierro el ResultSet
			st.close();
			// Cierro la conexion
			conexion.close();
		  	
			// Cambiar lblTexto
			numeroRegistros = coches.size();
			lblRegistros.setText("Vehiculo Registro: " + registroActual + " de " + numeroRegistros);
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
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdfinal1", "root", "");
				// Creo un Statement st = conexion.createStatement();
				Statement st = conexion.createStatement();
				// Preparo la cosulta
				String ConsultaDelete = "DELETE FROM bdfinal1.vehiculos";
				// Ejecuto la consulta 
				st.executeUpdate(ConsultaDelete);
				
				// Necesidades previas
				String matricula = "", marca = "", modelo = "";
				
				// Recorrer el array
				for (int i = 0; i < coches.size(); i++) {
					Vehiculos valor = new Vehiculos();
					valor = coches.get(i);
					matricula = valor.getMatricula();
					marca = valor.getMarca();
					modelo = valor.getModelo();
					// Creo una nueva consulta
					String ConsultaInsert = "INSERT INTO vehiculos VALUES ('"+matricula+"','"+marca+"','"+modelo+"')";
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
	
	// Metodo para insertar un nuevo vehiculo
	private void bntInsertar() {
		// Creo un nuevo vehiculo
		Vehiculos coche = new Vehiculos();
		coche.setMatricula(txtMatricula.getText());
		coche.setMarca(txtMarca.getText());
		coche.setModelo(txtModelo.getText());
		// recorro la lista
		for (int i = 0; i < coches.size(); i++) {
			if (coches.get(i).getMatricula().equals(coche.getMatricula())) {
				JOptionPane.showMessageDialog(contenedor,(String)"Ya hay un coche con esa matricula",":)",JOptionPane.ERROR_MESSAGE,null);
				// Cambio el valor de comprobado
				comprobado = true;
				break;
			}
			
		}
		
		if (comprobado == false) {
			// Agregar el nuevo coche
			coches.add(new Vehiculos(coche));
			JOptionPane.showMessageDialog(contenedor,(String)"Se ha insertado el vehiculo",":)",JOptionPane.ERROR_MESSAGE,null);
			// Cambio el valor
			modificado = true;
		}
		
		actualizarCampos();
		
	}
	
	// Metodo para borrar un vehiculo
	private void btnBorrar() {
		Vehiculos coche = new Vehiculos();
		coche.setMatricula(txtMatricula.getText());
		coche.setMarca(txtMarca.getText());
		coche.setModelo(txtModelo.getText());
		// recorro la lista
		for (int i = 0; i < coches.size(); i++) {
			if (coches.get(i).getMatricula().equals(coche.getMatricula())) {
				JOptionPane.showMessageDialog(contenedor,(String)"Se ha elimiado el vehiculo",":(",JOptionPane.ERROR_MESSAGE,null);
				// Elimino el coche
				coches.remove(coche);
				// Cambio el valor
				modificado = true;
				break;
			}
		}
		// Si la lista esta vacia
		if (coches.isEmpty() || coches.size() == 0) {
			// limpiar campos de texto
			txtMatricula.setText("");
			txtMarca.setText("");
			txtModelo.setText("");
			// Cambiar lblTexto
			registroActual = 0;
			numeroRegistros = coches.size();
			lblRegistros.setText("Vehiculo Registro: " + registroActual + " de " + numeroRegistros);
			JOptionPane.showMessageDialog(contenedor,(String)"No hay mas registros",":(",JOptionPane.ERROR_MESSAGE,null);
		}
		
	}
	
	// Metodo para actualizar vehiculo
	private void btnActualizar() {
		Vehiculos coche = new Vehiculos();
		coche.setMatricula(txtMatricula.getText());
		coche.setMarca(txtMarca.getText());
		coche.setModelo(txtModelo.getText());
		// recorro la lista
		for (int i = 0; i < coches.size(); i++) {
			if (coches.get(i).getMatricula().equals(coche.getMatricula())) {
				coches.set(i, coche);
				modificado = true;
				break;
			}
		}
		
	}
	
	// Metodo para salir de la aplicacion
	private void btnSalir() {
		// Salir de la aplicacion
		if (modificado == true) {
			// Guardo los datos
			guardarDatos();
			JOptionPane.showMessageDialog(contenedor,(String)"Se ha creado el fichero correctamente.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
		// Cierro la aplicacion
		System.exit(0);
		
	}
	
	// Metodo para actualizar el lbltexto
	private void actualizarCampos() {
		numeroRegistros = coches.size();
		lblRegistros.setText("Vehiculo Registro: " + registroActual + " de " + numeroRegistros);
		
		Vehiculos valor;
		String Matricula;
		String Marca;
		String Modelo;

		valor = coches.get(registroActual - 1);
		Matricula = valor.getMatricula();
		Marca = valor.getMarca();
		Modelo = valor.getModelo();

		txtMatricula.setText(Matricula);
		txtMarca.setText(Marca);
		txtModelo.setText(Modelo);
	}
	
	// Metodo ir al primer registro
	private void btnPrimero() {
		if (!coches.isEmpty()){
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
		if (!coches.isEmpty()){
			// Posicionar en la primera posicion
			registroActual = coches.size();
			// Actualizar los campos y lbltexto
			actualizarCampos();
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. La lista esta vacia.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	// Metodo ir al siguiente registro
	private void btnSiguiente() {
		if (!coches.isEmpty()) {
			if (!(registroActual == numeroRegistros)) {
				// Sumar una posicion
				registroActual++;
				// Actualizar los campos y lbltexto
				actualizarCampos();
			} else if (registroActual > coches.size()) {
				// Restar una posicion
				registroActual--;
				// Actualizar los campos y lbltexto
				actualizarCampos();
			}
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. No hay mas registros.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
	// Metodo ir al anterior registro
	private void btnAnterior() {
		if (!coches.isEmpty()) {
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
			JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. No hay mas registros.",":)",JOptionPane.ERROR_MESSAGE,null);
		}
	}
	
}
