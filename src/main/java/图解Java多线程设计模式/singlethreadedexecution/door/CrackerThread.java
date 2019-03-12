package 图解Java多线程设计模式.singlethreadedexecution.door;

public class CrackerThread extends Thread {
    private final SecurityGate gate;

    public CrackerThread(SecurityGate gate) {
        this.gate = gate;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            gate.enter();
            gate.exit();
        }
    }
}
