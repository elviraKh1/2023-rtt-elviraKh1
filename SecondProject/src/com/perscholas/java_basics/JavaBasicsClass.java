package com.perscholas.java_basics;

import java.text.DecimalFormat;

public class JavaBasicsClass {

	public static void main(String[] args) {
		sumTwoInts(1, 2);
		printLine();

		sumTwoDouble(2.5, 5.5);
		printLine();

		sumIntegerDouble(2.5, 4);
		printLine();

		divisionIntegers();
		namedConstants();
		printLine();

		cafe();
		printLine();
	}

	/**
	 * Write a program that declares two integer variables, assigns an integer to
	 * each, and adds them together. Assign the sum to a variable. Print out the
	 * result.
	 *
	 */
	public static void sumTwoInts(int v1, int v2) {
		int sum = v1 + v2;
		System.out.printf("Sum of two integers %d and %d is %d %n", v1, v2, sum);

	}

	/**
	 * Write a program that declares two double variables, assigns a number to each,
	 * and adds them together. Assign the sum to a variable. Print out the result.
	 */
	public static void sumTwoDouble(double v1, double v2) {
		double sum = v1 + v2;
		System.out.printf("Sum of two double %.2f and %.2f is %.2f %n", v1, v2, sum);
	}

	/**
	 * Write a program that declares an integer variable and a double variable,
	 * assigns numbers to each, and adds them together. Assign the sum to a
	 * variable. Print out the result. What variable type must the sum be?
	 */

	public static void sumIntegerDouble(double d, int i) {
		int sumInt = (int) (d + i);
		double sumDouble = d + i;
		System.out.println("Sum casting to int " + sumInt);
		System.out.println("More accurate answer with sum in double " + sumDouble );
	}

	/**
	 * Write a program that declares two integer variables, assigns an integer to
	 * each, and divides the larger number by the smaller number. Assign the result
	 * to a variable. Print out the result. Now change the larger number to a
	 * decimal. What happens? What corrections are needed?
	 * 
	 */
	static void divisionIntegers() {
		int d1 = 13;
		int d2 = 2;
		int divInt = d1/d2;
		double divDecimal = d1/d2;
		System.out.println("  ======= int "+ divInt +"  ======== double "+ divDecimal);
		System.out.printf("divides the larger number by the smaller number (cast to int) %d/%d=%d \n", d1, d2, divInt );
		System.out.printf("divides the larger number by the smaller number %d/%d=%.2f \n", d1, d2, divDecimal  );
		double dd1 = 13.0;
		int dd2 = 2;
		double div2 = d1/d2;
		System.out.printf("divides the larger number by the smaller number %.2f/%d=%.2f \n", dd1, dd2, div2 );///////////////////////////////////
	}
	
	
	/**
	 * Write a program that declares a named constant and uses it in a calculation.
	 * Print the result.
	 */
	static void namedConstants() {
		double PI = Math.PI;
		int radius = 3;
		double area = PI * Math.pow(radius, 2);
		System.out.printf("R = %d Area of circle is %.2f \n", radius, area);
	}

	/**
	 * Write a program where you create three variables that represent products at a
	 * cafe. The products could be beverages like coffee, cappuccino, espresso,
	 * green tea, etc. Assign prices to each product. Create two more variables
	 * called subtotal and totalSale and complete an “order” for three items of the
	 * first product, four items of the second product, and two items of the third
	 * product. Add them all together to calculate the subtotal. Create a constant
	 * called SALES_TAX and add sales tax to the subtotal to obtain the totalSale
	 * amount. Be sure to format the results to two decimal places.
	 */

	static void cafe() {
		final double SALES_TAX = 6.3;
		double coffee = 1.5;
		double cappuccino = 2.3;
		double espresso = 1;

		double subtotal = 3 * coffee + 4 * cappuccino + 2 * espresso;
		double totalSale = subtotal + subtotal * SALES_TAX / 100;
		System.out.printf("Format with printf and 2f :  TotalSale is %.2f \n", totalSale);
		DecimalFormat df = new DecimalFormat("$#,###0.00");
		System.out.println("Format with DecimalFormat : TotalSale is " + df.format(totalSale));
	}

	static void printLine() {
		System.out.println("--------------------------------------------------------------");
	}
}