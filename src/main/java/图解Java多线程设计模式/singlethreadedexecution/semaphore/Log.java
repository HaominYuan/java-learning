package 图解Java多线程设计模式.singlethreadedexecution.semaphore;

public class Log {
    public static void println(String s) {
        System.out.println(Thread.currentThread().getName() + ": " + s);
    }
}
