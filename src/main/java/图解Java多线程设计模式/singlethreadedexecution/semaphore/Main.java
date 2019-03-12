package 图解Java多线程设计模式.singlethreadedexecution.semaphore;

public class Main {
    public static void main(String[] args) {
        BoundedResource boundedResource = new BoundedResource(3);

        for (int i = 0; i < 10; i++) {
            new UserThread(boundedResource).start();
        }
    }
}
