 package perscholas.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	public void addtionTest() {
		Calculator c = new Calculator();
		double expected =10;
		double actual = c.add(5, 5);
		Assertions.assertEquals(expected,actual);
		
		Assertions.assertEquals(15, c.add(7.5, 7.5));
	}
	
	@Test
	public void substractionTest() {
		Calculator c = new Calculator();
		double expected =0;
		double actual = c.substract(5, 5);
		Assertions.assertEquals(expected,actual);
		
		Assertions.assertEquals(15, c.substract(30.5, 15.5));
	}
}
