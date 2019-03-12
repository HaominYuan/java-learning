package 图解Java多线程设计模式.fault;

public class Main {
    public static void main(String[] args) {

        while (true) {
            final Something obj = new Something();
            new Thread(obj::write).start();
            new Thread(obj::read).start();
        }



    }
}
