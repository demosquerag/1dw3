package BizkaiaBasket.copy;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Checkbox;

public class VentanaGUsuarios extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelFondo;
	private JTable tblGUsuarios;
	private JLabel lblGUsuarios;
	private JLabel lblPassword;
	private JLabel lblNombre;
	private JButton btnCrear;
	private JButton btnEliminar;
	private JButton btnModificar;
	static JTextField txtUsuario;
	static JTextField txtPassword;
	private JLabel lblFondo;
	private JButton btnVolver;
	private JScrollPane scpGUsuarios;
	private static Checkbox checkAdmin;
	private static Checkbox checkUser;
	private static Checkbox checkViewer;
	
	// Definir Necesidades Previas
	int row;
		
	public VentanaGUsuarios() {
		//Array
		
		// Diseï¿½o de la ventana
		setResizable(false);
		setTitle("Gesti\u00F3n Usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 510);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelFondo = new JPanel();
		panelFondo.setLayout(null);
		panelFondo.setBounds(0, 0, 604, 481);
		contentPane.add(panelFondo);

		lblGUsuarios = new JLabel("Gesti\u00F3n de Usuarios");
		lblGUsuarios.setForeground(Color.WHITE);
		lblGUsuarios.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblGUsuarios.setBounds(129, 44, 220, 39);
		panelFondo.add(lblGUsuarios);

		lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Arial", Font.BOLD, 15));
		lblPassword.setBounds(239, 293, 188, 27);
		panelFondo.add(lblPassword);

		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombre.setBounds(39, 293, 188, 28);
		panelFondo.add(lblNombre);

		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				
				// Añadir checkbox para elegir tipo (si es usuario pasamos "U", si no pasamos cualquier cadena de texto, ya que por defecto te creara un observador)
				GUsuarios.CrearUsuario(txtUsuario.getText(), txtPassword.getText(), checkBox());
				
			}
		});
		
		JLabel lblTipo = new JLabel("Tipo");
		lblTipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipo.setForeground(Color.WHITE);
		lblTipo.setFont(new Font("Arial", Font.BOLD, 15));
		lblTipo.setBounds(412, 293, 188, 28);
		panelFondo.add(lblTipo);
		btnCrear.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrear.setBackground(Color.WHITE);
		btnCrear.setBounds(39, 383, 95, 39);
		panelFondo.add(btnCrear);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnModificar.setFont(new Font("Arial", Font.BOLD, 12));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(190, 383, 89, 39);
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Debe recoger ambos datos uno, otro o ambos.
				GUsuarios.ModificarUsuario(tblGUsuarios.getSelectedRow(), getTxtUsuario(), getTxtPassword());
			}
		});
		panelFondo.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				GUsuarios.EliminarUsuario(tblGUsuarios.getSelectedRow());
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(336, 383, 89, 39);
		panelFondo.add(btnEliminar);

		btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnVolver();
			}
		});
		btnVolver.setIcon(new ImageIcon(VentanaGUsuarios.class.getResource("/BizkaiaBasket/arrowleft.png")));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(0, 0, 48, 36);
		panelFondo.add(btnVolver);

		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(39, 327, 188, 28);
		panelFondo.add(txtUsuario);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(239, 326, 188, 28);
		panelFondo.add(txtPassword);

		scpGUsuarios = new JScrollPane();
		scpGUsuarios.setEnabled(false);
		scpGUsuarios.setBounds(53, 99, 499, 183);
		panelFondo.add(scpGUsuarios);

		tblGUsuarios = new JTable();
		tblGUsuarios.setFont(new Font("Arial", Font.PLAIN, 12));
		tblGUsuarios.setShowHorizontalLines(false);
		// establece el modo de seleccion de la tabla, permitiendo seleccionar un unico usuario a la vez.
		tblGUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION );
		scpGUsuarios.setViewportView(tblGUsuarios);
		tblGUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		tblGUsuarios.setBackground(new Color(233, 150, 122));
		tblGUsuarios.setModel(GUsuarios.usuarios);
		
		// Listener para comprobar si hay alguna fila seleccionada
		tblGUsuarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tblGUsuarios.getSelectedRow() != -1) // Si hay fila seleccionada
				{
					
				}
				else									// SI no hay fila seleccionada
				{
					txtUsuario.setText("");				// ELiminamos el contenido de la entrada de usuario
					txtPassword.setText("");
					
					checkAdmin.setState(false);
					checkUser.setState(false);
					checkViewer.setState(false);
				}
			}
		});		
		checkAdmin = new Checkbox("Administrador");
		checkAdmin.setFont(new Font("Arial", Font.BOLD, 12));
		checkAdmin.setBackground(Color.WHITE);
		checkAdmin.setBounds(457, 327, 100, 22);
		panelFondo.add(checkAdmin);
		
		checkUser = new Checkbox("Usuario");
		checkUser.setFont(new Font("Arial", Font.BOLD, 12));
		checkUser.setBackground(Color.WHITE);
		checkUser.setBounds(457, 355, 100, 22);
		panelFondo.add(checkUser);
		
		checkViewer = new Checkbox("Observador");
		checkViewer.setFont(new Font("Arial", Font.BOLD, 12));
		checkViewer.setBackground(Color.WHITE);
		checkViewer.setBounds(457, 383, 100, 22);
		panelFondo.add(checkViewer);
		
		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaGUsuarios.class.getResource("/BizkaiaBasket/Fondo.png")));
		lblFondo.setBounds(0, 0, 604, 481);
		panelFondo.add(lblFondo);
		
	}

	
	/*private void BtnEliminar() {
		// Recoger los datos de los campos a eliminar
		int eli = tblGUsuarios.getSelectedRow();
		
		if (eli >= 0) {
			//tblgu.removeRow(eli);
		}
		else {
			JOptionPane.showMessageDialog(null,"No hay datos a eliminar");
		}
	}*/

	private void BtnVolver() {
		GUsuarios.IrAPrincipal();
		//AbrirVentanas.vePAdmin();
		dispose(); // Elimina el objeto en memoria (cierra la ventana)
	}

	public static String getTxtUsuario() {
		
		// String usuario;
		// usuario = txtUsuario.getText();
		// return usuario;
		
		return txtUsuario.getText(); // Devuelve el dato de forma mï¿½s eficiente
	}

	public static String getTxtPassword() {
		
		// String password;
		// password = txtPassword.getText();
		// return password;
		
		return txtPassword.getText(); // Devuelve el dato de forma mï¿½s eficiente
	}
	
	
	private static String checkBox() { // método común para registrar una función / si se pulsa algun botón de función

		boolean admin = checkAdmin.getState();
		boolean user = checkUser.getState();
		boolean viewer = checkViewer.getState();
		String check = "V";
		
		if (admin) { // Si es admin
			
			check = "A";
			
		}
		
		else if (user) {
			
			
			check = "U";
		}
		
		else if (viewer) {
			
			check = "V";
			
		}
		
		return check;
		
		
	}
	
	
}
