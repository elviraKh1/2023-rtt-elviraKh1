package exceptions;

import java.util.Scanner;

public class ExceptionExamples {

    public static void main(String[] args) {
        ExceptionExamples exceptionExamples = new ExceptionExamples();
        try {
            exceptionExamples.readNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //when you add throws Exception to a method  it forced a cheked exception
    public void readNumber() throws Exception{
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Please enter a number: ");
            int x = scanner.nextInt();
            System.out.println("you entered the number: " + x);
        } catch (Exception e) {
            System.out.println("You didnt enter aa number");
        } finally {
            //most time this is used for resourse cleanup
            System.out.println("finally this is executes no matter what");
        }

    }
}
