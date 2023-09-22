package lesson_303_2.practice.assignment_303_2_3;

/**
 *  Write a program that declares a variable x, and assigns 150 to it,
 *  and prints out the binary string version of the number. 
 *  Now use the right shift operator (>>) to shift by 2 and assign the result to x. 
 *  Write a comment indicating what you anticipate the decimal and binary 
 *  values to be. Now print the value of x and the binary string.
	Perform the preceding exercise with the following values:
	225
	1555
	32456
 */
public class Class2 {
	
	public static void main(String[] args) {
		int[] nums = new int[] { 150, 225, 1555, 32456 };
		for (int i = 0; i < nums.length; i++) {
			int x = nums[i];
			System.out.println(Integer.toBinaryString(x));
			x = x >> 2;
			System.out.println(Integer.toBinaryString(x));

		}
	}

}
