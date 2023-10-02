package lesson_303_5.loops;

/**
 * write a for loop that calculates the sum of all the numbers between 1 and 100
 * 1:02
 * 2. write a for loop that calculates the sum of the remainders of each number divided by 2 between 1 and 100
 * 1:03
 * 3.  write a for loop that calculates the sum of the divisor of each number divided by 2 between 1 and 100
 * 1:05
 * write a while loop ...  while a number is greater than 0 subtract 1 from the number starting at 10.
 */
public class Loops4Tasks {

    public static void main(String[] args) {
        int[] ints = new int[100];
        for (int idx = 0; idx < ints.length; idx++) {
            ints[idx] = idx+1;
        }
        System.out.println(loopSumInt(ints));
        System.out.println(loopSumRemider(ints));
        System.out.println(loopSumDivisor(ints));
        loopWhile();
    }

    private static int loopSumInt(int[] arr) {
        int sum = 0;
        for (int idx = 0; idx < arr.length; idx++) {
            sum = sum + arr[idx];
        }
        return sum;
    }

    private static int loopSumRemider(int[] arr) {
        int sum = 0;
        for (int idx = 0; idx < arr.length; idx++) {
            sum = sum + arr[idx] % 2;
        }
        return sum;
    }

    private static int loopSumDivisor(int[] arr) {
        int sum = 0;
        for (int idx = 0; idx < arr.length; idx++) {
            sum = sum + arr[idx] / 2;
        }
        return sum;
    }

    private static void loopWhile() {
        int num = 10;
        while (num > 0) {
            System.out.print(num + " ");
            num = num - 1;
        }
    }
}
