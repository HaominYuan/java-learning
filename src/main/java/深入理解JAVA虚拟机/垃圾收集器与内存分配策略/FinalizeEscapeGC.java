package 深入理解JAVA虚拟机.垃圾收集器与内存分配策略;

public class FinalizeEscapeGC {
    private static FinalizeEscapeGC SAVE_HOOK = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();

        // 对象第一次成功拯救自己
        func();

        // 上面这段代码完全相同，但是这次自救失败了
        func();

    }

    private static void func() throws InterruptedException {
        SAVE_HOOK = null;
        System.gc();
        // 因为finalize方法优先级很低，所以暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            System.out.println("yes, i am still alive :)");
        } else {
            System.out.println("no, i am dead :(");
        }
    }
}
