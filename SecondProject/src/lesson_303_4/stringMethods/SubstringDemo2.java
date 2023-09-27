package lesson_303_4.stringMethods;

public class SubstringDemo2 {
	
	public static void main(String[] args) {
//					       **
		String str = "This is a string";
		String sub = str.substring(5, 7);
		System.out.println(sub);
		
		String fileName = "someimage.jpg";
		int lastDot = fileName.lastIndexOf(".");
		
		String ext = fileName.substring(fileName.lastIndexOf(".") + 1);
		
		System.out.println(ext);
		
		String name = "Eric Smith";
		String firstName = name.substring(0,name.indexOf(" "));
		String lastName = name.substring(name.indexOf(" ")+1);
		System.out.println(firstName);
		System.out.println(lastName);
		
		String example = "This is an example";
		
		
	}
}
