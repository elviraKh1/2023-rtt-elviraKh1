package lesson_303_07.practiceAssignment_303_7_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Task 4: Write a program that creates an integer array with 5 elements (i.e., numbers). 
 * The numbers can be any integers. 
 * Print out the value at the first index and the last index using length - 1 as the index. 
 * Now try printing the value at index = length (e.g., myArray[myArray.length] ). 
 * Notice the type of exception which is produced. 
 * Now try to assign a value to the array index 5. 
 * You should get the same type of exception.
 */
public class Task4 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a length of array: ");
		int length = scanner.nextInt();
		System.out.print("Enter an integers to fill array: ");
		int[] nums = new int[length];
		int idx = 0;
		while (length > idx) {
			nums[idx++] = scanner.nextInt();
		}
		System.out.println("Array: " + Arrays.toString(nums) + "\n");

		System.out.println("Value at the first index: nums[0] = " + nums[0]);
		System.out.println("Value at the last index: nums[" + (nums.length - 1) + "] = " + nums[nums.length - 1]);

		try {
			System.out.println("Value at the index: nums[" + nums.length + "] = " + nums[nums.length]);
		} catch (java.lang.ArrayIndexOutOfBoundsException e) {
			System.out.println("ERROR[ArrayIndexOutOfBoundsException]: index "+nums.length+" out of bounds for length "+nums.length);
		}

	}

}
