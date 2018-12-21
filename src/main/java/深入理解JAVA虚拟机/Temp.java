package 深入理解JAVA虚拟机;

public class Temp {
    public static void main(String[] args) {
//        String s = new String("1");
//        s.intern();
//        System.out.println(s.hashCode());
//        System.out.println(s.intern().hashCode());
//        String s2 = "1";
//        System.out.println(s == s2);
//
//
//        String s3 = new String("1") + new String("1");
//        s3.intern();
//        String s4 = "11";
//        System.out.println(s3 == s4);
        String s2 = new String("1");
        s2.intern();
        String s1 = "1";
        System.out.println(s1 == s2);
    }
}
