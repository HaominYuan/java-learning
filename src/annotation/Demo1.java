package annotation;


import java.util.ArrayList;
import java.util.List;

// 用于压制警告
@SuppressWarnings("all")
public class Demo1 {


    public static void main(String[] args) {
        System.out.println(new Demo1().test1());
    }

    @Override
    public String toString(){
        return "";
    }


    @Deprecated
    public String test1() {
        return "test方法被调用";
    }

    public String test2() {
        List list = new ArrayList();
        return "";
    }
}
