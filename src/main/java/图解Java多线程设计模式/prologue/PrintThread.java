package 图解Java多线程设计模式.prologue;

public class PrintThread extends Thread {
    private String message;
    public PrintThread(String message) {
        this.message = message;
    }

    public void run() {
        for (int i = 0; i < 10000; i++) {
            System.out.print(message);
        }
    }

    public static void main(String[] args) {
        new PrintThread("Good!").start();
        new PrintThread("Nice!").start();

    }
}
