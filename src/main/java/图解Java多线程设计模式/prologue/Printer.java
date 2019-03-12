package 图解Java多线程设计模式.prologue;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Printer implements Runnable {
    private String message;

    public Printer(String message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(message);
        }
    }

    public static void main(String[] args) {
        new Thread(new Printer("Good!")).start();
        new Thread(new Printer("Nice!")).start();

        ThreadFactory factory = Executors.defaultThreadFactory();
        factory.newThread(new Printer("Fuck!")).start();
    }
}
