package annotation.test1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// Target表示作用对象, Retention表示作用的周期
@Target(value = {ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {

    String studentName() default "";

    int age() default 0;
    // -1 表示不存在
    int id() default -1;

    String[] school() default {"szu"};

    // 如果只有一个参数一般定义为value，并且在填写参数的时候不需要写value=
    String value() default "";

}
