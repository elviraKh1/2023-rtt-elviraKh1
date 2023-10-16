package lambdas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Larry1");
        names.add("Larry2");
        names.add("Larry3");
        names.add("Larry4");
        names.add("Larry5");

        for (String name: names) {
            System.out.println(name);
        }
        System.out.println("___________");
        names.stream().forEach(m->{
            System.out.println(m);
        });
        System.out.println("___________lambda expression remove eleement");
        names.removeIf(name->name.endsWith("3"));
        names.stream().forEach(m->{
            System.out.println(m);
        });
        System.out.println("___________old way remove eleement");
        Iterator<String> it = names.iterator();
        while( it.hasNext()){
            String name = it.next();
            if (!name.startsWith("L")){
    //NOTE: Iterators
                it.remove();
            }
        }
    }
}
