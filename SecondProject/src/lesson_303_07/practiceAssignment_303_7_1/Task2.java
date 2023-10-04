package lesson_303_07.practiceAssignment_303_7_1;

/**
 * Task 2: Write a program that returns the middle element in an array. Give the
 * following values to the integer array: {13, 5, 7, 68, 2} and produce the
 * following output: 7
 */
public class Task2 {

	public static void main(String[] args) {

		int[] array = { 13, 5, 7, 68, 2 ,3}; 
		
		if (array.length % 2 != 0) {
			int middle = array.length / 2;
			System.out.println("The middle element in an array with odd length is " + array[middle]);
		} else {
			int middle1 = array.length / 2 - 1;
			int middle2 = array.length / 2;
			System.out.println(
					"The middle elements in an array with even length are " + array[middle1] + " and " + array[middle2]);
		}
	}
}
