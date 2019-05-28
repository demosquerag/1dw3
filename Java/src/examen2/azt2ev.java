package examen2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class azt2ev extends JFrame implements ActionListener {

	private static final long serialVersionUID = -4599738649814272259L;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					azt2ev frame = new azt2ev();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// Necesidades previas
	private JPanel PanelPrincipal;
	private JPanel azt2JListJugadores;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellido1;
	private JLabel lblApellido2;
	private JLabel lblEquipo;
	private JLabel lblDorsal;
	private JTextField txtDNI;
	private JTextField txtNombre;
	private JTextField txtApellido1;
	private JTextField txtApellido2;
	private JTextField txtEquipo;
	private JTextField txtDorsal;
	private JButton btnGuardar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JList<String> lstJugadores;

	// Modelo de lista
	DefaultListModel<String> lstar = new DefaultListModel<>();
	
	// ArrayListJugadores
	ArrayList<claseJugador> ALJugadores = new ArrayList<claseJugador>();
	
	public azt2ev() {
		setTitle("Azt2ebListJugadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1254, 300);
		PanelPrincipal = new JPanel();
		PanelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		PanelPrincipal.setLayout(new BorderLayout(0, 0));
		setContentPane(PanelPrincipal);
		
		azt2JListJugadores = new JPanel();
		PanelPrincipal.add(azt2JListJugadores, BorderLayout.CENTER);
		azt2JListJugadores.setLayout(null);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDni.setHorizontalAlignment(SwingConstants.CENTER);
		lblDni.setBounds(10, 11, 46, 14);
		azt2JListJugadores.add(lblDni);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 11));
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setBounds(157, 11, 46, 14);
		azt2JListJugadores.add(lblNombre);
		
		lblApellido1 = new JLabel("Apellido1");
		lblApellido1.setFont(new Font("Arial", Font.PLAIN, 11));
		lblApellido1.setBounds(309, 11, 46, 14);
		azt2JListJugadores.add(lblApellido1);
		
		lblApellido2 = new JLabel("Apellido2");
		lblApellido2.setFont(new Font("Arial", Font.PLAIN, 11));
		lblApellido2.setHorizontalAlignment(SwingConstants.CENTER);
		lblApellido2.setBounds(461, 11, 46, 14);
		azt2JListJugadores.add(lblApellido2);
		
		lblEquipo = new JLabel("Equipo");
		lblEquipo.setFont(new Font("Arial", Font.PLAIN, 11));
		lblEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo.setBounds(613, 11, 46, 14);
		azt2JListJugadores.add(lblEquipo);
		
		lblDorsal = new JLabel("Dorsal");
		lblDorsal.setFont(new Font("Arial", Font.PLAIN, 11));
		lblDorsal.setHorizontalAlignment(SwingConstants.CENTER);
		lblDorsal.setBounds(765, 11, 46, 14);
		azt2JListJugadores.add(lblDorsal);
		
		txtDNI = new JTextField();
		txtDNI.addActionListener(this);
		txtDNI.setBounds(61, 8, 86, 20);
		azt2JListJugadores.add(txtDNI);
		txtDNI.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.addActionListener(this);
		txtNombre.setBounds(213, 8, 86, 20);
		azt2JListJugadores.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido1 = new JTextField();
		txtApellido1.addActionListener(this);
		txtApellido1.setBounds(365, 8, 86, 20);
		azt2JListJugadores.add(txtApellido1);
		txtApellido1.setColumns(10);
		
		txtApellido2 = new JTextField();
		txtApellido2.addActionListener(this);
		txtApellido2.setBounds(517, 8, 86, 20);
		azt2JListJugadores.add(txtApellido2);
		txtApellido2.setColumns(10);
		
		txtEquipo = new JTextField();
		txtEquipo.addActionListener(this);
		txtEquipo.setBounds(669, 8, 86, 20);
		azt2JListJugadores.add(txtEquipo);
		txtEquipo.setColumns(10);
		
		txtDorsal = new JTextField();
		txtDorsal.addActionListener(this);
		txtDorsal.setBounds(821, 8, 86, 20);
		azt2JListJugadores.add(txtDorsal);
		txtDorsal.setColumns(10);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGuardar();
			}
		});
		btnGuardar.setBounds(917, 7, 89, 23);
		azt2JListJugadores.add(btnGuardar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorrar();
			}
		});
		btnBorrar.setBounds(1016, 7, 89, 23);
		azt2JListJugadores.add(btnBorrar);
		
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLimpiar();
			}
		});
		btnLimpiar.setBounds(1115, 7, 89, 23);
		azt2JListJugadores.add(btnLimpiar);
		
		lstJugadores = new JList<>();
		lstJugadores.setBounds(10, 53, 1208, 187);
		azt2JListJugadores.add(lstJugadores);
		lstJugadores.setModel(lstar);
	}
	
	// Guardar datos desde campo de texto
	@Override
	public void actionPerformed(ActionEvent e) {
		btnGuardar();
	}
	
	// Constructor para guardar jugadores
	private void btnGuardar() {
		// Agregar nuevo jugador al array cogiendo los txtFields
		claseJugador jugador = new claseJugador();
		jugador.setDni(txtDNI.getText());
		jugador.setNombre(txtNombre.getText());
		jugador.setApellido1(txtApellido1.getText());
		jugador.setApellido2(txtApellido2.getText());
		jugador.setEquipo(txtEquipo.getText());
		jugador.setDorsal(Integer.parseInt(txtDorsal.getText()));
		
		// Comprobar si la persona existe e insertarla
		if (!ALJugadores.contains(jugador)) {
			// Agregar el jugador al ArrayList
			ALJugadores.add(jugador);
			// Agregar el jugador al JList
			lstar.addElement(jugador.toString());
			// Salida de txt por consola
			System.out.println("El/La jugador/a ( "+jugador+" ) se ha añadido.");
		}
		else {
			// Salida de txt por consola
			System.out.println("Ese/a jugador/a ya existe.");
		}
		// Limpiar los campos
		ClearField();
	}
	
	// Constructor para borrar jugadores
	private void btnBorrar() {
		// Elimanar campo seleccionado
		int eli = lstJugadores.getSelectedIndex();
		lstar.remove(eli);
		// Limpiar campos de texto
		ClearField();
	}
	
	// Metodo para borrar el arraylist
	private void btnLimpiar() {
		// Eliminar jugadorers del array
		ALJugadores.removeAll(ALJugadores);
		// Limpar JList
		lstar.clear();
		// Se ha limpado el Arraylist
		System.out.println("Se ha limpado el array ALjugadores.");
	}
	
	// Metodo para borar datos de los textfuields
	private void ClearField() {
		// Limpiar los campos de texto
		txtDNI.setText("");
		txtNombre.setText("");
		txtApellido1.setText("");
		txtApellido2.setText("");
		txtEquipo.setText("");
		txtDorsal.setText("");
	}
	
}
