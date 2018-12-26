package 深入理解JAVA虚拟机.Java内存区域与内存溢出异常;

/**
 * 虚拟机栈和本地方法栈OOM测试(仅作为第1点测试程序)
 * VM Args: -Xss128k
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    private void stackLeak() {
        stackLength = stackLength + 1;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable throwable) {
            System.out.println("stack length:" + oom.stackLength);
            throw throwable;
        }
    }
}
