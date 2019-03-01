package BizkaiaBasket;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class VentanaGUsuarios extends JFrame {

	/**
	 * 
	 */
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
	private JTextField txtUsuario;
	private JTextField txtPassword;
	private JLabel lblFondo;
	private JButton btnVolver;
	private JScrollPane scpGUsuarios;

	public void run() { // Método run para poder cerrar la ventana actual al abrir otra (se ha sacado del constructor principal para evitar errores).
		try {
			VentanaGUsuarios frame = new VentanaGUsuarios();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(HIDE_ON_CLOSE); // Para cerras la ventana cuando se solicite en el método del botón pulsado + dispose(); en método
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// Definir la tabla
	DefaultTableModel tblgu = new DefaultTableModel();
	
	// Definir Arraylist
	ArrayList<GUsuarios> usuarios;
	
	// Definir Necesidades Previas
	int row;
	
		/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	public VentanaGUsuarios() {
		//Array
		usuarios = new ArrayList<>();
		// Diseño de la ventana
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
		lblPassword.setBounds(345, 335, 188, 27);
		panelFondo.add(lblPassword);

		lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Arial", Font.BOLD, 15));
		lblNombre.setBounds(63, 334, 188, 28);
		panelFondo.add(lblNombre);

		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				BtnGUCrear();
			}
		});
		btnCrear.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrear.setBackground(Color.WHITE);
		btnCrear.setBounds(105, 408, 95, 39);
		panelFondo.add(btnCrear);

		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnModificar.setFont(new Font("Arial", Font.BOLD, 12));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(256, 408, 89, 39);
		panelFondo.add(btnModificar);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnEliminar();
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(402, 408, 89, 39);
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
		txtUsuario.setBounds(63, 368, 188, 28);
		panelFondo.add(txtUsuario);

		txtPassword = new JTextField();
		txtPassword.setColumns(10);
		txtPassword.setBounds(345, 368, 188, 28);
		panelFondo.add(txtPassword);

		scpGUsuarios = new JScrollPane();
		scpGUsuarios.setEnabled(false);
		scpGUsuarios.setBounds(53, 99, 499, 183);
		panelFondo.add(scpGUsuarios);

		tblGUsuarios = new JTable();
		tblGUsuarios.setFont(new Font("Arial", Font.PLAIN, 12));
		tblGUsuarios.setShowHorizontalLines(false);
		scpGUsuarios.setViewportView(tblGUsuarios);
		tblGUsuarios.setBorder(new EmptyBorder(5, 5, 5, 5));
		tblGUsuarios.setBackground(new Color(233, 150, 122));
		tblgu.addColumn("Usuario");
		tblgu.addColumn("Contraseña");
		tblGUsuarios.setModel(tblgu);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaGUsuarios.class.getResource("/BizkaiaBasket/Fondo.png")));
		lblFondo.setBounds(0, 0, 604, 481);
		panelFondo.add(lblFondo);
		
	}

	
	private void BtnGUCrear() {
		// Necesidades previas
		String user = txtUsuario.getText();
		String password = txtPassword.getText();
		
		// Añadir datos al arraylist
		usuarios.add(new GUsuarios(user,password));
		
		// Poner el contador de filas a 0
		tblgu.setRowCount(0);
		
		// Insertar los datos
		for (int i = 0; i < usuarios.size(); i++) {
			Object[] per = {usuarios.get(i).usuario, usuarios.get(i).password};
			tblgu.addRow(per);
		}
		// Limpiar campos
		clearField();
	}
	
	private void BtnEliminar() {
		// Recoger los datos de los campos a eliminar
		int eli = tblGUsuarios.getSelectedRow();
		if (eli >= 0) {
			tblgu.removeRow(eli);
		}
		else {
			JOptionPane.showMessageDialog(null,"No hay datos a eliminar");
		}
	}

	private void BtnVolver() {
		AbrirVentanas.vePAdmin();
		dispose(); // Elimina el objeto en memoria (cierra la ventana)
	}
	
	private void clearField() {
		txtUsuario.setText("");
		txtPassword.setText("");
	}
	
}
