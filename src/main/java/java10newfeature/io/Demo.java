package java10newfeature.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Demo {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {

        var p = new PrintWriter("src/java10newfeature/io/1.txt", "gbk");
        p.println("我是中国人");
        p.flush();
        p.close();
    }
}
