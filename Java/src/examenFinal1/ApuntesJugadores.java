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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
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

import javax.swing.JList;
import javax.swing.JOptionPane;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ApuntesJugadores extends JFrame implements ActionListener, FocusListener{

	// Necesidades previas
	private static final long serialVersionUID = 1979388956746638199L;

	private JPanel contenedor;
	private JLabel lblNombre;

	private JPanel panelDatos;
	private JButton btnInsertar;
	private JButton btnBorrar;
	private JButton btnLimpiar;
	
	private JTextField txtNombre;
	private JLabel lblNivel;
	private JTextField txtNivel;
	private JScrollPane scrollPane;
	private JPanel panelEstado;
	private JLabel lblEstado;
	private JLabel lblEstadoActual;
	private JList<Jugador> lstJugadores;
	private DefaultListModel<Jugador> dlmJugadores;
	private boolean modificado = false;
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ApuntesJugadores frame = new ApuntesJugadores();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public ApuntesJugadores() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if(modificado==true) {
					int opcion = JOptionPane.showConfirmDialog(null,(String)"¿Desea Guardar los cambios?","Guardar",JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.QUESTION_MESSAGE,null);
					switch (opcion){
					
					case JOptionPane.YES_OPTION:
						System.exit(0);
						guardarJugadores();
						break;
					case JOptionPane.NO_OPTION:
						System.exit(0);
						break;
					case JOptionPane.CANCEL_OPTION:
						break;
					}
					
				}
			}
		});
		setTitle("Apuntes1");
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 822, 336);
		contenedor = new JPanel();
		contenedor.setBorder(new EmptyBorder(5, 5, 5, 5));
		contenedor.setLayout(new BorderLayout(0, 0));
		setContentPane(contenedor);
		
		panelDatos = new JPanel();
		contenedor.add(panelDatos, BorderLayout.NORTH);
		
		lblNombre = new JLabel("Nombre");
		panelDatos.add(lblNombre);
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
	  
	  txtNombre = new JTextField();
	  txtNombre.addActionListener(this);
	  txtNombre.setHorizontalAlignment(SwingConstants.RIGHT);
	  panelDatos.add(txtNombre);
	  txtNombre.setColumns(10);
	  txtNombre.addFocusListener(this);
	  
	  lblNivel = new JLabel("Nivel");
	  panelDatos.add(lblNivel);
	  
	  txtNivel = new JTextField();
	  txtNivel.addActionListener(this);
	  txtNivel.setHorizontalAlignment(SwingConstants.RIGHT);
	  txtNivel.setText("0");
	  panelDatos.add(txtNivel);
	  txtNivel.setColumns(10);
	  txtNivel.addFocusListener(this);
	  
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
		
		lblEstado = new JLabel("Estado:");
		panelEstado.add(lblEstado);
		
		lblEstadoActual = new JLabel("Datos Sin Modificar");
		lblEstadoActual.setFont(new Font("Tahoma", Font.BOLD, 16));
		panelEstado.add(lblEstadoActual);
		
		dlmJugadores=new DefaultListModel<Jugador>();
		lstJugadores = new JList<Jugador>();
		
		lstJugadores.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		lstJugadores.setModel(dlmJugadores);
		scrollPane.setViewportView(lstJugadores);
		
		cargarJugadores();
	  
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if(o == txtNombre || o == txtNivel || o == btnInsertar) {
			String n = txtNombre.getText();
			String i = txtNivel.getText();
			Jugador j=new Jugador(n, Integer.parseInt(i));
			
			if(!dlmJugadores.contains(j)) {
				dlmJugadores.addElement(j);
				lblEstadoActual.setText("Datos Modificados");
				modificado=true;
			}
			
		} else if(o==btnBorrar) {
			int[] seleccion=this.lstJugadores.getSelectedIndices();
			int Jopcion=seleccion.length;
			if(Jopcion>0) {
				for(int pos=Jopcion-1;pos>=0;pos-- ) {
					dlmJugadores.remove(pos);
					modificado=true;
				}
			}
			
		} else if(o==btnLimpiar) {
			if(!dlmJugadores.isEmpty()) {
				dlmJugadores.clear();
				modificado=true;
			}
		}
	}
	
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

	// Metodo para guardar los jugadores en fichero
	public void guardarJugadores() {
		try {
			// Necesidades previas
			FileOutputStream fos;
			ObjectOutputStream oos;
			Jugador j;
			
			fos=new FileOutputStream("jugadores.ser");
			oos=new ObjectOutputStream(fos);
			
			// Recorro la lista
			for(int pos = 0; pos < dlmJugadores.size(); pos++) {
				j = dlmJugadores.get(pos);
				oos.writeObject(j);
			}
			// Cerrar necesidades
			oos.close();
			fos.close();
		} catch(FileNotFoundException fnfe) {
			JOptionPane.showMessageDialog(contenedor, (String) "Error, Archivo no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	// Metodo para cargar los jugadores del fichero a la lista
	public void cargarJugadores() {
		try {
			//Necesidades previas
			FileInputStream fis;
			ObjectInputStream ois;
			
			fis=new FileInputStream("jugadores.ser");
			ois=new ObjectInputStream(fis);
			
			// recorro el fichero
			while(fis.available() > 0) {
				dlmJugadores.addElement((Jugador)ois.readObject());
			}
			// Cerrar necesidades
			ois.close();
			fis.close();
		} catch(ClassNotFoundException cnfe){
			JOptionPane.showMessageDialog(contenedor, (String) "Error, Clase no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
		
	}

}
