package lesson_303_6;

public class ArrayExample {

	public static void main(String[] args) {
		int size = 10;
		
		double[] dAr = new double[size];
		String[] sAr = new String[size];
		sAr[1] = "one";
		sAr[2] = "two";
		sAr[3] = "three";
		sAr[9] = "nine";
		sAr[0] = "zero";
		
		//this is going to fail and cause code execution to stop
		//sAr[11]="eleven"
		
		
		for (int i = 0; i < sAr.length; i++) {
			System.out.println("The value in position "+i+" is "+sAr[i]);
		}
		
		int countNulls = 0;
		for (String s : sAr) {
			if (s == null) {
				countNulls++;
			}
		}
		System.out.println(countNulls);
	}

}
