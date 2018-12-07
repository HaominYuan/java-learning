package classloader.测试类加载全过程;

class A extends AFather {

//    静态代码块的初始化是按照顺序执行的。比较最后面输出的时候x和z的值。
    static int x = 100;
    static int y;

    static {
        System.out.println("静态代码初始化A类");
        x = 300;
        z = 300;
    }

    static int z = 100;

    final static int a = 10;

//
//    public static int getX() {
//        return x;
//    }
//
//    public static int getY() {
//        return y;
//    }
//
//    public static int getZ() {
//        return z;
//    }
}
