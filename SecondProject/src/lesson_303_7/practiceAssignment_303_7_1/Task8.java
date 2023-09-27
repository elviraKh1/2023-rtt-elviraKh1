package lesson_303_7.practiceAssignment_303_7_1;

import java.util.Arrays;

/**
 * Task 8: Write a program that creates a String array of 5 elements and swaps
 * the first element with the middle element without creating a new array.
 * 
 */
public class Task8 {

	public static void main(String[] args) {
		String[] colors = { "red", "green", "blue", "yellow", "white" };

		System.out.println("Original array " + Arrays.toString(colors));

		int middle = colors.length / 2;

		String temp = colors[0];
		colors[0] = colors[middle];
		colors[middle] = temp;
		
		System.out.println("Swapped array " + Arrays.toString(colors));

	}
}
