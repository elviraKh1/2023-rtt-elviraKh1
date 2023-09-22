package lesson_303_4;

import java.util.Scanner;

public class SwitchNoBreaks {
public static void main(String[] args) {
	System.out.print("Enter days number: ");
	Scanner s = new Scanner(System.in);
	int day = s.nextInt();
	switch (day) {
	  case 1: 
	  case 2: 
	  case 3: 
	  case 4: 
	  case 5: System.out.println("Weekday"); break;
	  case 0:  
	  case 6: System.out.println("Weekend"); break;
	  default: System.out.println("Wrong number");
	} 

}
}
