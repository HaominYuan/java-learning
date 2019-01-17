package 深入理解JAVA虚拟机.Java内存模型与线程;

public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race = race + 1;
    }

    private static final int THREADS_COUNT = 100;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }


        while (Thread.activeCount() > 2) {
//            System.out.println(Thread.activeCount());
            Thread.yield();
        }
        System.out.println(race);
    }
}
