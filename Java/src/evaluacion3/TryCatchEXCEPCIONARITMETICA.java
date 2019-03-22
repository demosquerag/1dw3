package evaluacion3;

public class TryCatchEXCEPCIONARITMETICA {

	public static void main(String[] args) {
		
		// Necesidades previas
		int n;
		int numerador = 7;
		
		try {
			
			n = numerador / 0;
			
		} catch (ArithmeticException ae) {
			
			if (numerador > 0) {
				
				System.out.println(Double.POSITIVE_INFINITY);
				
			} else if (numerador < 0) {
				
				System.out.println(Double.NEGATIVE_INFINITY);
				
			} else {
				
				System.out.println(Double.NaN);
				
			}
			
		}

	}

}
