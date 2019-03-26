package evaluacion3;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ComplejoMainSerializableArrayList {

	public static void main(String[] args) {
		
		ByteArrayOutputStream baos;
		ObjectOutputStream oos;
		Complejo a;
		Complejo b;
		Complejo c;
		Complejo d;
		Complejo e;
		
		// ArrayList
		ArrayList<Complejo> alComplejo = new ArrayList<Complejo>();
		
		try {
			
			baos= new ByteArrayOutputStream();
			oos = new ObjectOutputStream (baos);
			
			// creo el complejo
			a = new Complejo(2,3); b = new Complejo(3,4); c = new Complejo(5,6); d = new Complejo(6,7);
			e = new Complejo(7,8);
			
			oos.writeObject(a); oos.writeObject(b); oos.writeObject(c); oos.writeObject(d);
			oos.writeObject(e);
			oos.close();
			
			// guarda los bytes en el array de tipo byte y de nombre bytes
			byte[] bytes = baos.toByteArray();
			
			if (alComplejo.isEmpty()) {
				
				alComplejo.add(a); alComplejo.add(b); alComplejo.add(c); alComplejo.add(d);
				alComplejo.add(e);
			}
			
			System.out.println("El número ( "+a+" ) se ha añadido.");
			System.out.println("El número ( "+b+" ) se ha añadido.");
			System.out.println("El número ( "+c+" ) se ha añadido.");
			System.out.println("El número ( "+d+" ) se ha añadido.");
			System.out.println("El número ( "+e+" ) se ha añadido.");
			
			
		}
		catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
		
		System.out.println(".------------- ( ---------------------- ) --------------.");

	}

}
