package lesson_303_7.practiceAssignment_303_7_1;

import java.util.Arrays;

/**
 * Task 6: Write a program where you create an integer array of 5 numbers. Loop
 * through the array and assign the value of the loop control variable
 * multiplied by 2 to the corresponding index in the array.
 * 
 */
public class Task6 {

	public static void main(String[] args) {
		
		int[] nums = new int[5];
		
		for (int i = 0; i < nums.length; i++) {
			nums[i] = i * 2;
		}
		
		System.out.println(Arrays.toString(nums));
	}
}
