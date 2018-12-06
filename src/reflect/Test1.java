package reflect;


public class Test1 {


    public static void main(String[] args) throws ClassNotFoundException {
        String path = "java.lang.String";
        // 反射的三种方式。
        System.out.println(path.getClass());
        System.out.println(Class.forName(path));
        System.out.println(String.class);


        Class class1 = path.getClass();
        Class class2 = Class.forName(path);
        Class class3 = String.class;

        // 三种方式获得的对象是相同的
        if (class1 == class2) {
            System.out.println(true);
        }

        if (class2 == class3) {
            System.out.println(true);
        }

        // 同一类型同一纬度的数组通过反射获得的对象是相同的，否则不相同。
        System.out.println(int[].class.hashCode());
        System.out.println(int[][].class.hashCode());
        System.out.println(double[].class.hashCode());


        // 下面这种方式是不会加载静态块
        Class clazz = Person.class;
        System.out.println("---");
        // 下面这种方式会加载静态块
        Class.forName("reflect.Temp");
    }
}
