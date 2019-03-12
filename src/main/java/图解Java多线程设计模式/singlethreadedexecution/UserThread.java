package 图解Java多线程设计模式.singlethreadedexecution;

public class UserThread extends Thread {
    private final Gate gate;
    private final String myName;
    private final String myAddress;

    public UserThread(Gate gate, String myname, String myaddress) {
        this.gate = gate;
        this.myName = myname;
        this.myAddress = myaddress;
    }

    public void run() {
        System.out.println(myName + "BEGIN");
        while (true) {
            gate.pass(myName, myAddress);
        }
    }
}
