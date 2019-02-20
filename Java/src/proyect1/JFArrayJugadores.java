package proyect1;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import evaluacion2.Persona;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

public class JFArrayJugadores extends JFrame implements ActionListener {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFArrayJugadores frame = new JFArrayJugadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private static final long serialVersionUID = 4479554507802145043L;
	private JPanel pnlPrincipal;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtApellido2;
	private JTextField txtEquipo;
	private JTextField txtDorsal;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JLabel lblApellido2;
	private JLabel lblEquipo;
	private JLabel lblDorsal;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList lstAJ;

	// Crear arraylist jugadores
	ArrayList <Jugador> jugadores = new ArrayList <Jugador>();
	
	// Crear modelo de JList
	DefaultListModel lstar = new DefaultListModel<>();

	public JFArrayJugadores() {
		setResizable(false);
		setTitle("JFArrayJugadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 934, 332);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setBounds(10, 14, 46, 14);
		pnlPrincipal.add(lblDni);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(162, 14, 46, 14);
		pnlPrincipal.add(lblNombre);
		
		lblApellido = new JLabel("Apellido1");
		lblApellido.setFont(new Font("Arial", Font.PLAIN, 11));
		lblApellido.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido.setBounds(314, 14, 46, 14);
		pnlPrincipal.add(lblApellido);
		
		lblApellido2 = new JLabel("Apellido2");
		lblApellido2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblApellido2.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido2.setBounds(466, 14, 46, 14);
		pnlPrincipal.add(lblApellido2);
		
		lblEquipo = new JLabel("Equipo");
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEquipo.setBounds(618, 14, 46, 14);
		pnlPrincipal.add(lblEquipo);
		
		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDorsal.setHorizontalAlignment(SwingConstants.CENTER);
		lblDorsal.setBounds(770, 14, 46, 14);
		pnlPrincipal.add(lblDorsal);
		
		txtDni = new JTextField();
		txtDni.setBounds(66, 11, 86, 20);
		pnlPrincipal.add(txtDni);
		txtDni.setColumns(10);
		txtDni.addActionListener(this);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(218, 11, 86, 20);
		pnlPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		txtNombre.addActionListener(this);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(370, 11, 86, 20);
		pnlPrincipal.add(txtApellido);
		txtApellido.setColumns(10);
		txtApellido.addActionListener(this);
		
		txtApellido2 = new JTextField();
		txtApellido2.setBounds(522, 11, 86, 20);
		pnlPrincipal.add(txtApellido2);
		txtApellido2.setColumns(10);
		txtApellido2.addActionListener(this);
		
		txtEquipo = new JTextField();
		txtEquipo.setBounds(674, 11, 86, 20);
		pnlPrincipal.add(txtEquipo);
		txtEquipo.setColumns(10);
		txtEquipo.addActionListener(this);
		
		txtDorsal = new JTextField();
		txtDorsal.setFont(new Font("Arial", Font.PLAIN, 11));
		txtDorsal.setBounds(826, 11, 86, 20);
		pnlPrincipal.add(txtDorsal);
		txtDorsal.setColumns(10);
		txtDorsal.addActionListener(this);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnGuardar();
			}
		});
		btnGuardar.setBounds(303, 42, 89, 23);
		pnlPrincipal.add(btnGuardar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnBorrar();
			}
		});
		btnBorrar.setBounds(402, 42, 89, 23);
		pnlPrincipal.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Btnlimpiar();
			}
		});
		btnLimpiar.setBounds(501, 42, 89, 23);
		pnlPrincipal.add(btnLimpiar);
		
		lstAJ = new JList();
		lstAJ.setBounds(10, 76, 908, 214);
		pnlPrincipal.add(lstAJ);
		lstAJ.setModel(lstar);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		BtnGuardar();
		
	}
	
	private void BtnGuardar() {
		
		// Crear un nuevo jugador
		Jugador j = new Jugador();
		// Recoger lo datos de los campos de texto	
		j.setDni(txtDni.getText());
		j.setNombre(txtNombre.getText());
		j.setApellido1(txtApellido.getText());
		j.setApellido2(txtApellido2.getText());
		j.setEquipo(txtEquipo.getText());
		j.setDorsal(Integer.parseInt(txtDorsal.getText()));
		
		// Comprobar si la persona existe e insertarla
		if (!jugadores.contains(j)) {
			// Añadir jugador al array
			jugadores.add(j);
			// Añadir el jugador al JList
			lstar.addElement(j);
			
			System.out.println("Ese/a jugador/a ( "+j+" ) se ha añadido.");
		}
		else {
			System.out.println("Ese/a jugador/a ya existe.");
		}
		
		// Limpiar campos de texto
		clearField();
		
	}
	
	private void BtnBorrar() {
		
		// Crear un nuevo jugador
		Jugador j = new Jugador();
		// Recoger lo datos de los campos de texto	
		j.setDni(txtDni.getText());
		j.setNombre(txtNombre.getText());
		j.setApellido1(txtApellido.getText());
		j.setApellido2(txtApellido2.getText());
		j.setEquipo(txtEquipo.getText());
		j.setDorsal(Integer.parseInt(txtDorsal.getText()));
		
		lstar.remove(lstAJ.getSelectedIndex());
		
		// Comprobacion
		if (jugadores.contains(j)) {
			System.out.println("Ese/a jugador/a ( "+j+ " ) ha sido borrada.");
			// BORRAR LA PALABRA BUSACADA
			jugadores.remove(j);
			
		}
		else {
			System.out.println("Ese/a jugador/a ( "+j+" ) no existe.");
		}
		
		// Limpiar campos de texto
		clearField();
	}
	
	private void Btnlimpiar() {
		
		// Borrar todos los datos del array
		jugadores.removeAll(jugadores);
		
		// Borrar los datos del JList
		lstar.removeAllElements();
		
		// Salida de texto
		System.out.println("Se ha limpiado el ArrayList Jugadores.");
		// Limpiar campos de texto
		clearField();
	}
	
	private void clearField() {
		
		// Limpiar los campos de texto
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtApellido2.setText("");
		txtEquipo.setText("");
		txtDorsal.setText("");
	}
	
	
}
