package perscholas.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.ParameterizedTest;

public class CalculatorTest {

	@ParameterizedTest
	@CsvSource({ "5,5,10", "15,15,30", "5.5,5.5,11.0", })
	public void addtionTest(double a, double b, double expected) {
		Calculator c = new Calculator();
		// double expected =10;
		double actual = c.add(a, b);
		Assertions.assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvSource({ "5,5,11", "16,15,30", "5.5,7.5,11.0", })
	public void addtionErrorTest(double a, double b, double expected) {
		Calculator c = new Calculator();
		// double expected =10;
		double actual = c.add(a, b);
		Assertions.assertNotEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvSource({ "5,5,0", "16,15,1", "5.5,7.5,-2", })
	public void substractionTest(double a, double b, double expected) {
		Calculator c = new Calculator();
		// double expected =10;
		double actual = c.substract(a, b);
		Assertions.assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvSource({ "5,5,1", "16,4,4", "5.5,5.5,1", })
	public void divideTest(double a, double b, double expected) {
		Calculator c = new Calculator();
		// double expected =10;
		double actual = c.divide(a, b);
		Assertions.assertEquals(expected, actual);
	}

	@ParameterizedTest
	@CsvSource({ "5,0,1", "0.5,0,0", })
	public void divideExceptionTest(double a, double b, double expected) {
		Calculator c = new Calculator();
		// double expected =10;
		double actual = c.divide(a, b);
		Assertions.assertDoesNotThrow(() -> {
		}, "");
		Assertions.assertEquals(Double.POSITIVE_INFINITY, actual);

	}

	@Test
	public void divideNaNTest() {
		Calculator c = new Calculator();
		// double expected =10;
		double actual = c.divide(0, 0);
		Assertions.assertEquals(Double.NaN, actual);

	}
}
