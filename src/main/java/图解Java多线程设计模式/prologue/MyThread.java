package 图解Java多线程设计模式.prologue;

public class MyThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print("Nice!");
        }
    }

    public static void main(String[] args) {
        Thread thread = new MyThread();
        thread.start();
        for (int i = 0; i < 10000; i++) {
            System.out.print("Good!");
        }
    }
}
