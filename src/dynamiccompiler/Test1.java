package dynamiccompiler;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class Test1 {
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        // 第一种方式
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        int result = compiler.run(null, null, null, "src/dynamiccompiler/HelloWorld.java");
        System.out.println(result == 0 ? "编译成功" : "编译失败");


        // 第二种方式 不知道为什么搞不了
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec("java -cp ~/Desktop/java/javalearning  dynamiccompiler.HelloWorld");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String temp = "";
        while ((temp = bufferedReader.readLine()) != null) {
            System.out.println(temp);
        }

        // 第三种方式
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        Class c = classLoader.loadClass("dynamiccompiler.HelloWorld");
        Method method = c.getMethod("main", String[].class);
        method.invoke(null, (Object) new String[]{});
    }
}
