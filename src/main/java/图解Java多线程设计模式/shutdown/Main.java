package 图解Java多线程设计模式.shutdown;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();
        runner.start();
        runner.shutdown();
    }
}
