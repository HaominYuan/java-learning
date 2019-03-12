import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Test {
    public static void main(String[] args) {
        ThreadFactory factory = Executors.defaultThreadFactory();
    }
}
