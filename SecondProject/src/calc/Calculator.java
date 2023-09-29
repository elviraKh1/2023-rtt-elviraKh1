package calc;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Create a small calculator .. it will be able to do 4 operations - add,
 * subtract, multiply and divide. Each of these will be a single method that
 * does that operation. Ask the user for 2 numbers and then ask the user which
 * operation they want to do. Then do that operation and print the result. Each
 * operation should not print its own results. All operations should work with
 * double values. (edited) 3:32 So this should be a main function with probably
 * 6 methods ( 4 operations, 1 menu, 1 input ) 3:33 each operation should take 2
 * parameters and return a double ...
 */
public class Calculator {

	public static void main(String[] args) {
		Calculator c = new Calculator();
		c.menu();
	}

	private void menu() {
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n==========Calculator===========\n");

			System.out.print("Enter number 1: ");
			double num1 = enterNumber(scanner);

			System.out.print("Enter number 2: ");
			double num2 = enterNumber(scanner);

			int operation = choseOperation(scanner);
			if (operation == 4) {
				scanner.close();
				System.exit(0);
			} else {
				executeOperation(operation, num1, num2);
			}
		}
	}

	private int choseOperation(Scanner scanner) {
		System.out.println("Choose calc operation number 1-4 :");
		System.out.println("0) Addition");
		System.out.println("1) Substraction");
		System.out.println("2) Multiplication");
		System.out.println("3) Division");
		System.out.println("4) Exit");
		return (int) enterNumber(scanner);
	}

	private void executeOperation(int operation, double num1, double num2) {
		double result = 0;
		switch (operation) {
		case 0:
			result = getAddition(num1, num2);
			break;
		case 1:
			result = getSubstract(num1, num2);
			break;
		case 2:
			result = getMultiply(num1, num2);
			break;
		case 3:
			if (num2 == 0) {
				System.out.println("Value of second nummber can't be 0!");
				return;
			} else {
				result = getDivision(num1, num2);
			}
			break;
		default:
			System.out.println("Wrong number of operation, try again ");
			return;
		}
		getFormattedString(num1, num2, operation, result);
	}

	private double enterNumber(Scanner scanner) {
		boolean isNumber = false;
		double n = 0;
		while (!isNumber) {
			try {
				n = scanner.nextDouble();
				isNumber = true;
			} catch (InputMismatchException e) {
				System.out.print("Error it is not a number, try again ");
				scanner.nextLine();
			}
		}
		return n;
	}

	private double getAddition(double num1, double num2) {
		return num1 + num2;
	}

	private double getMultiply(double num1, double num2) {
		return num1 * num2;
	}

	private double getSubstract(double num1, double num2) {
		return num1 - num2;
	}

	private double getDivision(double num1, double num2) {
		return num1 / num2;
	}

	private void getFormattedString(double num1, double num2, int operation, double result) {
		String[] signs = { "+", "-", "*", "/" };
		System.out.printf("%.2f %s %.2f = %.2f\n", num1, signs[operation], num2, result);
	}

}
