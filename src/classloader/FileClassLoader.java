package classloader;


import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileClassLoader extends ClassLoader {
    private String rootDir;

    public FileClassLoader(String rootDir) {
        this.rootDir = rootDir;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] classData = getClassData(name);
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new RuntimeException("读取文件失败");
        }
    }

    private byte[] getClassData(String className) throws IOException {
        String path = classNameToPath(className);
        return Files.readAllBytes(Paths.get(path));
    }

    private String classNameToPath(String className) {
        return rootDir + File.separatorChar + className.replace('.', File.separatorChar) + ".class";
    }

    public static void main(String[] args) {
        String rootDir = "/Users/haominyuan/Desktop/java/javalearning/src/";
        FileClassLoader loader = new FileClassLoader(rootDir);
        try {
            Class<?> object = loader.loadClass("classloader.TestClassLoader");
            System.out.println(object.getDeclaredConstructor().newInstance());
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
