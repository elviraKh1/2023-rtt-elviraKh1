package lesson_303_11.GLAB_303_11_1;

public class DemoClassGenericsMethod {

    // create a generics method
    public <T> void genericsMethod(T data) {
        System.out.println("Generics Method:");
        System.out.println("Data Passed: " + data);
    }

}
