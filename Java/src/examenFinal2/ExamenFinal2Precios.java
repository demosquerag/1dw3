package examenFinal2;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ExamenFinal2Precios extends JFrame implements ActionListener, FocusListener {

	private static final long serialVersionUID = -1234567890L;
	private JPanel contenedor;
	private JPanel panelDatos;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;

	private JLabel lblValor;
	private JTextField txtValor;
	private JScrollPane scrollPane;
	private JPanel panelEstado;
	private JLabel lblMedia;
	private JLabel lblMediaValor;

	private DefaultListModel<Precio> dlmPrecios;
	private JList<Precio> lstPrecios;
	private boolean modificado;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExamenFinal2Precios frame = new ExamenFinal2Precios();
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
	public ExamenFinal2Precios() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(modificado) {
					JOptionPane.showMessageDialog(contenedor,(String)"Se ha creado el fichero correctamente.",":)",JOptionPane.ERROR_MESSAGE,null);
					guardarPrecios();
				}
				// Cierro la aplicacion
				System.exit(0);
			}
		});
		setTitle("ExamenFinal2Precios");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 822, 336);

		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);

		panelDatos = new JPanel();
		contenedor.add(panelDatos, BorderLayout.NORTH);

		lblValor = new JLabel("Valor");
		panelDatos.add(lblValor);
		lblValor.setHorizontalAlignment(SwingConstants.CENTER);

		txtValor = new JTextField();
		txtValor.setHorizontalAlignment(SwingConstants.RIGHT);
		txtValor.setText("1.0");
		panelDatos.add(txtValor);
		txtValor.setColumns(10);
		txtValor.addFocusListener(this);
		txtValor.addActionListener(this);

		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(this);
		panelDatos.add(btnInsertar);

		btnBorrar = new JButton("Borrar");
		btnBorrar.addActionListener(this);
		panelDatos.add(btnBorrar);

		btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(this);
		panelDatos.add(btnLimpiar);

		scrollPane = new JScrollPane();
		contenedor.add(scrollPane, BorderLayout.CENTER);

		panelEstado = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelEstado.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contenedor.add(panelEstado, BorderLayout.SOUTH);

		lblMedia = new JLabel("Media:");
		panelEstado.add(lblMedia);

		lblMediaValor = new JLabel("0.0");
		lblMediaValor.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelEstado.add(lblMediaValor);

		// creo el modelo de datos de la lista
		dlmPrecios = new DefaultListModel<Precio>();

		lstPrecios = new JList<Precio>();
		lstPrecios.setModel(dlmPrecios);
		scrollPane = new JScrollPane(lstPrecios);
		contenedor.add(scrollPane, BorderLayout.CENTER);
		
		modificado = false;
		cargarPrecios();

	}

	// Metodos para el focus
	@Override
	public void focusGained(FocusEvent fe) {
		JTextComponent jtc = (JTextComponent) fe.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(jtc.getText().length());
	}

	@Override
	public void focusLost(FocusEvent fe) {
		JTextComponent jtc = (JTextComponent) fe.getSource();
		jtc.setSelectionStart(0);
		jtc.setSelectionEnd(0);
	}

	// Metodo para los botones
	@Override
	public void actionPerformed(ActionEvent ae) {
		// Creo un nuevo objeto
		Object o = ae.getSource();
		
		// Comprobaciones de btnInsertar y txtValor
		if(o == btnInsertar || o == txtValor) {
			try {
				double valor = Double.parseDouble(txtValor.getText());
				Precio p = new Precio(valor);
				if(!dlmPrecios.contains(p)) {
					dlmPrecios.addElement(p);
					modificado = true;
				}
				
			} catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(contenedor, (String)"El valor introducido no es valido", "Valor incorrecto", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		// Comprobar el btnBorrar
		if(o == btnBorrar) {
			int[] indice = lstPrecios.getSelectedIndices();
			int posiones = indice.length;
			Precio opcion = null;
			for(int pos = posiones - 1; pos >= 0; pos--) {
				opcion = dlmPrecios.elementAt(indice[pos]);
				this.dlmPrecios.removeElement(opcion);
				modificado = true;
			}
		}
		
		// Comprobar el btnLimpiar
		if(o == btnLimpiar) {
			if(!dlmPrecios.isEmpty()) {
				dlmPrecios.clear();
				modificado = true;
			}
				
		}
		// Calculo la media
		calcularMedia();
	}
	
	// Metodo para calcular la media
	public void calcularMedia() {
		// Necesidades previas
		double suma = 0.0, cifra, media;
		int posicion;
		Precio valor;
		
		// Recorro el modelo
		for(posicion = 0; posicion < dlmPrecios.size(); posicion++ ){
			valor = dlmPrecios.getElementAt(posicion);
			cifra = valor.getValor();
			suma = suma + cifra;
		}
		// Calculo la media
		media = suma/posicion;
		// cambio la label
		lblMediaValor.setText(String.valueOf(media));
	}
	
	// Metodo para guardar los precios
	public void guardarPrecios() {
		try {
			// Necesiades previas
			FileOutputStream fos;
			ObjectOutputStream oos;
			Precio p;
			
			fos = new FileOutputStream("precios.ser");
			oos = new ObjectOutputStream(fos);
			
			// recorro la lista
			for(int pos = 0; pos < dlmPrecios.size(); pos++) {
				p = dlmPrecios.get(pos);
				oos.writeObject(p);
			}
			// Cierro las necesidades
			oos.close();
			fos.close();
		} catch(FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(contenedor, (String) "El archivo no ha sido encontrado.", "Archivo no encontrado", JOptionPane.ERROR_MESSAGE);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	// Metodo para cargar los precios
	public void cargarPrecios() {
		try {
			// Necesiades previas
			FileInputStream fis;
			ObjectInputStream ois;
			Precio p;
			
			fis = new FileInputStream("precios.ser");
			ois = new ObjectInputStream(fis);
			
			// recorro el archivo
			while(fis.available() > 0) {
				p = (Precio)ois.readObject();
				dlmPrecios.addElement(p);
				// calculo la media
				calcularMedia();
			}
			// Cierro las necesidades
			ois.close();
			fis.close();
			
		} catch(FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(contenedor, (String)"Archivo no encontrado.", "No encontrado.", JOptionPane.ERROR_MESSAGE);
		} catch(IOException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException cnfe) {
			JOptionPane.showMessageDialog(contenedor, (String)"Clase no encontrada.","Error clase no encontrada.", JOptionPane.ERROR_MESSAGE);
		}
	}

}
