package reflect;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        String path = "reflect.Person";
        Class clazz = Class.forName(path);

        // javabean一定要加一个无参构造器并且不能为private，调用无参构造器
        Person person = (Person) clazz.getDeclaredConstructor().newInstance();
        System.out.println(person);

        // 调用有参构造器获得对象，最后获取属性
        person = (Person) clazz.getDeclaredConstructor(String.class, int.class).newInstance("yhm", 20);
        System.out.println(person.getName());
        System.out.println(person.getAge());

        // 通过反射api调用方法
        Method method = clazz.getDeclaredMethod("setName", String.class);
        method.invoke(person, "mhy");
        method = clazz.getDeclaredMethod("getName");
        System.out.println(method.invoke(person));


        // 通过反射操作属性，私有属性可以通过setAccessible方法使他可以被操作。并且禁止访问检查后可以加快反射的调用
        Field field = clazz.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person, "qwe");
        System.out.println(field.get(person));
    }
}
