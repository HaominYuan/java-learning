package intern;


/**
 * String string = "1"  如果常量池中不存在"1",此时会在常量池中创建"1",并且指向常量池中的"1" 否则直接指向常量池中的"1"
 * String string = new String("1") 此时会在堆中"1",指向堆中的"1"
 * string.intern() 如果常量池中存在"1"则返回"1",否则查看堆中是否有"1",如果有则在常量池中放一堆中的引用,如果没有则创建一个
 * String string = new String("1") + new String("2");  此时会在常量池中创建"1", "2". 然后在堆内存中创建"12"
 *
 *
 */

public class Test1 {

    private static final int MAX = 10000;


    public static void main(String[] args) {
        String s = new String("1");
        String s2 = "1";
        s.intern();
        System.out.println(s.intern() == s2);
    }
}
