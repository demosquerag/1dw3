package evaluacion2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class JFArrayPerson extends JFrame {

	// MAIN DE INICIO DE LA APLICACION
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFArrayPerson frame = new JFArrayPerson();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// OBJETOS/ELEMENTOS Y SERIAL
	private static final long serialVersionUID = -1547704899295089470L;
	private JPanel pnlPrincipal;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JLabel lblNombre;
	private JLabel lblApellido;
	private JTable tblArray;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnMostrar;
	private JButton btnBuscar;
	private JScrollPane scpPrincipal;

	// CLASE PUBLICA CON LOS COMPONENTES
	public JFArrayPerson() {
		setResizable(false);
		setTitle("JFrameArray_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 421, 400);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
		lblNombre.setBounds(10, 21, 88, 22);
		pnlPrincipal.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.BOLD, 18));
		lblApellido.setBounds(10, 57, 88, 22);
		pnlPrincipal.add(lblApellido);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.BOLD, 11));
		txtApellido.setBounds(128, 57, 86, 20);
		pnlPrincipal.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.BOLD, 11));
		txtNombre.setBounds(128, 24, 86, 20);
		pnlPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnInsertar.setBounds(10, 167, 89, 23);
		pnlPrincipal.add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnEliminar.setBounds(109, 167, 89, 23);
		pnlPrincipal.add(btnEliminar);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnMostrar.setBounds(208, 167, 89, 23);
		pnlPrincipal.add(btnMostrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.PLAIN, 11));
		btnBuscar.setBounds(307, 167, 89, 23);
		pnlPrincipal.add(btnBuscar);
		
		scpPrincipal = new JScrollPane();
		scpPrincipal.setBounds(10, 218, 395, 142);
		pnlPrincipal.add(scpPrincipal);
		
		tblArray = new JTable();
		tblArray.setFont(new Font("Arial", Font.PLAIN, 12));
		tblArray.setShowVerticalLines(false);
		scpPrincipal.setViewportView(tblArray);
	}
}
