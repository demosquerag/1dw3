package evaluacion3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ComplejoMainSerializable {

	public static void main(String[] args) {
		
		// grabo los datos en complejos.dat
		FileOutputStream fos;
		ObjectOutputStream oos;
		Complejo c;
		
		try {
			
			fos=new FileOutputStream("complejos.dat");
			oos = new ObjectOutputStream (fos);
			
			// creo el complejo c
			c = new Complejo(2,3);
			// lo grabo
			oos.writeObject(c);
			// cierro el fichero
			oos.close();
			fos.close();
			
		} 
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		FileInputStream fis;
		ObjectInputStream ois;
		
		try {
			
			fis=new FileInputStream("complejos.dat");
			ois = new ObjectInputStream(fis);
			// convierte los bytes leídos en un objeto de la clase Complejo
			c = (Complejo) ois.readObject();
			ois.close();
			fis.close();
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		}

	}

}
