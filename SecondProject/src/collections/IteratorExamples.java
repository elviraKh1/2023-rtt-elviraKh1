package collections;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorExamples {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");

        strings.remove(0);

        for (String str: strings) {
            System.out.println(str);
        }
        System.out.println("=======================");

        Iterator<String> itr = strings.iterator();
        while(itr.hasNext()){
            System.out.println(itr.next());

        }
    }
}
