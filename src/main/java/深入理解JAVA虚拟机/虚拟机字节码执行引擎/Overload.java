package 深入理解JAVA虚拟机.虚拟机字节码执行引擎;

import java.io.Serializable;

public class Overload {

    public static void sayHello(Object arg) {
        System.out.println("Hello Object");
    }

    public static void sayHello(int arg) {
        System.out.println("Hello int");
    }

    public static void sayHello(long arg) {
        System.out.println("Hello long");
    }

    public static void sayHello(Character arg) {
        System.out.println("Hello Character");
    }

    public static void sayHello(char arg) {
        System.out.println("Hello char");
    }

    public static void sayHello(char... arg) {
        System.out.println("Hello char ...");
    }

    public static void sayHello(Serializable arg) {
        System.out.println("Hello Serializable");
    }

    public static void sayHello(double arg) {
        System.out.println("Hello double");
    }

    public static void main(String[] args) {
        // char->int->long->float->double->Character->Serializable->Object->char...
        // 自动类型转换->封装->Serializable->Object->数组
        sayHello('a');
    }
}
