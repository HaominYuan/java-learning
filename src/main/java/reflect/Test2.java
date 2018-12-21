package reflect;


import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 获取class文件的对象
        Class clazz = Class.forName("Person");

        // 获得包名加类名
        System.out.println(clazz.getName());
        // 获得类名
        System.out.println(clazz.getSimpleName());


        // 获取属性
        System.out.println("获取属性");
        // 下面这种方法只能获得public属性
        Field[] fields = clazz.getFields();
        System.out.println(fields.length);
        // 下面这种方法可以获得所有属性
        fields = clazz.getDeclaredFields();
        System.out.println(fields.length);
        // 根据属性的名称获得属性
        Field field = clazz.getDeclaredField("name");
        System.out.println(field);

        // 获取方法
        System.out.println("\n获取方法");
        // 下面这种方法只能获得public方法
        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);
        // 下面这种方法可以获得所有方法
        methods = clazz.getDeclaredMethods();
        System.out.println(methods.length);
        // 根据方法的名称，获取单个方法的时候需要传参数，因为单单依靠函数的名字无法区分函数（重载）
        Method method = clazz.getMethod("Test1");
        System.out.println(method.getName());
        method = clazz.getMethod("Test1", String.class);
        System.out.println(method.getName());

        // 获取构造器
        // 下面这种方法只能获得public构造器
        Constructor[] constructors = clazz.getConstructors();
        System.out.println(constructors.length);
        // 下面这种方法可以获得所有构造器
        constructors = clazz.getDeclaredConstructors();
        System.out.println(constructors.length);
        // 根据构造器的参数获取构造器
        Constructor constructor = clazz.getDeclaredConstructor(String.class, int.class);
        System.out.println(constructor.getName());
    }
}
