package examenFinal2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;

public class BDAlumnosCalificaciones extends JFrame {

	// Necesidades previas
	private static final long serialVersionUID = 8417722061589465918L;
	private JPanel contenedor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BDAlumnosCalificaciones frame = new BDAlumnosCalificaciones();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public BDAlumnosCalificaciones() {
		setTitle("BDAlumnosCalificaciones");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 664, 439);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
		
		JPanel panelNavegacion = new JPanel();
		contenedor.add(panelNavegacion, BorderLayout.NORTH);
		
		JButton btnPrimero = new JButton("<<");
		panelNavegacion.add(btnPrimero);
		
		JButton btnAnterior = new JButton("<");
		panelNavegacion.add(btnAnterior);
		
		JLabel lblRegistros = new JLabel("No hay registros");
		panelNavegacion.add(lblRegistros);
		
		JButton btnSiguiente = new JButton(">");
		panelNavegacion.add(btnSiguiente);
		
		JButton btnUltimo = new JButton(">>");
		panelNavegacion.add(btnUltimo);
		
		JPanel panelBotones = new JPanel();
		contenedor.add(panelBotones, BorderLayout.SOUTH);
		
		JButton btnInsertar = new JButton("Insertar");
		panelBotones.add(btnInsertar);
		
		JButton btnBorrar = new JButton("Borrar");
		panelBotones.add(btnBorrar);
		
		JButton btnActualizar = new JButton("Actualizar");
		panelBotones.add(btnActualizar);
		
		JButton btnSalir = new JButton("Salir");
		panelBotones.add(btnSalir);
		
		JPanel panelInformacion = new JPanel();
		contenedor.add(panelInformacion, BorderLayout.CENTER);
		panelInformacion.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCampos = new JPanel();
		panelInformacion.add(panelCampos, BorderLayout.NORTH);
		GridBagLayout gbl_panelCampos = new GridBagLayout();
		gbl_panelCampos.columnWidths = new int[]{0, 0, 548, 0};
		gbl_panelCampos.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panelCampos.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCampos.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelCampos.setLayout(gbl_panelCampos);
		
		JLabel label = new JLabel("Matr\u00EDcula");
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.anchor = GridBagConstraints.EAST;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 1;
		gbc_label.gridy = 1;
		panelCampos.add(label, gbc_label);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.LEFT);
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.anchor = GridBagConstraints.NORTH;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		panelCampos.add(textField, gbc_textField);
		
		JLabel label_1 = new JLabel("Marca");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.EAST;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 1;
		gbc_label_1.gridy = 2;
		panelCampos.add(label_1, gbc_label_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.LEFT);
		textField_1.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		panelCampos.add(textField_1, gbc_textField_1);
		
		JLabel label_2 = new JLabel("Modelo");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 1;
		gbc_label_2.gridy = 3;
		panelCampos.add(label_2, gbc_label_2);
		
		textField_2 = new JTextField();
		textField_2.setHorizontalAlignment(SwingConstants.LEFT);
		textField_2.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		panelCampos.add(textField_2, gbc_textField_2);
		
		JPanel panelTabla = new JPanel();
		panelInformacion.add(panelTabla, BorderLayout.SOUTH);
		panelTabla.setLayout(new CardLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panelTabla.add(scrollPane, "name_12698953723385");
	}

}
