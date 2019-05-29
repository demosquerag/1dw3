package evaluacion2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JList;

public class JFArrayPerson2 extends JFrame {

	// MAIN DE INICIO DE LA APLICACION
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFArrayPerson2 frame = new JFArrayPerson2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// OBJETOS/ELEMENTOS Y SERIAL
	private static final long serialVersionUID = -1547704899295089470L;
	private JPanel pnlPrincipal;
	private JTextField txtDni;
	private JTextField txtNombre;
	private JTextField txtApellido;	
	private JTextField txtFechan;
	private JLabel lblDni;
	private JLabel lblNombre;
	private JLabel lblApellido;	
	private JLabel lblFechan;
	private JButton btnInsertar;
	private JButton btnEliminar;
	private JButton btnMostrar;
	private JButton btnBuscar;
	private JList<String> lstArray;
	
	// Definir un modelo de tabla
	DefaultTableModel tblar = new DefaultTableModel();
	DefaultListModel<String> lstar = new DefaultListModel<>();
	
	// Insertar arraylist personas
	//Persona valor = new Persona();
	ArrayList<Persona> personas = new ArrayList<Persona>();

	// CLASE PUBLICA CON LOS COMPONENTES
	public JFArrayPerson2() {
		setResizable(false);
		setTitle("JFrameArray_1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 413, 400);
		pnlPrincipal = new JPanel();
		pnlPrincipal.setBorder(new EmptyBorder(3, 3, 3, 3));
		setContentPane(pnlPrincipal);
		pnlPrincipal.setLayout(null);
		
		lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Arial", Font.BOLD, 18));
		lblDni.setBounds(10, 23, 88, 22);
		pnlPrincipal.add(lblDni);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
		lblNombre.setBounds(10, 52, 88, 22);
		pnlPrincipal.add(lblNombre);
		
		lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Arial", Font.BOLD, 18));
		lblApellido.setBounds(10, 84, 88, 22);
		pnlPrincipal.add(lblApellido);
		
		lblFechan = new JLabel("FechaN");
		lblFechan.setFont(new Font("Arial", Font.BOLD, 18));
		lblFechan.setBounds(10, 118, 88, 22);
		pnlPrincipal.add(lblFechan);
		
		txtDni = new JTextField();
		txtDni.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDni.setBounds(128, 23, 86, 20);
		pnlPrincipal.add(txtDni);
		txtDni.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setFont(new Font("Arial", Font.PLAIN, 12));
		txtApellido.setBounds(128, 87, 86, 20);
		pnlPrincipal.add(txtApellido);
		txtApellido.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Arial", Font.PLAIN, 12));
		txtNombre.setBounds(128, 55, 86, 20);
		pnlPrincipal.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnInsertar = new JButton("Insertar");
		btnInsertar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnInsertar();
			}
		});
		
		txtFechan = new JTextField();
		txtFechan.setFont(new Font("Arial", Font.PLAIN, 12));
		txtFechan.setBounds(128, 121, 86, 20);
		pnlPrincipal.add(txtFechan);
		txtFechan.setColumns(10);
		btnInsertar.setFont(new Font("Arial", Font.BOLD, 11));
		btnInsertar.setBounds(10, 167, 89, 23);
		pnlPrincipal.add(btnInsertar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnEliminar();
			}
		});
		btnEliminar.setFont(new Font("Arial", Font.BOLD, 11));
		btnEliminar.setBounds(109, 167, 89, 23);
		pnlPrincipal.add(btnEliminar);
		
		btnMostrar = new JButton("Mostrar");
		btnMostrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BtnMostrar();
			}
		});
		btnMostrar.setFont(new Font("Arial", Font.BOLD, 11));
		btnMostrar.setBounds(208, 167, 89, 23);
		pnlPrincipal.add(btnMostrar);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setFont(new Font("Arial", Font.BOLD, 11));
		btnBuscar.setBounds(307, 167, 89, 23);
		pnlPrincipal.add(btnBuscar);
		
		lstArray = new JList();
		lstArray.setBounds(10, 201, 386, 159);
		pnlPrincipal.add(lstArray);
		lstArray.setModel(lstar);
		
		
	}
		
	private void BtnEliminar() {
		// Recoger los datos de los campos a eliminar
		//int eli = lstArray.getSelectedRow();
		Persona valor = new Persona();
		// Recoger lo datos de los campos de texto	
		valor.setDni(txtDni.getText());
		valor.setNombre(txtNombre.getText());
		valor.setApellido(txtApellido.getText());
		
		if (personas.contains(valor)) {
			System.out.println("La persona ( "+valor+ " ) ha sido borrada.");
			// BORRAR LA PALABRA BUSACADA
			personas.remove(valor);
		}
		else {
			System.out.println("Esa persona( "+valor+" ) no existe.");
		}
		
		
		/**if (eli >= 0) {
			tblar.removeRow(eli);
		}
		else {
			JOptionPane.showMessageDialog(null,"No hay datos a eliminar");
		}*/
		
		// Limpiar campos de texto
		clearField();
	}
	
	private void BtnInsertar() {
		
		// Recoger lo datos de los campos de texto	
		Persona valor = new Persona();
		valor.setDni(txtDni.getText());
		valor.setNombre(txtNombre.getText());
		valor.setApellido(txtApellido.getText());
		Fecha fn = new Fecha();
		valor.setFechanacimiento(fn);
		
				
		// Comprobar si la persona existe e insertarla
		if (!personas.contains(valor)) {
			// AÑADIR LA CADENA AL ARRAYLIST
			personas.add(valor);
			lstar.addElement(valor.toString());
			
			System.out.println("La persona ( "+valor+" ) se ha añadido.");
		}
		else {
			System.out.println("Esa persona ya existe.");
		}
		
		// Limpiar campos de texto
		clearField();
		
	}
	
	private void BtnMostrar() {
		
		// Poner el contador de filas a 0
		tblar.setRowCount(0);
				
		// Menor a mayor
		Collections.sort(personas);
		
		// Mostrar arraylist ordenado
		for (int i=0; i < personas.size(); i++) {
			
			// Añadir los objetos a la tabla
			Object[] per = {personas.get(i).getDni(), personas.get(i).getNombre(), personas.get(i).getApellido(), personas.get(i).getFechanacimiento()};
			//lstar.addRow(per);

			
			// Salida de texto por consola
			System.out.println(personas.get(i));
		}
	}
	
	private void clearField() {
		
		// Limpiar los campos de texto
		txtDni.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtFechan.setText("");
	}

}
