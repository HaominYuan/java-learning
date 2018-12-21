package annotation.test2;

import annotation.test2.annotation.Field;
import annotation.test2.annotation.Table;

import java.lang.annotation.Annotation;

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clazz = Class.forName("annotation.test2.Student");
        Annotation[] annotations = clazz.getAnnotations();
//        获得类所有注解的值
        for (var annotation : annotations) {
            System.out.println(annotation.annotationType());
        }

//        获得类注解的值
        Table table = (Table) clazz.getAnnotation(Table.class);
        System.out.println(table.value());

        for (var temp : clazz.getDeclaredFields()) {
            Field field = temp.getAnnotation(Field.class);
            System.out.println(field.columnName() + "---" + field.type() + "---" + field.length());
        }
    }
}
