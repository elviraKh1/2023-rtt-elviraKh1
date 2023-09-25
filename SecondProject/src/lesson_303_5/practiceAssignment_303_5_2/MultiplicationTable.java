package lesson_303_5.practiceAssignment_303_5_2;

/**
 * Write a program that uses nested for loops to print a multiplication table.
 */
public class MultiplicationTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int i = 1; i <=12 ; i++) {
			for (int j = 1; j <= 12 ; j++) {
				System.out.print(i*j+"\t");
			}
			System.out.print("\n");
		}
	}

}
