package reflect;

import java10newfeature.var.User;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

public class Test4 {
    public Map<Integer, User> test01(Map<String, User> map, List<User> list) {
        System.out.println("方法一");
        return null;
    }


    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException {
        // 获取函数参数的泛型
        Class clazz = Class.forName("reflect.Test4");
        Method method = clazz.getMethod("test01", Map.class, List.class);
        Type[] types = method.getGenericParameterTypes();
        for (var type : types) {
            System.out.println("#" + type.getTypeName());
            if (type instanceof ParameterizedType) {
                for (var temp : ((ParameterizedType) type).getActualTypeArguments()) {
                    System.out.println(temp);
                }
            }
        }

        System.out.println("-----我是分隔符----");
        // 获取函数返回值的泛型
        Type type = method.getGenericReturnType();
        System.out.println("#" + type);
        if (type instanceof ParameterizedType) {
            for (var temp : ((ParameterizedType) type).getActualTypeArguments()) {
                System.out.println(temp);
            }
        }
    }


}
