package variables;

public class EscapeCharacters {

	public static void main(String[] args) {
		
		//this is an example of the tab escape character
		System.out.println("This is a tab character ->\t<-");
		
		//this is an example of a new line character \n
		System.out.println("This is line 1\nThis is line 2");

		//what happens if I want to print just a \
		System.out.println("To get a slassh to print we need 2 of them \\");
		
		System.out.println("This is a form feed literal \f\f\f\f");
		System.out.println("Carriage-return character: \rnew line");
		
		
		System.out.println("N\tName\tLastName");
		System.out.println("1.\tAdam\tSmith");
		System.out.println("2.\tHanna\tBush");
	}

}
