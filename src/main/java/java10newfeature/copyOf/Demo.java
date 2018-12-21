package java10newfeature.copyOf;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        var list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        var list2 = List.copyOf(list);
        for (var temp : list2) {
            System.out.println(temp);
        }

        list.set(0, 2);

        for (var temp : list2) {
            System.out.println(temp);
        }
    }
}
