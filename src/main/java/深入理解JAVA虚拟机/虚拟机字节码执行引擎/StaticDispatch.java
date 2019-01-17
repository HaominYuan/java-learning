package 深入理解JAVA虚拟机.虚拟机字节码执行引擎;


/**
 * 代码中刻意定义了两个静态类型相同但实际类型不同的变量，但虚拟机在重载时是通过参数的静态类型而不是实际类型作为判定依据
 */
public class StaticDispatch {
    static abstract class Human {
    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human gay) {
        System.out.println("Hello,guy!");
    }

    public void sayHello(Man guy) {
        System.out.println("Hello,gentleman!");
    }

    public void sayHello(Woman guy) {
        System.out.println("Hello,lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch staticDispatch = new StaticDispatch();
        staticDispatch.sayHello(man);
        staticDispatch.sayHello(woman);
    }


}
