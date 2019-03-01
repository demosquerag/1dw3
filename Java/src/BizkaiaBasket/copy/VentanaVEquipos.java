package BizkaiaBasket.copy;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class VentanaVEquipos extends JFrame {

	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelVEquipos;
	private JButton btnVolver;
	private JLabel lblVEquipos;
	private JTable tblVEquipos;
	private JLabel lblFondo;
	private JScrollPane scpVEquipos;

	
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

	
	public VentanaVEquipos() {
		setResizable(false);
		setTitle("Ventana Ver Equipos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 610, 510);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelVEquipos = new JPanel();
		contentPane.add(panelVEquipos, BorderLayout.CENTER);
		panelVEquipos.setLayout(null);

		btnVolver = new JButton("");
		btnVolver.setSelectedIcon(new ImageIcon(VentanaVEquipos.class.getResource("/BizkaiaBasket/arrowleft.png")));
		btnVolver.setIcon(new ImageIcon(VentanaVEquipos.class.getResource("/BizkaiaBasket/arrowleft.png")));
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BtnVolver();
			}
		});
		btnVolver.setFont(new Font("Arial", Font.BOLD, 20));
		btnVolver.setBackground(Color.WHITE);
		btnVolver.setBounds(0, 0, 48, 36);
		panelVEquipos.add(btnVolver);

		lblVEquipos = new JLabel("Equipos");
		lblVEquipos.setHorizontalAlignment(SwingConstants.CENTER);
		lblVEquipos.setForeground(Color.WHITE);
		lblVEquipos.setFont(new Font("Arial", Font.BOLD, 20));
		lblVEquipos.setBackground(Color.WHITE);
		lblVEquipos.setBounds(21, 48, 375, 24);
		panelVEquipos.add(lblVEquipos);

		scpVEquipos = new JScrollPane();
		scpVEquipos.setBounds(53, 99, 499, 332);
		panelVEquipos.add(scpVEquipos);

		tblVEquipos = new JTable();
		scpVEquipos.setViewportView(tblVEquipos);
		tblVEquipos.setFillsViewportHeight(true);
		tblVEquipos.setShowGrid(false);
		tblVEquipos.setEnabled(false);
		tblVEquipos.setRowSelectionAllowed(false);
		tblVEquipos.setShowVerticalLines(true);
		tblVEquipos.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null }, },
				new String[] { "Codigo", "Nombre", "Municipio", "E-mail", "Terreno Juego" }));
		tblVEquipos.getColumnModel().getColumn(0).setPreferredWidth(67);
		tblVEquipos.getColumnModel().getColumn(1).setPreferredWidth(100);
		tblVEquipos.getColumnModel().getColumn(2).setPreferredWidth(105);
		tblVEquipos.getColumnModel().getColumn(3).setPreferredWidth(159);
		tblVEquipos.getColumnModel().getColumn(4).setPreferredWidth(162);
		tblVEquipos.setBorder(new EmptyBorder(5, 5, 5, 5));
		tblVEquipos.setBackground(new Color(233, 150, 122));

		lblFondo = new JLabel("");
		lblFondo.setIcon(new ImageIcon(VentanaVEquipos.class.getResource("/BizkaiaBasket/Fondo.png")));
		lblFondo.setBounds(0, 0, 604, 481);
		panelVEquipos.add(lblFondo);
	}

	private void BtnVolver() {
		GUsuarios.IrAPrincipal();
		dispose();

	}
	
}
