package lesson_303_11;

public class MyRunnerGenericMethod {
    public static void main(String[] args) {

        GenericMethodExample obj = new GenericMethodExample();

        System.out.println( "===invoking regular method========" );
        obj.printValues(43);
        obj.printValues("Programmer");
        obj.printValues(54.43);
        obj.printValues(true);

        System.out.println( "===invoking static method========" );
        GenericMethodExample.staticdisplayData(254);
        GenericMethodExample.staticdisplayData("Java Developer");
        GenericMethodExample.staticdisplayData(254.25);

        Integer[] intArray = { 10, 20, 30, 40, 50 };
        Character[] charArray = { 'J', 'A', 'V', 'A'};
        System.out.println( "Printing Integer Array" );
        obj.printArray( intArray );
        System.out.println( "Printing Character Array" );
        obj.printArray( charArray );
    }
}
