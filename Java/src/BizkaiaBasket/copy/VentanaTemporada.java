package BizkaiaBasket.copy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VentanaTemporada extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tblClasificacion;
	private JTable tblEstadisticas;
	private JPanel panelTemporada;
	private JButton btnVolver;
	private JLabel lblClayEst;
	private JLabel lblFondo;
	private JScrollPane scpVClasificacion;

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

	public VentanaTemporada() {
		setTitle("Ventana Temporada");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 510);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelTemporada = new JPanel();
		panelTemporada.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panelTemporada, BorderLayout.CENTER);
		panelTemporada.setLayout(null);

		btnVolver = new JButton("");
		btnVolver.setIcon(new ImageIcon(VentanaTemporada.class.getResource("/BizkaiaBasket/arrowleft.png")));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnVolver();
			}
		});
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(0, 0, 48, 36);
		panelTemporada.add(btnVolver);

		lblClayEst = new JLabel("Clasificacion y Estadisticas");
		lblClayEst.setHorizontalAlignment(SwingConstants.CENTER);
		lblClayEst.setForeground(Color.WHITE);
		lblClayEst.setFont(new Font("Arial", Font.BOLD, 20));
		lblClayEst.setBackground(Color.WHITE);
		lblClayEst.setBounds(21, 48, 375, 24);
		panelTemporada.add(lblClayEst);

		JScrollPane scpVEstadistica = new JScrollPane();
		scpVEstadistica.setBounds(53, 270, 499, 168);
		panelTemporada.add(scpVEstadistica);

		tblEstadisticas = new JTable();
		scpVEstadistica.setViewportView(tblEstadisticas);
		tblEstadisticas.setShowHorizontalLines(false);
		tblEstadisticas.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null }, },
				new String[] { "Equipo", "Falta C", "Falta R", "Triple C", "Triple R", "Cambios" }));
		tblEstadisticas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tblEstadisticas.setShowVerticalLines(true);
		tblEstadisticas.setBorder(new EmptyBorder(5, 5, 5, 5));
		tblEstadisticas.setBackground(new Color(233, 150, 122));

		scpVClasificacion = new JScrollPane();
		scpVClasificacion.setBounds(53, 99, 499, 168);
		panelTemporada.add(scpVClasificacion);

		tblClasificacion = new JTable();
		scpVClasificacion.setViewportView(tblClasificacion);
		tblClasificacion.setShowHorizontalLines(false);
		tblClasificacion.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null }, { null, null, null, null, null, null, null }, },
				new String[] { "Equipo", "PJ", "PG", "PP", "NP", "TTS", "PTS" }));
		tblClasificacion.getColumnModel().getColumn(0).setPreferredWidth(124);
		tblClasificacion.setShowVerticalLines(true);
		tblClasificacion.setBorder(new EmptyBorder(5, 5, 5, 5));
		tblClasificacion.setBackground(new Color(233, 150, 122));

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaTemporada.class.getResource("/BizkaiaBasket/Fondo.png")));
		lblFondo.setBounds(0, 0, 604, 481);
		panelTemporada.add(lblFondo);
	}

	private void BtnVolver() {

		GUsuarios.IrAPrincipal();
		//AbrirVentanas.vePObservador();
		dispose(); // Elimina el objeto en memoria (cierra la ventana)

	}
}
