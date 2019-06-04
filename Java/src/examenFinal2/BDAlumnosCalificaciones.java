package examenFinal2;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;

public class BDAlumnosCalificaciones extends JFrame {

	// Necesidades previas
	private static final long serialVersionUID = 8417722061589465918L;
	private JPanel contenedor;

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
		setBounds(100, 100, 664, 406);
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
	}

}
