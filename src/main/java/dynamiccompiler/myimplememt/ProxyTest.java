package dynamiccompiler.myimplememt;



import jdk.internal.reflect.Reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {
        func();
        Person zhangsan = new Student("张三");
        InvocationHandler invocationHandler = new StuInvocationHandler<>(zhangsan);
        Person personProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, invocationHandler);
        System.out.println(personProxy.giveMoney(100));

    }


    public static void func() {
        System.out.println(Reflection.getCallerClass());
    }
}



