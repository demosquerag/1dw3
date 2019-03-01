package BizkaiaBasket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;

public class VentanaGPartidos extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelFondo;
	private JTable tblGPartidos;
	private JScrollPane scpGPartidos;
	private JTextField txtCodigo;
	private JTextField txtEquipo1;
	private JTextField txtEquipo2;
	private JTextField txtFecha;
	private JTextField txtResultado;
	private JLabel lblGPartidos;
	private JLabel lblCodigo;
	private JLabel lblEquipo1;
	private JLabel lblEquipo2;
	private JLabel lblResultado;
	private JLabel lblFondo;
	private JLabel lblFecha;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCrear;
	private JButton btnVolver;

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
	public VentanaGPartidos() {
		setTitle("Gesti\u00F3n Partidos");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 510);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelFondo = new JPanel();
		panelFondo.setLayout(null);
		contentPane.add(panelFondo, BorderLayout.CENTER);

		lblGPartidos = new JLabel("Gesti\u00F3n de Partidos");
		lblGPartidos.setForeground(Color.WHITE);
		lblGPartidos.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblGPartidos.setBounds(129, 44, 220, 39);
		panelFondo.add(lblGPartidos);

		lblCodigo = new JLabel("C\u00F3digo");
		lblCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Arial", Font.BOLD, 15));
		lblCodigo.setBounds(32, 338, 107, 28);
		panelFondo.add(lblCodigo);

		lblEquipo1 = new JLabel("Equipo 1");
		lblEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo1.setForeground(Color.WHITE);
		lblEquipo1.setFont(new Font("Arial", Font.BOLD, 15));
		lblEquipo1.setBounds(137, 338, 106, 28);
		panelFondo.add(lblEquipo1);

		lblEquipo2 = new JLabel("Equipo 2");
		lblEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
		lblEquipo2.setForeground(Color.WHITE);
		lblEquipo2.setFont(new Font("Arial", Font.BOLD, 15));
		lblEquipo2.setBounds(242, 338, 107, 28);
		panelFondo.add(lblEquipo2);

		lblFecha = new JLabel("Fecha");
		lblFecha.setHorizontalAlignment(SwingConstants.CENTER);
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Arial", Font.BOLD, 15));
		lblFecha.setBounds(347, 339, 107, 27);
		panelFondo.add(lblFecha);

		lblResultado = new JLabel("Resultado");
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		lblResultado.setForeground(Color.WHITE);
		lblResultado.setFont(new Font("Arial", Font.BOLD, 15));
		lblResultado.setBounds(452, 338, 107, 27);
		panelFondo.add(lblResultado);

		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(32, 368, 107, 28);
		panelFondo.add(txtCodigo);

		txtEquipo1 = new JTextField();
		txtEquipo1.setColumns(10);
		txtEquipo1.setBounds(136, 368, 107, 28);
		panelFondo.add(txtEquipo1);

		txtEquipo2 = new JTextField();
		txtEquipo2.setColumns(10);
		txtEquipo2.setBounds(240, 368, 107, 28);
		panelFondo.add(txtEquipo2);

		txtFecha = new JTextField();
		txtFecha.setColumns(10);
		txtFecha.setBounds(347, 368, 107, 28);
		panelFondo.add(txtFecha);

		txtResultado = new JTextField();
		txtResultado.setColumns(10);
		txtResultado.setBounds(452, 368, 107, 28);
		panelFondo.add(txtResultado);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(402, 408, 89, 39);
		panelFondo.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.BOLD, 12));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(256, 408, 89, 39);
		panelFondo.add(btnModificar);

		btnCrear = new JButton("Crear");
		btnCrear.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrear.setBackground(Color.WHITE);
		btnCrear.setBounds(105, 408, 95, 39);
		panelFondo.add(btnCrear);

		btnVolver = new JButton("");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnVolver();
			}
		});
		btnVolver.setIcon(new ImageIcon(VentanaGPartidos.class.getResource("/BizkaiaBasket/arrowleft.png")));
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(0, 0, 48, 36);
		panelFondo.add(btnVolver);

		scpGPartidos = new JScrollPane();
		scpGPartidos.setBounds(53, 99, 499, 183);
		panelFondo.add(scpGPartidos);

		tblGPartidos = new JTable();
		tblGPartidos.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Codigo", "Equipo1", "Equipo2", "Fecha", "Resultado" }));
		tblGPartidos.setEnabled(false);
		tblGPartidos.setRowSelectionAllowed(false);
		tblGPartidos.setShowHorizontalLines(false);
		scpGPartidos.setViewportView(tblGPartidos);
		tblGPartidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		tblGPartidos.setBackground(new Color(233, 150, 122));

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaGPartidos.class.getResource("/BizkaiaBasket/Fondo.png")));
		lblFondo.setBounds(0, 0, 604, 481);
		panelFondo.add(lblFondo);
	}

	private void BtnVolver() {

		if (VentanaLogin.cusuario.equals("a")) {
			AbrirVentanas.vePAdmin();
			dispose(); // Elimina el objeto en memoria (cierra la ventana)
		} else if (VentanaLogin.cusuario.equals("u")) {
			AbrirVentanas.vePUsuario();
			dispose(); // Elimina el objeto en memoria (cierra la ventana)
		}

	}
}
