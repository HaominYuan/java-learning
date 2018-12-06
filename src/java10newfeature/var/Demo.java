package java10newfeature.var;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Demo {
    public static void main(String[] args) {
        var i = 10;
        var str = "abc";
        var list = new ArrayList<>();
        list.add("list test1 java10newfeature.var");
        var set = new HashSet<>();
        set.add("set text java10newfeature.var");
        var map = new HashMap<>();
        map.put("test1", "map test1 java10newfeature.var");
        var user = new User();
        user.setAge(20);
        user.setName("user test1 java10newfeature.var");
        System.out.println(i);
        System.out.println(str);
        for (Object o : list) {
            System.out.println(o);
        }

        for (var temp : set) {
            System.out.println(temp);
        }

        for (var key : map.keySet()) {
            System.out.println(key);
        }

        System.out.println(user);


        // 局部变量不允许赋值null
//        java10newfeature.var aaa = null;
    }
}
