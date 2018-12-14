package evaluacion2;

public class Bucle_10Impares {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Iniciar variable		
		long producto=1; 
		
		// producto guardará la multiplicación de los 10 primeros números impares.
		// es muy importante acordarse de inicializarlo a 1. Ya que si lo hacemos a 0,
		// el producto siempre valdrá 0.
		// para calcular los 10 primeros números impares utilizamos un for que:
		//
		// comience en 1
		// y en cada vuelta se incremente en 2, así obtenemos
		// 1, 3, 5, 7, 9, 11, 13, 15, 17, 19.
		
				
		for (int i=1; i<20; i+=2) {
		producto=producto*i;
		}
		
		System.out.println("La multiplicación de los 10 primeros impares: " + producto);
	}

}
