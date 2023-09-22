package lesson_303_4.stringMethods;

import java.util.Arrays;

public class SplitDemo {
	public static void main(String[] args) {
		String vowels = "a::b::c::d:e";

		// splitting the string at "::"
		// storing the result in an array of strings
		String[] result = vowels.split("::");

		// converting array to string and printing it
		System.out.println("result = " + Arrays.toString(result));
	}

}
