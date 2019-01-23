package 深入理解JAVA虚拟机.线程安全与锁优化;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {
    public static AtomicInteger race = new AtomicInteger();

    public static void increase() {
        race.incrementAndGet();
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        for (int i = 0; i < THREADS_COUNT; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 1000; i++) {
                        increase();
                    }
                }
            });
            threads[i].start();
        }


        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(race);
    }
}
