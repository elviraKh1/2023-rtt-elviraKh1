package lesson_303_07.practiceAssignment_303_7_1;

import java.util.Arrays;

/**
 * Task 7: Write a program where you create an array of 5 elements. Loop through
 * the array and print the value of each element, except for the middle (index
 * 2) element.
 */
public class Task7 {
	public static void main(String[] args) {

		int[] nums = new int[5];

		for (int i = 0; i < nums.length; i++) {
			nums[i] = i * 2;
		}
		System.out.println("All array values: "+Arrays.toString(nums));
		for (int i = 0; i < nums.length; i++) {
			if (i == 2) {
				continue;
			} else {
				System.out.println("nums["+i+"] = "+nums[i]);
			}
		}

		
	}
}
