package examenFinal1;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.BoxLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExamenFinal1Primos extends JFrame implements ActionListener, FocusListener{

	private static final long serialVersionUID = -7738502548771528496L;

	private JPanel contenedor;
	private JLabel lblNumero;
	private JPanel panelDatos;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	private JTextField txtNumero;
	private JScrollPane scrollPanePrimos;
	private JPanel panelEstado;
	private JLabel lblPrimos;
	private JLabel lblEstadoPrimos;
	private JPanel panelListas;
	private JLabel label;
	// Lista 
	private JList<Integer> lstPrimos;
	// Modelo de datos de la lista
	private DefaultListModel<Integer> dlmPrimos;
	
	private boolean modificado = false;
	private boolean comprobado = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamenFinal1Primos frame = new ExamenFinal1Primos();
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
	public ExamenFinal1Primos() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if (modificado == true) {
					guardarDatos();
					JOptionPane.showMessageDialog(contenedor,(String)"Hmmm. Se ha creado el fichero correctamente.",":)",JOptionPane.ERROR_MESSAGE,null);
				}
				// Cerrar aplicaion
				System.exit(0);
			}
			@Override
			public void windowOpened(WindowEvent e) {
				cargarDatos();
			}
		});
		setTitle("ExamenFinal1Primos");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 639, 336);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
		
		panelDatos = new JPanel();
		contenedor.add(panelDatos, BorderLayout.NORTH);
		
		lblNumero = new JLabel("Numero");
		panelDatos.add(lblNumero);
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
	  
		txtNumero = new JTextField();
		txtNumero.addActionListener(this);
		txtNumero.addFocusListener(this);
		txtNumero.setHorizontalAlignment(SwingConstants.RIGHT);
		txtNumero.setText("0");
		panelDatos.add(txtNumero);
		txtNumero.setColumns(10);
		  
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnInsertar();
			}
		});
		panelDatos.add(btnInsertar);
		  
		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBorrar();
			}
		});
		panelDatos.add(btnBorrar);
		  
		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLimpiar();
			}
		});
		panelDatos.add(btnLimpiar);
		
		// creo el modelo de datos de la lista
		dlmPrimos = new DefaultListModel<>();
		
		panelEstado = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEstado.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contenedor.add(panelEstado, BorderLayout.SOUTH);
		
		lblPrimos = new JLabel("Estado Primos:");
		panelEstado.add(lblPrimos);
		
		lblEstadoPrimos = new JLabel("Datos Sin Modificar");
		lblEstadoPrimos.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelEstado.add(lblEstadoPrimos);
		
		panelListas = new JPanel();
		contenedor.add(panelListas, BorderLayout.CENTER);
		panelListas.setLayout(new BoxLayout(panelListas, BoxLayout.X_AXIS));
		
		// lstPrimos
		lstPrimos = new JList<>();
		scrollPanePrimos = new JScrollPane(lstPrimos);
		panelListas.add(scrollPanePrimos);
		lstPrimos.setModel(dlmPrimos);
		
		label = new JLabel("");
		panelListas.add(label);

	}
	
	// Metodo agregar un numero
	private void btnInsertar() {
		// Necesidades previas
		int num = Integer.parseInt(txtNumero.getText());
		int num2 = 0;
		boolean primo = false;
		
		// Resto al numero divisible un numero
		num2 = num - 1;
		while ((num % num2) != 0) {
			num2--;
		}
		
		if (num2 == 1) {
			primo = true;
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Error. Ese no es un numero primo.","Error",JOptionPane.ERROR_MESSAGE,null);
		}
		// Recorro la lista
		for (int i = 0; i < dlmPrimos.size(); i++) {
			// Compruebo el DNI
			if (dlmPrimos.get(i).equals(num)) {
				// Salida de mensaje
				JOptionPane.showMessageDialog(contenedor,(String)"Error. Ya hay un numero con ese valor.","Error",JOptionPane.ERROR_MESSAGE,null);
				// Modifico el boolean de comprobacion
				comprobado = true;
				break;
			}
		}
		// Condicion de comprobacion
		if (comprobado == false && primo == true) {
			// Añado la persona al JList
			dlmPrimos.addElement(new Integer(num));
			// Cambio el lblTexto
			lblEstadoPrimos.setText("Datos modificados");
			// Cambio el valor de modificado
			modificado = true;
		}
		
	}
	
	// Metodo para borrar la linea seleccionada
	private void btnBorrar() {
		if (!dlmPrimos.isEmpty()) {
			// Creo un int que recoja la posicion seleccionada
			int[] p = lstPrimos.getSelectedIndices();
			// Creo un int que recoja el array de opciones
			int n = p.length;
			
			if (n > 0) {
				// Elimino la fila seleccionada recogida con el int
				for (int i = p.length-1; i >= 0; i--) {
					// Eliminar personas seleccionadas
					dlmPrimos.remove(p[i]);
				}
				// Cambiar lblTexto
				lblEstadoPrimos.setText("Datos modificados");
				modificado = true;
			}
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Error. La lista ya esta limpia","Error",JOptionPane.ERROR_MESSAGE,null);
		}
		
	}
	
	// Metodo para limpiar la lista
	private void btnLimpiar() {
		// Comprobar la lista
		if (!dlmPrimos.isEmpty()) {
			// Poner el contador de filas a 0
			dlmPrimos.removeAllElements();
			// Salida de texto
			JOptionPane.showMessageDialog(contenedor,(String)"Se han limpiado correctamente los datos",":)",JOptionPane.ERROR_MESSAGE,null);
			// Cambiar lblTexto
			lblEstadoPrimos.setText("Datos modificados");
			// Cambio el valor de modificado
			modificado = true;
		} else {
			JOptionPane.showMessageDialog(contenedor,(String)"Error. La lista ya esta limpia","Error",JOptionPane.ERROR_MESSAGE,null);
		}
		
	}
	
	// Metodo para guardar los datos
	private void guardarDatos() {
		// Grabo los datos en primos.ser
		FileOutputStream fos;
		ObjectOutputStream oos;
		
		if (modificado == true){
			try {
				// Creo la salida para guardar el texto
				fos = new FileOutputStream("primos.ser");
				oos = new ObjectOutputStream (fos);
				// Recorro el ArrayList
				for (int i = 0; i < dlmPrimos.size(); i++) {
					// lo grabo
					oos.writeObject(dlmPrimos.getElementAt(i));
				}
				// cierro el fichero
				oos.close();
				fos.close();
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Metodo para cargar los datos
	private void cargarDatos() {
		// Necesidades previas
		FileInputStream fis;
		ObjectInputStream ois;
		
		try {
			fis = new FileInputStream("primos.ser");
			ois = new ObjectInputStream(fis);
			
			int valor;
			
			while (fis.available() > 0) {
				valor = (Integer) ois.readObject();
				// agregar lso valores
				dlmPrimos.addElement(valor);
			}
			
			// cierro los recursos utilizados
			ois.close();
			fis.close();
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(contenedor,(String)"Error. No hay ningun archivo","Error",JOptionPane.ERROR_MESSAGE,null);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	// Metodos de implements
	@Override
	public void actionPerformed(ActionEvent arg0) {
		btnInsertar();
		
	}

	@Override
	public void focusGained(FocusEvent arg0) {
		JTextComponent jtc = (JTextComponent) arg0.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(jtc.getText().length());
		
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		JTextComponent jtc = (JTextComponent) arg0.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(0);
		
	}

}
