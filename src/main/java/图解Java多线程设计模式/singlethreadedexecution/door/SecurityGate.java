package 图解Java多线程设计模式.singlethreadedexecution.door;

public class SecurityGate {
    private int counter = 0;

    public synchronized void enter() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter + 1;
    }

    public synchronized void exit() {
        int currentCounter = counter;
        Thread.yield();
        counter = currentCounter - 1;
    }

    public int getCounter() {
        return counter;
    }

}
