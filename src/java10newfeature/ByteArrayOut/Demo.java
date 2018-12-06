package java10newfeature.ByteArrayOut;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

public class Demo {
    public static void main(String[] args) throws UnsupportedEncodingException {
        var s = "我是中国人";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(s.getBytes("gbk"));
        var byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        while ((i = byteArrayInputStream.read()) != -1) {
            byteArrayOutputStream.write(i);
        }
        System.out.println(byteArrayOutputStream.toString("gbk"));
    }
}
