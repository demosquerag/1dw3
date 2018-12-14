package evaluacion2;

public class Complejo {
	private double real;
	private double imaginario;
	
	Complejo(){
		this.real = 1.0;
		this.imaginario = 2.0;
	}

	@Override
	public String toString() {
		return (real + " + " + imaginario + "i");
	}
	
	void escribir() {
		System.out.println(real + " + " + imaginario + "i");
	}

}
