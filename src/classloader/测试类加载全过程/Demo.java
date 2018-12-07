package classloader.测试类加载全过程;

public class Demo {
    public static void main(String[] args) throws ClassNotFoundException {
//        System.out.println("x:" + A.x);
//        System.out.println("y:" + A.y);
//        System.out.println("z:" + A.z);


        // 不会发生类初始化的操作
        // 调用常量
        System.out.println(A.a);
        // 用下面这种方式调用反射
        Class clazz = A.class;
        // 数组定义也不会进行类初始化
        A[] as = new A[]{};
        // 通过子类去访问父类的静态域时，子类不会被初始化
        System.out.println(A.b);

        System.out.println("------我是分割符-------");
        // 会被初始化的操作
        A a = new A();
        clazz = Class.forName("classloader.测试类加载全过程.A");
    }


}

