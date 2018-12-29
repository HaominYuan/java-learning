package 深入理解JAVA虚拟机.垃圾收集器与内存分配策略;


/**
 * VM参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -Xlog:gc* -XX:SurvivorRatio=8
 */


public class TestPretenureSizeThreshold {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }
}
