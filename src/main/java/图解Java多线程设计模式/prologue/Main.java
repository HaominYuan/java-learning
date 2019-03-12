package 图解Java多线程设计模式.prologue;

public class Main {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Good!");
            try {
                Thread.sleep(100, 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
