package BizkaiaBasket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VentanaVJugadores extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnVolver;
	private JLabel lblJugadores;
	private JPanel panelVJugadores;
	private JTable tblVJugadores;
	private JLabel lblFondo;
	private JScrollPane scpVJugadores;

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
	public VentanaVJugadores() {
		setResizable(false);
		setTitle("Ventana Vista Jugadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 510);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panelVJugadores = new JPanel();
		contentPane.add(panelVJugadores, BorderLayout.CENTER);
		panelVJugadores.setLayout(null);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaVJugadores.class.getResource("/BizkaiaBasket/arrowleft.png")));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnVolver();
			}
		});
		btnVolver.setBounds(0, 0, 48, 36);
		panelVJugadores.add(btnVolver);
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));

		lblJugadores = new JLabel("Jugadores");
		lblJugadores.setForeground(Color.WHITE);
		lblJugadores.setBackground(Color.WHITE);
		lblJugadores.setBounds(21, 48, 375, 24);
		panelVJugadores.add(lblJugadores);
		lblJugadores.setFont(new Font("Arial", Font.BOLD, 20));
		lblJugadores.setHorizontalAlignment(SwingConstants.CENTER);

		scpVJugadores = new JScrollPane();
		scpVJugadores.setBounds(53, 99, 499, 332);
		panelVJugadores.add(scpVJugadores);

		tblVJugadores = new JTable();
		scpVJugadores.setViewportView(tblVJugadores);
		tblVJugadores.setShowGrid(false);
		tblVJugadores.setEnabled(false);
		tblVJugadores.setRowSelectionAllowed(false);
		tblVJugadores.setToolTipText("");
		tblVJugadores.setShowVerticalLines(true);
		tblVJugadores
				.setModel(new DefaultTableModel(
						new Object[][] { { null, null, null, "" }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, { null, null, null, null },
								{ null, null, null, null }, { null, null, null, null }, },
						new String[] { "DNI", "Nombre", "Apellido", "Equipo" }));
		tblVJugadores.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblVJugadores.getColumnModel().getColumn(1).setPreferredWidth(115);
		tblVJugadores.getColumnModel().getColumn(2).setPreferredWidth(111);
		tblVJugadores.getColumnModel().getColumn(3).setPreferredWidth(98);
		tblVJugadores.setBorder(new EmptyBorder(5, 5, 5, 5));
		tblVJugadores.setBackground(new Color(233, 150, 122));

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaVJugadores.class.getResource("/BizkaiaBasket/Fondo.png")));
		lblFondo.setBounds(0, 0, 604, 481);
		panelVJugadores.add(lblFondo);
	}

	private void BtnVolver() {

		if (VentanaLogin.cusuario.equals("o")) {
			AbrirVentanas.vePObservador();
			dispose(); // Elimina el objeto en memoria (cierra la ventana)
		} else if (VentanaLogin.cusuario.equals("u")) {
			AbrirVentanas.vePUsuario();
			dispose(); // Elimina el objeto en memoria (cierra la ventana)
		}

	}
}
