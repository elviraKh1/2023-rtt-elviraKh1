package practice.assignment_303_2_3;

/**
 * Write a program that declares an integer a variable x, assigns the value 2 to
 * it, and prints out the binary string version of the number (
 * Integer.toBinaryString(x) ). Now, use the left shift operator (<<) to shift
 * by 1 and assign the result to x. Before printing the results, write a comment
 * with the predicted decimal value and binary string. Now, print out x in
 * decimal form and in binary notation. Perform the preceding exercise with the
 * following values: 9 17 8
 * 
 */
public class Class1 {
	public static void main(String[] args) {
		int[] nums = new int[] { 2, 9, 17, 8 };
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			System.out.println(Integer.toBinaryString(x));
			x = x << 1;
			System.out.println(Integer.toBinaryString(x));

		}
	}

}
