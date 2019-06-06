package examen1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Examen1Menu extends JFrame {

	// Necesidades previas
	private static final long serialVersionUID = 5215068799520615230L;
	private JPanel contentPane;

	// Metodo de la interfaz grafica
	public Examen1Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
