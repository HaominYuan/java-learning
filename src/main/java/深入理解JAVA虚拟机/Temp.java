package 深入理解JAVA虚拟机;

import java.util.ArrayList;
import java.util.List;

public class Temp {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(System.currentTimeMillis() + "");
        }
    }
}
