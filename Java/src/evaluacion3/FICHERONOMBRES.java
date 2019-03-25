package evaluacion3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FICHERONOMBRES {

	public static void main(String[] args) {
		
		// Necesidades previas
		FileWriter fichero = null;
		PrintWriter pw = null;
		BufferedWriter bw = null;
		Scanner teclado = new Scanner(System.in);
		
		try {
			fichero = new FileWriter("Nombres.txt");
			pw = new PrintWriter(fichero);
			bw = new BufferedWriter(pw);
			//escribo una lineas
			System.out.println("Introduce nombre: ");
			bw.write(teclado.nextLine());
			//cierro los recursos utilizados
			bw.close();
			pw.close();
			fichero.close();
			
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
		// Cerrar teclado
		teclado.close();
		
		// Necesidades previas
		//leo datos desde el fichero
		File archivo = null;
		FileReader fr = null;
		BufferedReader br = null;
				
		try {
			archivo = new File ("Nombres.txt");
			fr = new FileReader (archivo);
			br = new BufferedReader (fr);
			String linea;
			while((linea=br.readLine())!=null) {
				System.out.println(linea);
			}
			//cierro los recursos utilizados
			br.close();
			fr.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}

	}

}
