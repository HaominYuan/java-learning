package java10newfeature.transferto;

import java.io.*;

public class Demo {
    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("src/java10newfeature/transferto/1.txt");
        OutputStream outputStream = new FileOutputStream("src/java10newfeature/transferto/2.txt");
        inputStream.transferTo(outputStream);
        outputStream.flush();
        outputStream.close();
        inputStream.close();
    }
}
