package 图解Java多线程设计模式.shutdown;

public class Runner extends Thread {
    private boolean quit = false;

    @Override
    public void run() {
        while (!quit) {
        }
        System.out.println("Done");
    }

    public void shutdown() {
        quit = true;
    }
}
