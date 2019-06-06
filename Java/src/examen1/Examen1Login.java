package examen1;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.SwingConstants;

public class Examen1Login extends JFrame implements ActionListener, FocusListener{

	// Necesidades pervias
	private static final long serialVersionUID = 4923947275106098399L;
	private JPanel contenedor;
	private JPanel panelLogin;
	private JLabel lblUsuario;
	private JLabel lblPassword;
	private JLabel lblMensaje;
	private JTextField txtUsuario;
	private JPasswordField passwordField;
	
	private int intentos = 3;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Examen1Login frame = new Examen1Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// Metodo de la interfaz grafica
	public Examen1Login() {
		setTitle("Examen de Daniel Mosquera");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 651, 114);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
		
		panelLogin = new JPanel();
		contenedor.add(panelLogin, BorderLayout.NORTH);
		
		lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelLogin.add(lblUsuario);
		
		txtUsuario = new JTextField();
		txtUsuario.addActionListener(this);
		txtUsuario.addFocusListener(this);
		panelLogin.add(txtUsuario);
		txtUsuario.setColumns(10);
		
		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panelLogin.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.addActionListener(this);
		passwordField.addFocusListener(this);
		passwordField.setText("*****");
		panelLogin.add(passwordField);
		
		lblMensaje = new JLabel("Listo");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblMensaje.setHorizontalAlignment(SwingConstants.CENTER);
		contenedor.add(lblMensaje, BorderLayout.SOUTH);
	}
	
	private void login() {
		// Necesidades previas
		String user = "daniel";
		String password = "mosquera";
		String txtPassword = new String (passwordField.getPassword());
		
		if (txtUsuario.getText().equals(user) && txtPassword.equals(password)) {
			Examen1Menu frame = new Examen1Menu();
			frame.setVisible(true);
			frame.setTitle("Bienvenido: "+user);
			dispose();
		} else {
			intentos --;
			lblMensaje.setText("Error.Los datos no son correctos. Le quedan "+intentos+".");
		}
		
		if (intentos == 0) {
			System.exit(0);
		}
	}

	@Override
	public void focusGained(FocusEvent fe) {
		JTextComponent jtc = (JTextComponent) fe.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(jtc.getText().length());
	}

	@Override
	public void focusLost(FocusEvent fe) {
		JTextComponent jtc = (JTextComponent) fe.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(0);
	}

	@Override
	public void actionPerformed(ActionEvent ap) {
		login();
	}

}
