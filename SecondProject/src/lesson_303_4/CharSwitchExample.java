package lesson_303_4;

public class CharSwitchExample {
	public static void main(String[] args) {
		// Declaring a variable for switch expression
		char alphabet = 'b';
		switch (alphabet) // Switch expression
		{
		// Case statements
		case 'a':
			System.out.println("This is character 'a' ");
			break;
		case 'b':
			System.out.println("This is character 'b' ");
			break;
		case 'c':
			System.out.println("This is character 'c' ");
			break;
		// Default case statement
		default:
			System.out.println("Please enter valid input");
		}
	}

}
