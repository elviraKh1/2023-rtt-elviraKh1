package lesson_303_07.practiceAssignment_303_7_1;

import java.util.Arrays;

/**
 * Task 3: Write a program that creates an array of String type and initializes
 * it with the strings “red,” “green,” “blue,” and “yellow.” 
 * 		Print out the array length. 
 * 		Make a copy using the clone( ) method. 
 * 		Use the Arrays.toString( ) method on the new array to verify that the original array was copied.
 * 
 */
public class Task3 {

	public static void main(String[] args) {

		String[] colors = { "red", "green", "blue", "yellow" };
		System.out.println("Original array "+Arrays.toString(colors));
		System.out.println("Length of original array is " + colors.length);

		String[] colorsClone = colors.clone();
		System.out.println("Array's clone "+Arrays.toString(colorsClone));
	}
}