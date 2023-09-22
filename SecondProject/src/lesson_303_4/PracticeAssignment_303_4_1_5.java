package lesson_303_4;

import java.util.Scanner;

/**
 * Write a program that uses if-else-if statements to print out grades A, B, C,
 * D, F, according to the following criteria: 
 * A: 90-100 
 * B: 80-89 
 * C: 70-79 
 * D: 60-69 
 * F: <60 Use the Scanner class to accept a number score from the user to
 * determine the letter grade. Print out “Score out of range” if the score is
 * less than 0 or greater than 100.
 * 
 */
public class PracticeAssignment_303_4_1_5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter score: ");
		int score = sc.nextInt();
		if (score > 100 || score < 0)
			System.out.println("Score out of range");
		if (score >= 90 && score <= 100)
			System.out.print("A");
		else if (score >= 80 && score <= 89)
			System.out.print("B");
		else if (score >= 70 && score <= 79)
			System.out.print("C");
		else if (score >= 60 && score <= 69)
			System.out.print("D");
		else if (score < 60 && score >= 0)
			System.out.print("F");

	}
}
