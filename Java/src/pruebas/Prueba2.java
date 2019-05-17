package pruebas;

public class Prueba2 {

	public static void main(String[] args) {
		
		// Array de Integer aleatorizados para los partidos
		int J_0[][] = {{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19},{5,16,3,12,13,0,19,2,15,4,11,8,7,14,1,10,9,18,17,6},
				{16,11,2,5,18,7,14,1,12,9,10,3,8,19,6,15,4,13,0,17},{15,16,3,4,5,8,11,2,7,10,9,0,17,18,13,14,1,6,19,12},
				{10,17,6,5,16,8,13,3,0,11,12,7,14,19,2,9,18,15,4,1},{3,7,5,14,15,19,11,18,8,2,1,13,9,6,4,10,17,12,0,16},
				{2,4,18,0,19,11,14,9,7,17,12,5,10,8,1,3,6,16,13,15},{2,18,16,10,5,13,15,7,8,12,9,1,6,3,4,11,17,19,0,14},
				{7,5,3,17,12,16,10,15,13,6,19,0,1,2,18,4,14,8,11,9},{2,10,16,18,5,11,15,3,7,13,8,4,9,19,6,14,17,1,0,12},
				{3,5,19,7,14,2,11,13,12,18,10,6,8,0,1,15,4,16,17,9},{3,14,18,8,16,2,5,10,15,9,7,1,12,11,6,19,0,4,13,17},
				{2,0,19,1,16,13,5,18,11,3,10,12,8,15,9,7,4,6,17,14},{3,19,18,10,14,11,15,17,7,16,12,4,1,8,6,2,0,5,13,9},
				{2,12,9,3,8,7,10,0,11,6,5,15,16,14,19,13,18,1,4,17},{3,0,19,5,14,10,15,12,7,11,1,16,9,4,6,8,17,2,13,18},
				{2,13,18,14,16,9,5,17,11,15,12,1,10,19,8,3,4,7,0,6},{3,16,19,4,14,12,15,2,7,0,1,11,9,5,6,18,17,8,13,10},
				{0,15,18,3,16,19,5,1,11,17,12,6,10,9,8,13,4,14,2,7}};
		
		String Equipos[]=new  String [20];
		Partida J_Partidos[][]=new Partida[38][10];
		for(int i=0;i<20;i++) {
			Equipos[i]="Equipo-"+String.valueOf(i+1);
		}
		
		Partida P1;
		for (int i=0;i<19;i++) {
			for (int j=0;j<10;j++) {
				P1=new Partida(Equipos[J_0[i][2*j]], Equipos[J_0[i][2*j+1]], i, j);
				J_Partidos [i][j]=P1;
				P1=new Partida(Equipos[J_0[i][2*j+1]], Equipos[J_0[i][2*j]], i, j);
				J_Partidos [i+19][j]=P1;
				
			}
			
		}
		for (int i=0;i<38;i++) {
			System.out.println("[-]______ Jornada "+(i+1)+" ______[-] ");
			for (int j=0;j<10;j++) {
				System.out.println(J_Partidos[i][j]);
				
			}
			
			
		}
		// Array de String aleatorizados para los partidos
		/*
		String J_1[][] = {{"BilbaoBasket D","Begoña","Santurtzi 1","Askartza Claret B 1","Txorierri BSK","Artxandape 1","Berrio-Otxoa B 1","Patronato Maristas 1","Jarrileros 1","Padura 1","Barakaldo Basket 1","La Salle 1","Munabe 1","San Ignacio Unamuno 1","Escolapios 1","Colegio Vizkaya 1"},
				
				{"Artxandape 1","Askartza Claret B 1","Munabe 1","San Ignacio Unamuno 1","BilbaoBasket D","Santurtzi 1","Colegio Vizkaya 1","Txorierri BSK","La Salle 1","Jarrileros 1","Patronato Maristas 1","Escolapios 1","Begoña","Barakaldo Basket 1","Padura 1","Berrio-Otxoa B 1"},
				
				{"La Salle 1","Santurtzi 1","Artxandape 1","Patronato Maristas 1","Escolapios 1","Begoña","Munabe 1","Padura 1","Barakaldo Basket 1","Askartza Claret B 1","Jarrileros 1","Berrio-Otxoa B 1","Colegio Vizkaya 1","Txorierri BSK","San Ignacio Unamuno 1","BilbaoBasket D"},
				
				{"Colegio Vizkaya 1","Askartza Claret B 1","Txorierri BSK","Artxandape 1","Jarrileros 1","La Salle 1","Santurtzi 1","Patronato Maristas 1","Barakaldo Basket 1","Padura 1","BilbaoBasket D","San Ignacio Unamuno 1","Escolapios 1","Begoña","Berrio-Otxoa B 1","Munabe 1"},
				
				{"Barakaldo Basket 1","Berrio-Otxoa B 1","Artxandape 1","Jarrileros 1","San Ignacio Unamuno 1","Askartza Claret B 1","BilbaoBasket D","La Salle 1","Munabe 1","Patronato Maristas 1","Escolapios 1","Santurtzi 1","Padura 1","Colegio Vizkaya 1","Txorierri BSK","Begoña"},
				
				{"Askartza Claret B 1","Patronato Maristas 1","Artxandape 1","Escolapios 1","Colegio Vizkaya 1","La Salle 1","Jarrileros 1","Santurtzi 1","Begoña","San Ignacio Unamuno 1","Padura 1","Berrio-Otxoa B 1","Txorierri BSK","Barakaldo Basket 1","Munabe 1","BilbaoBasket D"},
				
				{"Santurtzi 1","Txorierri BSK","BilbaoBasket D","La Salle 1","Escolapios 1","Padura 1","Patronato Maristas 1","Munabe 1","Artxandape 1","Barakaldo Basket 1","Jarrileros 1","Begoña","Askartza Claret B 1","Berrio-Otxoa B 1","San Ignacio Unamuno 1","Colegio Vizkaya 1"},
				
				{"Santurtzi 1","Barakaldo Basket 1","Artxandape 1","San Ignacio Unamuno 1","Colegio Vizkaya 1","Patronato Maristas 1","Jarrileros 1","Munabe 1","Padura 1","Begoña","Berrio-Otxoa B 1","Askartza Claret B 1","Txorierri BSK","La Salle 1","BilbaoBasket D","Escolapios 1"},
				
				{"Patronato Maristas 1","Artxandape 1","Askartza Claret B 1","Munabe 1","Barakaldo Basket 1","Colegio Vizkaya 1","San Ignacio Unamuno 1","Berrio-Otxoa B 1","BilbaoBasket D","Begoña","Santurtzi 1","Txorierri BSK","Escolapios 1","Jarrileros 1","La Salle 1","Padura 1"},
				
				{"Santurtzi 1","Barakaldo Basket 1","Artxandape 1","La Salle 1","Colegio Vizkaya 1","Askartza Claret B 1","Patronato Maristas 1","San Ignacio Unamuno 1","Jarrileros 1","Txorierri BSK","Padura 1","Berrio-Otxoa B 1","Escolapios 1","Begoña","BilbaoBasket D","Munabe 1"},
				
				{"Askartza Claret B 1","Artxandape 1","Patronato Maristas 1","Escolapios 1","Santurtzi 1","La Salle 1","San Ignacio Unamuno 1","Munabe 1","Barakaldo Basket 1","Berrio-Otxoa B 1","Jarrileros 1","BilbaoBasket D","Begoña","Colegio Vizkaya 1","Txorierri BSK","Padura 1"},
				
				{"Askartza Claret B 1","Escolapios 1","Jarrileros 1","Santurtzi 1","Artxandape 1","Barakaldo Basket 1","Colegio Vizkaya 1","Padura 1","Patronato Maristas 1","Begoña","Munabe 1","La Salle 1","Berrio-Otxoa B 1","BilbaoBasket D","Txorierri BSK","San Ignacio Unamuno 1"},
				
				{"Santurtzi 1","BilbaoBasket D","San Ignacio Unamuno 1","Artxandape 1","La Salle 1","Askartza Claret B 1","Barakaldo Basket 1","Munabe 1","Jarrileros 1","Colegio Vizkaya 1","Padura 1","Patronato Maristas 1","Txorierri BSK","Berrio-Otxoa B 1","Escolapios 1"},
				
				{"Askartza Claret B 1","Barakaldo Basket 1","Escolapios 1","La Salle 1","Colegio Vizkaya 1","Patronato Maristas 1","Munabe 1","Txorierri BSK","Begoña","Jarrileros 1","Berrio-Otxoa B 1","Santurtzi 1","BilbaoBasket D","Artxandape 1","San Ignacio Unamuno 1","Padura 1"},
				
				{"Santurtzi 1","Munabe 1","Padura 1","Askartza Claret B 1","Jarrileros 1","Patronato Maristas 1","Barakaldo Basket 1","BilbaoBasket D","La Salle 1","Berrio-Otxoa B 1","Artxandape 1","Escolapios 1","San Ignacio Unamuno 1","Begoña","Txorierri BSK"},
				
				{"Askartza Claret B 1","BilbaoBasket D","Artxandape 1","Escolapios 1","Barakaldo Basket 1","Colegio Vizkaya 1","Munabe 1","Patronato Maristas 1","La Salle 1","Begoña","Padura 1","Txorierri BSK","Berrio-Otxoa B 1","Jarrileros 1","Santurtzi 1","San Ignacio Unamuno 1"},
				
				{"Santurtzi 1","San Ignacio Unamuno 1","Escolapios 1","Padura 1","Artxandape 1","La Salle 1","Colegio Vizkaya 1","Munabe 1","Begoña","Barakaldo Basket 1","Jarrileros 1","Askartza Claret B 1","Txorierri BSK","Patronato Maristas 1","BilbaoBasket D","Berrio-Otxoa B 1"},
				
				{"Askartza Claret B 1","Txorierri BSK","Escolapios 1","Munabe 1","Santurtzi 1","Patronato Maristas 1","BilbaoBasket D","Begoña","La Salle 1","Padura 1","Artxandape 1","Berrio-Otxoa B 1","Jarrileros 1","San Ignacio Unamuno 1","Barakaldo Basket 1"},
				
				{"BilbaoBasket D","Colegio Vizkaya 1","Askartza Claret B 1","Artxandape 1","Begoña","La Salle 1","Munabe 1","Berrio-Otxoa B 1","Barakaldo Basket 1","Padura 1","Jarrileros 1","San Ignacio Unamuno 1","Txorierri BSK","Escolapios 1","Santurtzi 1","Patronato Maristas 1"}};
		*/
		/*
		String Equipos[]=new  String [16];
		Partida J_Partidos[][]=new Partida[32][8];
		for(int i=0;i<16;i++) {
			Equipos[i]="Equipo-"+String.valueOf(i+1);
		}
		
		Partida P1;
		for (int i=0;i<15;i++) {
			for (int j=0;j<8;j++) {
				P1=new Partida(Equipos[J_0[i][2*j]], Equipos[J_0[i][2*j+1]], i, j);
				J_Partidos [i][j]=P1;
				P1=new Partida(Equipos[J_0[i][2*j+1]], Equipos[J_0[i][2*j]], i, j);
				J_Partidos [i+15][j]=P1;
				
			}
			
		}
		for (int i=0;i<32;i++) {
			System.out.println("[-]______ Jornada "+(i+1)+" ______[-] ");
			for (int j=0;j<10;j++) {
				System.out.println(J_Partidos[i][j]);
				
			}
			
			
		}
		*/

	}

}
