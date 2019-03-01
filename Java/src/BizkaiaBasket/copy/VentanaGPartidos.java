package BizkaiaBasket.copy;

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
import javax.swing.SwingConstants;

public class VentanaGPartidos extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelFondo;
	private JTable tblGPartidos;
	private JScrollPane scpGPartidos;
	private static JTextField txtCodigo;
	private static JTextField txtEquipo1;
	private static JTextField txtEquipo2;
	private static JTextField txtFecha;
	private JLabel lblGPartidos;
	private JLabel lblFondo;
	private JButton btnEliminar;
	private JButton btnModificar;
	private JButton btnCrear;
	private JButton btnVolver;
	private static JTextField txtFaltasLocal;
	private static JTextField txtFaltasVisitante;
	private static JTextField txtTriplesLocal;
	private static JTextField txtPuntosVisitante;
	private static JTextField txtPuntosLocal;
	private static JTextField txtTriplesVisitante;

	
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
		
		txtTriplesVisitante = new JTextField();
		txtTriplesVisitante.setText("Triples Visitante");
		txtTriplesVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		txtTriplesVisitante.setColumns(10);
		txtTriplesVisitante.setBounds(298, 367, 90, 28);
		panelFondo.add(txtTriplesVisitante);
		
		txtPuntosVisitante = new JTextField();
		txtPuntosVisitante.setText("Pts. Visitante");
		txtPuntosVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntosVisitante.setColumns(10);
		txtPuntosVisitante.setBounds(471, 367, 90, 28);
		panelFondo.add(txtPuntosVisitante);
		
		txtPuntosLocal = new JTextField();
		txtPuntosLocal.setText("Pts. Local");
		txtPuntosLocal.setHorizontalAlignment(SwingConstants.CENTER);
		txtPuntosLocal.setColumns(10);
		txtPuntosLocal.setBounds(382, 367, 90, 28);
		panelFondo.add(txtPuntosLocal);
		
		txtTriplesLocal = new JTextField();
		txtTriplesLocal.setText("Triples Local");
		txtTriplesLocal.setHorizontalAlignment(SwingConstants.CENTER);
		txtTriplesLocal.setColumns(10);
		txtTriplesLocal.setBounds(196, 367, 90, 28);
		panelFondo.add(txtTriplesLocal);
		
		txtFaltasVisitante = new JTextField();
		txtFaltasVisitante.setText("Faltas Visitante");
		txtFaltasVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		txtFaltasVisitante.setColumns(10);
		txtFaltasVisitante.setBounds(114, 367, 90, 28);
		panelFondo.add(txtFaltasVisitante);
		
		txtFaltasLocal = new JTextField();
		txtFaltasLocal.setText("Faltas Local");
		txtFaltasLocal.setHorizontalAlignment(SwingConstants.CENTER);
		txtFaltasLocal.setColumns(10);
		txtFaltasLocal.setBounds(25, 367, 90, 28);
		panelFondo.add(txtFaltasLocal);

		lblGPartidos = new JLabel("Gesti\u00F3n de Partidos");
		lblGPartidos.setForeground(Color.WHITE);
		lblGPartidos.setFont(new Font("SansSerif", Font.PLAIN, 20));
		lblGPartidos.setBounds(129, 44, 220, 39);
		panelFondo.add(lblGPartidos);

		txtCodigo = new JTextField();
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);
		txtCodigo.setText("C\u00F3digo");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(75, 323, 107, 28);
		panelFondo.add(txtCodigo);

		txtEquipo1 = new JTextField();
		txtEquipo1.setText("Equipo Local");
		txtEquipo1.setHorizontalAlignment(SwingConstants.CENTER);
		txtEquipo1.setColumns(10);
		txtEquipo1.setBounds(180, 323, 107, 28);
		panelFondo.add(txtEquipo1);

		txtEquipo2 = new JTextField();
		txtEquipo2.setText("Equipo Visitante");
		txtEquipo2.setHorizontalAlignment(SwingConstants.CENTER);
		txtEquipo2.setColumns(10);
		txtEquipo2.setBounds(298, 323, 107, 28);
		panelFondo.add(txtEquipo2);

		txtFecha = new JTextField();
		txtFecha.setText("Fecha");
		txtFecha.setHorizontalAlignment(SwingConstants.CENTER);
		txtFecha.setColumns(10);
		txtFecha.setBounds(395, 323, 107, 28);
		panelFondo.add(txtFecha);

		btnEliminar = new JButton("Eliminar");
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 12));
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setBounds(402, 431, 89, 39);
		panelFondo.add(btnEliminar);

		btnModificar = new JButton("Modificar");
		btnModificar.setFont(new Font("Arial", Font.BOLD, 12));
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setBounds(256, 431, 89, 39);
		panelFondo.add(btnModificar);

		btnCrear = new JButton("Crear");
		btnCrear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GPartidos.CrearPartido(Integer.parseInt(txtCodigo.getText()), txtEquipo1.getText(), txtEquipo2.getText(), txtFecha.getText(), Integer.parseInt(txtFaltasLocal.getText()),
						Integer.parseInt(txtFaltasVisitante.getText()), Integer.parseInt(txtTriplesLocal.getText()), Integer.parseInt(txtTriplesVisitante.getText()), 
						Integer.parseInt(txtPuntosLocal.getText()), Integer.parseInt(txtPuntosVisitante.getText()));
				Limpiar();
			}
		});
		btnCrear.setFont(new Font("Arial", Font.BOLD, 12));
		btnCrear.setBackground(Color.WHITE);
		btnCrear.setBounds(105, 431, 95, 39);
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
		scpGPartidos.setBounds(23, 84, 557, 228);
		panelFondo.add(scpGPartidos);

		tblGPartidos = new JTable();
		tblGPartidos.setModel(new PartidosTableModel());
		tblGPartidos.setEnabled(false);
		scpGPartidos.setViewportView(tblGPartidos);
		tblGPartidos.setBorder(new EmptyBorder(5, 5, 5, 5));
		tblGPartidos.setBackground(new Color(233, 150, 122));
		tblGPartidos.setModel(GPartidos.partidos);

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaGPartidos.class.getResource("/BizkaiaBasket/Fondo.png")));
		lblFondo.setBounds(0, 0, 604, 481);
		panelFondo.add(lblFondo);
	}

	private void BtnVolver() {
		GUsuarios.IrAPrincipal();
		dispose();

	}

	private void Limpiar() {
		
		txtCodigo.setText("");
		txtEquipo1.setText("");
		txtEquipo2.setText("");
		txtFecha.setText("");
		txtFaltasLocal.setText("");
		txtFaltasVisitante.setText("");
		txtTriplesLocal.setText("");
		txtTriplesVisitante.setText("");
		txtPuntosLocal.setText("");
		txtPuntosVisitante.setText("");
			
	}
	
	public static int getTxtCodigo() {
		return Integer.parseInt(txtCodigo.getText());
	}


	public static String getTxtEquipoloc() {
		return txtEquipo1.getText();
	}


	public static String getTxtEquipovis() {
		return txtEquipo2.getText();
	}


	public static String getTxtFecha() {
		return txtFecha.getText();
	}


	public static int getTxtFaltasloc() {
		return Integer.parseInt(txtFaltasLocal.getText());
	}


	public static int getTxtFaltasvis() {
		return Integer.parseInt(txtFaltasVisitante.getText());
	}


	public static int getTxtTriplesloc() {
		return Integer.parseInt(txtTriplesLocal.getText());
	}


	public static int getTxtPuntosvis() {
		return Integer.parseInt(txtPuntosVisitante.getText());
	}


	public static int getTxtPuntosloc() {
		return Integer.parseInt(txtPuntosLocal.getText());
	}


	public static int getTxtTriplesvis() {
		return Integer.parseInt(txtTriplesVisitante.getText());
	}
	

}
