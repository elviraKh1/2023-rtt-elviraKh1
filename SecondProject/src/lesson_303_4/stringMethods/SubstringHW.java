package lesson_303_4.stringMethods;

public class SubstringHW {

	public static void main(String[] args) {

		String example = "This is an example";
		System.out.println("The string is \"" + example + "\"\n");
		
		System.out.println( "****************************************");
		// find the position of the first space in the string
		int firstSpacePosition = example.indexOf(" ");
		System.out.println("The first space " + firstSpacePosition);

		System.out.println( "****************************************");
		// find the position of the last space in the string
		int lastSpacePosition = example.lastIndexOf(" ");
		System.out.println("The last space " + lastSpacePosition);

		System.out.println( "****************************************");
		// substring of the characters between the first and last space of the string
		String subBetweenSpaces = example.substring(firstSpacePosition + 1, lastSpacePosition);
		System.out.println("Substring between the 1st and last space \"" + subBetweenSpaces + "\"\n");

		System.out.println( "****************************************");
		// do the same thing to find the substring of the first and last vowel of the
		// string
		String vowels = "aeiou";
		char firstVowel=0;
		char lastVowel=0;
		
		for (int i = 0; i < example.length(); i++) {
			if (vowels.indexOf(example.charAt(i)) != -1) {
				firstVowel = example.charAt(i);
				break;
			}
		}
		for (int i = example.length() - 1; i > 0; i--) {
			if (vowels.indexOf(example.charAt(i)) != -1) {
				lastVowel = example.charAt(i);
				break;
			}
		}
		System.out.println("FirstVowel=" + firstVowel + " with posiition " + example.indexOf(firstVowel));
		System.out.println("LastVowel =" + lastVowel + " with posiition " + example.lastIndexOf(lastVowel));
		String subBetweenVowels = example.substring(example.indexOf(firstVowel), example.lastIndexOf(lastVowel) + 1);
		System.out.println("Substring between the 1st and last vowel \"" + subBetweenVowels + "\"\n");

		System.out.println( "****************************************");
		// use the string.charAt function and use a for loop to loop over the entire
		// string
		// and print out each character with a new line after it.
		// you need to use the string.length() function also
		for (int i = 0; i < example.length(); i++) {
			System.out.println(example.charAt(i));
			
		}

		System.out.println( "****************************************");
		// using only indexOf(" ") print the substring that contains the word "is"
		// use 2 substrings to do this.
		String subString1 = example.substring(example.indexOf(" ")+1); // "is an example"
		String subIS = subString1.substring(0,subString1.indexOf(" ")); // "is"
		 
		System.out.println(subIS);
	}
}
