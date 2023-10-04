package collections;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SetDemo {
    public static void main(String[] args) {

        List<String> stringList =new ArrayList<>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("a");
        //can get by a position
        stringList.get(1);

        //set does not maintain position. It doesnt have .get() method
        Set<String> stringSet = new HashSet<>();
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");
        stringSet.add("a");
        for (String string: stringSet) {
            System.out.println(string);
        }
    }
}
