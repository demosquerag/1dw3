package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculadoraTest {

	@Test
	public void testSuma() {
		double res=0;
		calculadora calc = new calculadora();
		res = calc.suma(2,2);
		assertTrue(res == 4);
		res = calc.suma(2,0);
		assertTrue(res == 1);
	}
	
	@Test
	public void testResta() {
		double res=0;
		calculadora calc = new calculadora();
		res = calc.resta(4,2);
		assertTrue(res == 2);
		res = calc.resta(1,0);
		assertTrue(res == 2);
	}
	
	@Test
	public void testDivision() {
		double res=0;
		calculadora calc = new calculadora();
		res = calc.division(4,2);
		assertTrue(res == 2);
		res = calc.division(1,1);
		assertTrue(res == 0);
	}
	
	
	@Test
	public void testMultiplicacion() {
		double res=0;
		calculadora calc = new calculadora();
		res = calc.multiplicacion(4,2);
		assertTrue(res == 8);
		res = calc.multiplicacion(1,0);
		assertTrue(res == 2);
	}
	

}
