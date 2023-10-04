package variables;

import java.util.Scanner;

public class ScannerExample {

	public static void main2(String[] args) {
		// create an Object of Scanner class
		Scanner input = new Scanner(System.in);
		System.out.print("Enter your name: ");
		// read input(line of text) from the keyboard
		String name = input.nextLine();
		// prints the name
		System.out.println("My name is " + name);
		// closes the scanner
		input.close();
	}

	public static void main67(String[] args) {
		Scanner scan = new Scanner(System.in);
		int i = scan.nextInt();
		double d = scan.nextDouble();
		scan.nextLine();
		String s = scan.nextLine();
		;
		;
		// Write your code here.

		System.out.println("String: " + s);
		System.out.println("Double: " + d);
		System.out.println("Int: " + i);
		scan.close();
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE+1);
	}

}
