package lesson_303_5.practiceAssignment_303_5_2;

import java.util.Scanner;

/**
 * Write a program that prompts the user to enter two positive integers, and
 * find their greatest common divisor (GCD). 
 * Examples: 
 * 		Enter 2 and 4. The gcd is 2.
 *  	Enter 16 and 24. The gcd is 8. 
 *  
 *  How do you find the gcd? 
 *  	Name the two input integers n1 and n2. 
 *  	You know number 1 is a common divisor, but it may not be the gcd. 
 *  	Check whether k (for k = 2, 3, 4, and so on) is a common divisor for
 * n1 and n2, until k is greater than n1 or n2.
 * 
 */
public class GreatestCommonDivisor {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("enter two positive integers: ");
		int n1 = input.nextInt();
		int n2 = input.nextInt();
		int gcn = 1;
		int max = n2 > n1 ? n2 : n1;
		for (int k = 1 ; k < max ; k++) {
			if (n1%k==0 && n2%k==0 ) {
				gcn = k;
			}			
		}
		System.out.println(gcn);
	}

}
