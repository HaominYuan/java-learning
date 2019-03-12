package 图解Java多线程设计模式.singlethreadedexecution.door;

import singleton.Crack;

public class Main {
    public static void main(String[] args) {
        System.out.println("Testing SecurityGare");
        for (int trial = 0; true; trial++) {
            SecurityGate gate = new SecurityGate();
            CrackerThread[] t = new CrackerThread[5];

            for (int i = 0; i < t.length; i++) {
                t[i] = new CrackerThread(gate);
                t[i].start();
            }

            for (CrackerThread crackerThread : t) {
                try {
                    crackerThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            if (gate.getCounter() == 0) {
                System.out.println(".");
            } else {
                System.out.println("SecurityGate is NOT safe!");
                System.out.println("getCounter() == " + gate.getCounter());
                System.out.println("trial = " + trial);
                break;
            }

        }
    }
}
