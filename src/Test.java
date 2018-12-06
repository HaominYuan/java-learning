import java.lang.management.ManagementFactory;

public class Test {
    public static void main(String[] args) {
//        Object object = new Object();
//        new Thread(new PrintNumber(object)).start();
//        new Thread(new PrintAlpha(object)).start();

        var list = ManagementFactory.getGarbageCollectorMXBeans();
        for (var temp : list) {
            System.out.println(temp.getName());
        }
    }
}
