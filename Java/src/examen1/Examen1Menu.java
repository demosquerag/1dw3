package examen1;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Examen1Menu extends JFrame {

	// Necesidades previas
	private static final long serialVersionUID = 5215068799520615230L;
	private JPanel contenedor;
	private JPanel panelBotones;
	private JLabel lblResultado;
	private JTextField txtTexto;
	private JButton btnPrimo;
	private JButton btnCircunferencia;
	private JButton btnMultiplos;
	private JButton btnParimpar;

	// Metodo de la interfaz grafica
	public Examen1Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
		
		txtTexto = new JTextField();
		txtTexto.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtTexto.setHorizontalAlignment(SwingConstants.RIGHT);
		contenedor.add(txtTexto, BorderLayout.NORTH);
		txtTexto.setColumns(10);
		
		lblResultado = new JLabel("Resultado");
		lblResultado.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
		contenedor.add(lblResultado, BorderLayout.SOUTH);
		
		panelBotones = new JPanel();
		contenedor.add(panelBotones, BorderLayout.CENTER);
		panelBotones.setLayout(new GridLayout(0, 2, 0, 0));
		
		btnPrimo = new JButton("EsPrimo");
		btnPrimo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnPrimo();
			}
		});
		panelBotones.add(btnPrimo);
		
		btnCircunferencia = new JButton("Circunferencia");
		btnCircunferencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCircunferencia();
			}
		});
		panelBotones.add(btnCircunferencia);
		
		btnMultiplos = new JButton("10 Multiplos");
		btnMultiplos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMultiplos();
			}
		});
		panelBotones.add(btnMultiplos);
		
		btnParimpar = new JButton("Par o Impar");
		btnParimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnParimpar();
			}
		});
		panelBotones.add(btnParimpar);
	}
	
	// Metodo para saber si un numeor es primo o no
	private void btnPrimo() {
		// Necesidades previas
		int num = Integer.parseInt(txtTexto.getText());
		int num2 = 0;
		boolean primo = false;
		
		// Resto al numero divisible un numero
		num2 = num - 1;
		while ((num % num2) != 0) {
			num2--;
		}
		
		// Si el calculo es correcto...
		if (num2 == 1) {
			primo = true;
		}
		// Si es primo
		if (primo == true) {
			lblResultado.setText("El numero "+num+" es primo.");
		} else { // Si no...
			lblResultado.setText("El numero "+num+" no es primo.");
		}
		
	}
	
	// Metodo para hacer el calculo del area de la circunferencia
	private void btnCircunferencia() {
		// Necesidades previas
		double radio = Double.parseDouble(txtTexto.getText());
		double resultado = 0.0;
		
		// Calculo el valor del area
		resultado = Math.PI * Math.pow(radio,2);
		// imprimo el resultado en la label
		lblResultado.setText("El valor de la circunferencia de radio "+radio+ " es "+resultado+".");
	}

	// Metodo para sacar los diez primeros multiplos de un numero
	private void btnMultiplos() {
		// Necesidades previas
		double multiplo = Double.parseDouble(txtTexto.getText());
		
		// imprimo el resultado en la label
		lblResultado.setText("Los 10 primeros multiplos de "+multiplo+ " son "+multiplo*1+" "+multiplo*2
				+" "+multiplo*3+" "+multiplo*4+" "+multiplo*5+" "+multiplo*6+" "+multiplo * 7+" "+multiplo*8
				+" "+multiplo*9+" "+multiplo*10+".");
	}

	// Metodo para el calculo de numeros pares e impares
	private void btnParimpar() {
		// Necesidades previas
		int num = Integer.parseInt(txtTexto.getText());
		
		// Hacemos el calculo
		if (num %2 == 0) {
			// Sacamos resultado
			lblResultado.setText("El "+num+" es par.");
		} else {
			lblResultado.setText("El "+num+" es impar.");
		}
	}

}
