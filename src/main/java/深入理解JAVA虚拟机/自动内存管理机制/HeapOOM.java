package 深入理解JAVA虚拟机.自动内存管理机制;

import java.util.ArrayList;
import java.util.List;


/**
 * Java堆内存溢出异常测试
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {
    private static class OOMObject { }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }

}
