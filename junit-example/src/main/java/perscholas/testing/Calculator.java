package perscholas.testing;

public class Calculator {
 
	public double add (double x, double y) {
		return x+y;
	}
	
	public double substract (double x, double y) {
		return x-y;
	}

	public double multiply (double x, double y) {
		return x*y;
	}
	
	public double divide(double x, double y) {
		return x/y;
	}


	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		double sum = calculator.add(5,6);
		double sub = calculator.add(10,3.9);
		
	}
}
