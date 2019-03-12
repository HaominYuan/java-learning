package 图解Java多线程设计模式.singlethreadedexecution.spoonandfork;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing EaterThread, hit CTRL+C to exit.");
        Tool spoon = new Tool("Spoon");
        Tool fork = new Tool("Fork");
        new EnterThread("Alice", spoon, fork).start();
        new EnterThread("Bobby", fork, spoon).start();
    }
}
