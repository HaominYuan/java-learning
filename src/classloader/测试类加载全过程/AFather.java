package classloader.测试类加载全过程;

public class AFather {
    static int b = 1;

    static {
        System.out.println("静态初始化A_Father类");
    }
}
