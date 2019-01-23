package 深入理解JAVA虚拟机.线程安全与锁优化;

import java.util.Vector;

public class VectorTest {
    private static final Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {

        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }


            Thread removeThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (int i = 0; i < vector.size(); i++) {
                            vector.remove(i);
                        }
                    }
                }
            });


            Thread printThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector) {
                        for (Integer integer : vector) {
                            System.out.println(integer);
                        }
                    }
                }
            });

            removeThread.start();
            printThread.start();

            while (Thread.activeCount() > 20) ;
        }


    }
}
