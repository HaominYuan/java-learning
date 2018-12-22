package 深入理解JAVA虚拟机.自动内存管理机制;

import sun.misc.Unsafe;

import java.lang.reflect.Field;


/**
 * VM Args: -Xmx20M -XX:MaxDirectMemorySize=10M -XX:+HeapDumpOnOutOfMemoryError
 * 这里用的是Native Memory
 */

public class DirectMemory {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
