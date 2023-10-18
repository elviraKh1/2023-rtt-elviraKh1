package lesson_303_4.stringMethods;
import java.util.StringJoiner;

public class StringJoinerDemo {
	public static void main(String[] args) {
		String[] arr = {"a","b","c","c","e"};
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
			if (i< arr.length) {
				System.out.print(",");
			}
		}
		StringJoiner s = new StringJoiner(",");
		 
	}
}
