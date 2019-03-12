package 图解Java多线程设计模式.fault;

public class Something {
    private int x = 0;
    private int y = 0;

    public void write() {
        x = 100;
        y = 50;
    }

    public void read() {
        if (x < y) {
            System.out.println("x < y");
        }
    }
}
