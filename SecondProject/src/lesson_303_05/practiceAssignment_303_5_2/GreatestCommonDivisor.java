package lesson_303_05.practiceAssignment_303_5_2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Write a program that prompts the user to enter two positive integers, and
 * find their greatest common divisor (GCD). Examples: Enter 2 and 4. The gcd is
 * 2. Enter 16 and 24. The gcd is 8.
 * 
 * How do you find the gcd? Name the two input integers n1 and n2. You know
 * number 1 is a common divisor, but it may not be the gcd. Check whether k (for
 * k = 2, 3, 4, and so on) is a common divisor for n1 and n2, until k is greater
 * than n1 or n2.
 * 
 */
public class GreatestCommonDivisor {

	public static void main(String[] args) throws GCDNumberException {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two positive integers: ");
		int n1 = readPositiveNumber(input);
		int n2 = readPositiveNumber(input);

		System.out.println("First number: " + n1);
		System.out.println("Second number: " + n2);

		int gcn = 1;
		int max = Math.max(n1, n2);
		for (int k = max; k >= 1; k--) {
			if (n1 % k == 0 && n2 % k == 0) {
				gcn = k;
				break;
			}
		}
		if (gcn != 1) {
			System.out.println(gcn);
		} else {
			System.out.println("There is no GSM for " + n1 + " and " + n2);
		}
		System.out.println(gcd(17,256));
		
		input.close();
	}

	public static int readPositiveNumber(Scanner scanner) throws GCDNumberException {
		int n = -1;
			while (n <= 0) {
				System.out.println("Enter a positive integers number");
				try {
					n = scanner.nextInt();
				}catch (InputMismatchException ex){
					throw new GCDNumberException(n+ " is not a numeric value");
				}
				if (n <= 0) {
					System.out.println("Error : must be a positive number");
				}
			}
		return n;
	}
	
	static int gcd(int a, int b)
    {
        if (b == 0)
            return a;
         else
            return gcd(b, a % b);
    }

}
