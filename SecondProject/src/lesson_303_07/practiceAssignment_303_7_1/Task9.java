package lesson_303_07.practiceAssignment_303_7_1;

import java.util.Arrays;

/**
 * Task 9: Write a program to sort the following int array in ascending order:
 * {4, 2, 9, 13, 1, 0}. 
 * Print the array in ascending order, 
 * and print the smallest and the largest element of the array. 
 * The output will look like the following: 
 * 		Array in ascending order: 0, 1, 2, 4, 9, 13 
 * 		The smallest number is 0 The biggest number is 13
 * 
 */
public class Task9 {

	public static void main(String[] args) {

		int[] myArray = { 4, 2, 9, 13, 1, 0 };
		System.out.println(Arrays.toString(myArray));

		for (int i = 0; i < myArray.length; i++) {
			for (int j = 0; j < myArray.length - 1; j++) {
				if (myArray[j] > myArray[j + 1]) {
					int temp = myArray[j];
					myArray[j] = myArray[j + 1];
					myArray[j + 1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(myArray));
	}

}
