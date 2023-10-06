package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Qustion1 {
    String[] array = new String[10];
    List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Qustion1 q = new Qustion1();
        q.run();

        System.out.println(q.list);
        q.replace(1, "");
        System.out.println(Arrays.toString(q.array));
        System.out.println(q.list);
        System.out.println("+++++++++++++++++++++");
        System.out.println(q.removeEmpties());
        System.out.println(q.list);
    }

    public  void run () {
        Arrays.fill(array,"ten");
        for (int i = 0; i < array.length; i++) {
            list.add(i,array[i]);
            System.out.printf("I have added %s at position %d\n",array[i],i);
        }
    }
    public  void replace (int pos, String repl) {
        array[pos]=repl;
        list.set(pos,repl);
    }

    public List<String> removeEmpties () {
        List<String> l = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("")){
                l.add(array[i]);
            }
        }
       list.removeIf(str->str.equals(""));
        return l;
    }
}