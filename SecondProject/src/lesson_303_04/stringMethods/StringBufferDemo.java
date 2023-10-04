package lesson_303_04.stringMethods;

public class StringBufferDemo {

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("135qwert");
        System.out.println(sb.toString());
        sb.replace(0, 5, "6789");
        System.out.println(sb.toString());
        sb.insert(0, "12345");
        System.out.println(sb.toString());
        sb.reverse();
        System.out.println(sb.toString());
        sb.delete(0, 5);
        System.out.println(sb.toString());

    }
}
