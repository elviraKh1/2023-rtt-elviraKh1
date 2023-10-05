package exceptions;

import java.util.Scanner;

public class ExceptionExamples {

    public static void main(String[] args) {
        ExceptionExamples exceptionExamples = new ExceptionExamples();
            try {
                exceptionExamples.readNumber();
//            String x = null;
//            x.toLowerCase();

            } catch (Exception e) {
                e.printStackTrace();
            }
    }
    //when you add throws Exception to a method  it forced a cheked exception
    public void readNumber() {//throws Exception{
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                System.out.print("Please enter a number: ");
                int x = scanner.nextInt();
                System.out.println("you entered the number: " + x);
                break;
            } catch (ArrayIndexOutOfBoundsException ioe) {
                System.out.println(ioe.getMessage());

            } catch (Exception e) {
                System.out.println("You didnt enter aa number");
                scanner.nextLine();
                //throw new Exception("The user did not enter a number");
            } finally {
                //most time this is used for resourse cleanup
                System.out.println("finally this is executes no matter what");
            }
        }
        System.out.println("This is line of code will only execute if no exception is throw");
    }
}
