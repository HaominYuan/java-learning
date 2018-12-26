package 深入理解JAVA虚拟机.垃圾收集器与内存分配策略;


/**
 * testGC()方法执行后，objA和objB会不会被GC呢？
 * -Xlog:gc*
 * 从输出的结果可以看到一行：Pause Full (System.gc()) 8M->1M(10M) 5.065ms。 表示内存回收。
 */


public class ReferenceCountingGC {
    public Object instance = null;

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGc() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();

    }

    public static void main(String[] args) {
        testGc();
    }
}
