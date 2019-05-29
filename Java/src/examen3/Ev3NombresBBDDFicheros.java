package examen3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Ev3NombresBBDDFicheros extends JFrame implements ActionListener, FocusListener{

	// Necesidades previas
	private static final long serialVersionUID = -7738502548771528496L;
	private JPanel contenedor;
	private JLabel lblNombre;
	private JPanel panelDatos;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JTextField txtNombre;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JScrollPane scrollPane;
	private JPanel panelEstado;
	private JLabel lblEstado;
	private JLabel lblEstadoActual;
	private JLabel lblDni;
	private JTextField txtDni;
	// Taldeen zerrrenda
	private JList<Persona> lstPersonas;
	// zerrendaren datu modeloa
	private DefaultListModel<Persona> dlmPersonas;
	// 
	private ArrayList<Persona> personas = new ArrayList<Persona>();
	private boolean modificado = false;
	private Connection conexion;
	private CachedRowSet crs;
	
	// Inicializacion de la ventana
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ev3NombresBBDDFicheros frame = new Ev3NombresBBDDFicheros();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Crear el frame
	public Ev3NombresBBDDFicheros() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (modificado == true) {
					GuardarDatos();
					JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. Se ha creado el fichero correctamente.",":)",JOptionPane.ERROR_MESSAGE,null);
				}
				// Cerrar aplicaion
				System.exit(0);
			}
		});
		setTitle("Ex3NombreBBDDFicheros ");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 822, 336);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);

		panelDatos = new JPanel();
		contenedor.add(panelDatos, BorderLayout.NORTH);

		lblDni = new JLabel("DNI");
		panelDatos.add(lblDni);

		txtDni = new JTextField();
		txtDni.addActionListener(this);
		txtDni.addFocusListener(this);
		panelDatos.add(txtDni);
		txtDni.setColumns(10);

		lblNombre = new JLabel("Nombre");
		panelDatos.add(lblNombre);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);

		txtNombre = new JTextField();
		txtNombre.addActionListener(this);
		txtNombre.addFocusListener(this);
		txtNombre.setHorizontalAlignment(SwingConstants.RIGHT);

		panelDatos.add(txtNombre);
		txtNombre.setColumns(10);

		lblApellido = new JLabel("Apellido");
		panelDatos.add(lblApellido);

		txtApellido = new JTextField();
		txtApellido.addActionListener(this);
		txtApellido.addFocusListener(this);
		txtApellido.setHorizontalAlignment(SwingConstants.RIGHT);

		panelDatos.add(txtApellido);
		txtApellido.setColumns(10);

		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardar();
			}
		});

		panelDatos.add(btnGuardar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bntBorrar();
			}
		});
		panelDatos.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnLimpiar();
			}
		});
		panelDatos.add(btnLimpiar);

		// zerrendaren datamodela
		dlmPersonas = new DefaultListModel<Persona>();
		// lstPertsonak
		lstPersonas = new JList<Persona>();
		lstPersonas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JListToJTextField();
			}
		});
		lstPersonas.setModel(dlmPersonas);
		scrollPane = new JScrollPane(lstPersonas);
		contenedor.add(scrollPane, BorderLayout.CENTER);

		panelEstado = new JPanel();
		FlowLayout fl_panelEstado = (FlowLayout) panelEstado.getLayout();
		fl_panelEstado.setAlignment(FlowLayout.LEFT);
		contenedor.add(panelEstado, BorderLayout.SOUTH);

		lblEstado = new JLabel("Estado:");
		panelEstado.add(lblEstado);

		lblEstadoActual = new JLabel("Sin cambios");
		lblEstadoActual.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelEstado.add(lblEstadoActual);
		
		// Cargar datos de bdexamen3 a JList
		CargarDatos();
		
	}
	
	// Metodo para cargar los datos de bdexamen3 a JList
	private void CargarDatos() {
		// Try- Catch para mostrar la tabla
		// Abro la concexion conectarse a MySQL
		try {
			// Creo la conexion
			conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdexamen3", "root", "");
			// desactivo la actualizacion automatica de datos
			conexion.setAutoCommit(false);
			// creo el CachedRowSet
			RowSetFactory myRowSetFactory = null;
			myRowSetFactory = RowSetProvider.newFactory();
			crs = myRowSetFactory.createCachedRowSet();
			// selecciono todos los alumnos
			// usando la conexion anterior
			crs.setCommand("SELECT dni, nombre, apellido FROM personas");
			crs.execute(conexion);
			
			
			// Agrego uno a uno las personas
			while (crs.next()) {
				// Creo una nueva persona
				Persona valor = new Persona();
				valor.setDni(crs.getString("dni").toString());
				valor.setNombre(crs.getString("nombre").toString());
				valor.setApellido(crs.getString("apellido").toString());
				personas.add(valor);
				// Agrego esa persona al JList
				dlmPersonas.addElement(new Persona(valor));
			}
			
			// Cierro el ResultSet
			crs.close();
			// Cierro la conexion
			conexion.close();
		  				
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Se ha producido un error");
		}
	}
	
	// Metodo para guardar los datos midificados en bdexamen3
	private void GuardarDatos() {
		// Grabo los datos en complejos.dat
		FileOutputStream fos;
		ObjectOutputStream oos;
				
		if (modificado == true){
			try {
				// Creo la salida para guardar el texto
				fos=new FileOutputStream("personas.dat");
				oos = new ObjectOutputStream (fos);
				// Recorro el ArrayList
				for (int i = 0; i < personas.size(); i++) {
					// lo grabo
					oos.writeObject(personas.get(i));
				}
				// cierro el fichero
				oos.close();
				fos.close();
				// Creo la conexion
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bdexamen3", "root", "");
				// Desactivo la actualizacion automatica de datos 
				conexion.setAutoCommit(false);
				// Aceptar los cambios
				crs.acceptChanges(conexion);
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Metodo para recoger los datos de la JTable y pasarlos a JTextFields
	private void JListToJTextField() {
		// Necesidades previas
		// Llenar los campos
		this.txtDni.setText(lstPersonas.getSelectedValue().getDni());
		this.txtNombre.setText(lstPersonas.getSelectedValue().getNombre());
		this.txtApellido.setText(lstPersonas.getSelectedValue().getApellido());
	}
	
	// Metodo para guardar los datos en JList
	private void btnGuardar() {
		Persona valor = new Persona();
		valor.setDni(txtDni.getText());
		valor.setNombre(txtNombre.getText());
		valor.setApellido(txtApellido.getText());
		
		if (txtDni.getText().equals("") || txtNombre.getText().equals("") || txtApellido.getText().equals("")) {
			// Mensaje de error
			JOptionPane.showMessageDialog(contenedor,(String)"Error. No se puede dejar un campo en blanco.","Error",JOptionPane.ERROR_MESSAGE,null);
		} else {
			// Recorro la lista
			for (int i = 0; i < dlmPersonas.size(); i++) {
				// Compruebo el DNI
				if (dlmPersonas.get(i).getDni().equals(txtDni.getText())) {
					JOptionPane.showMessageDialog(contenedor,(String)"Error. Ya hay una persona con ese DNI, no se añadira a la lista .","Error",JOptionPane.ERROR_MESSAGE,null);
					break;
					
				} else {
					// Agrego la persona al array
					personas.add(new Persona(valor));
					// Añado la persona al JList
					dlmPersonas.addElement(valor);
					// Agrego el registro al CachedRowSet
					try {
						crs.moveToInsertRow();
						crs.updateString(1, this.txtDni.getText());
						crs.updateString(2, this.txtNombre.getText());
						crs.updateString(3, this.txtApellido.getText());
						crs.insertRow();
						crs.moveToCurrentRow();
						// Modifico el valor
						modificado = true;
						break;
					} catch (SQLException e) {
						e.printStackTrace();
					}
					// Cambio el lblTexto
					lblEstadoActual.setText("Datos modificados");
				}
			}
				
		}
		
	}
	
	// Metodo para borrar la linea seleccionada
	private void bntBorrar() {
		// Creo un int que recoja la posicion seleccionada
		int[] p = lstPersonas.getSelectedIndices();
		// Elimino la fila seleccionada recogida con el int
		for (int i = p.length-1; i >= 0; i--) {
			// Eliminar personas seleccionadas
			dlmPersonas.remove(p[i]);
			// Eliminar la persona del ArrayList
			personas.remove(personas.get(p[i]));
		}
		// Cambiar lblTexto
		lblEstadoActual.setText("Datos modificados");
		// Cambio el valor de modificado
		modificado = true;
	}
	
	// Metodo para limpiar la lista
	private void btnLimpiar() {
		// Eliminar personas del ArrayList
		personas.removeAll(personas);
		// Poner el contador de filas a 0
		dlmPersonas.removeAllElements();
		for (int i = 0; i < dlmPersonas.size(); i++) {
			try {
				// borro del crs el registro que está en la posición seleccionada
				crs.absolute(i);
				// borro el registro de esa posicion
				crs.deleteRow();
				// me posiciono en el primer registro para que los cambios tengan efecto
				crs.first();
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(contenedor,(String)"Error. No se ha podido borrar el registro","Error",JOptionPane.ERROR_MESSAGE,null);
			}
		}
		// Cambiar lblTexto
		lblEstadoActual.setText("Datos modificados");
		// Cambio el valor de modificado
		modificado = true;
	}

	
	// Implementacion accion por defecto
	@Override
	public void actionPerformed(ActionEvent arg0) {
		btnGuardar();
	}
	
	// Implementacion de focus ganado
	@Override
	public void focusGained(FocusEvent arg0) {
		JTextComponent jtc = (JTextComponent) arg0.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(jtc.getText().length());
	}

	// Implementacion de focus perdido
	@Override
	public void focusLost(FocusEvent arg0) {
		JTextComponent jtc = (JTextComponent) arg0.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(0);
	}
	
}
