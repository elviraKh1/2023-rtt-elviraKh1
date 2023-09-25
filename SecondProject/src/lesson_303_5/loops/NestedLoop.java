package lesson_303_5.loops;

public class NestedLoop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for (int outer = 1; outer <= 10 ; outer++) {
			for (int inner = 1; inner <= outer; inner++) {
				System.out.print("X");
			}
			System.out.print("\n");
		}
		
	}

}
