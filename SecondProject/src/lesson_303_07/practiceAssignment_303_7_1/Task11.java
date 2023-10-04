package lesson_303_07.practiceAssignment_303_7_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task 11: Write some Java code that asks the user how many favorite things
 * they have. Based on their answer, you should create a String array of the
 * correct size. Then ask the user to enter the things and store them in the
 * array you created. Finally, print out the contents of the array.
 * 
 * Example
 * 	How many favorite things do you have?
 * 	7
 * Enter your thing: phone
 * Enter your thing: tv
 * Enter your thing: xbox
 * Enter your thing: wine
 * Enter your thing: beer
 * Enter your thing: sofa
 * Enter your thing: book
 * Your favorite  things are:
 * phone tv xbox wine beer sofa book
 */
public class Task11 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.print("How many favorite things do you have? ");
		int length = scanner.nextInt();

		String[] things = new String[length];
		int idx = 0;
		while (length > idx) {
			System.out.print("Enter your thing: ");
			things[idx++] = scanner.next();
		}
		System.out.println("Your favorite  things are:");

		System.out.println(Arrays.toString(things));
	}

}
