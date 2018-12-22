package 深入理解JAVA虚拟机.自动内存管理机制;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * VM Args: -XX:PermSize=10M -XX:MaxPermSize=10M
 * 在java8以后没有永久带替换为元空间
 * 此程序是不断的增强类，导致元空间动态的class过多，导致内存溢出。
 */

public class JavaMethodAreaOOM {

    private static class OOMObject { }


    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> methodProxy.invoke(o, objects));
            enhancer.create();

        }
    }
}
