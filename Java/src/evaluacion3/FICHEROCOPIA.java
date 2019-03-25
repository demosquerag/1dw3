package evaluacion3;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FICHEROCOPIA {

	public static void main(String[] args) {
		
		
		try {
			
			FileInputStream fis = new FileInputStream("A:/PROG/git/git/Java/logo.png");
			BufferedInputStream bis = new BufferedInputStream(fis);
			
			FileOutputStream fos = new FileOutputStream("A:/PROG/git/git/Java/logocopia.png");
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			
			byte [] copy = new byte[512];
						
			int leer;
			while ((leer = fis.read(copy)) > 0) {
                bos.write(copy, 0, leer);
            }
			
			bis.close();
			fis.close();
			bos.close();
			fos.close();
						
		} catch (FileNotFoundException fnfe) {
			
			System.out.println("Error al encontrar el archivo.");
			
		} catch (IOException ioe) {
			
			System.out.println("Error...");
			
		}
		
		System.out.println("Archivo copiado correctamente...");

	}

}
