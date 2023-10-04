package lesson_303_11.GLAB_303_11_1;

public class MyRunnerGenericsMethod {
    public static void main(String[] args) {
        DemoClassGenericsMethod dObj = new DemoClassGenericsMethod();
        dObj.genericsMethod(25); // passing int
        dObj.genericsMethod("Per Scholas"); // passing String
        dObj.genericsMethod(2563.5); // passing float
        dObj.genericsMethod('H'); // passing Char

    }
}
