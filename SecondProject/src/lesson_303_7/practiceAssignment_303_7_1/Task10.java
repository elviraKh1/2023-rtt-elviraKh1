package lesson_303_7.practiceAssignment_303_7_1;

import java.util.Arrays;

/**
 * Task 10: Create an array that includes an integer, 3 strings, and 1 double.
 * Print the array
 */
public class Task10 {

	public static void main(String[] args) {

		Object[] mixedArray = new Object[5];
		mixedArray[0] = 2;
		mixedArray[1] = "String1";
		mixedArray[2] = "String2";
		mixedArray[3] = "String3";
		mixedArray[4] = 3.5;

		System.out.println(Arrays.toString(mixedArray));
	}
}
