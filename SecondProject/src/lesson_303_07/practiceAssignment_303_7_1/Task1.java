package lesson_303_07.practiceAssignment_303_7_1;

/**
 * Task 1: Write a program that creates an array of integers with a length of 3.
 * Assign the values 1, 2, and 3 to the indexes. Print out each array element.
 * 
 */
public class Task1 {

	public static void main(String[] args) {

		int[] nums = new int[3];
		nums[0] = 1;
		nums[1] = 2;
		nums[2] = 3;

		for (int pos = 0; pos < nums.length; pos++) {
			System.out.println("nums[" + pos + "]=" + nums[pos]);
		}
	}

}
