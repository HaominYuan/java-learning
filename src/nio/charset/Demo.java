package nio.charset;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class Demo {
    public static void main(String[] args) throws Exception {
        test();
    }

    public static void test() {

        try {

            // 通过设置字符集的编码，并将ByteBuffer转换为CharBuffer来避免中文乱码
            Charset charset = Charset.forName("UTF-8");
            CharsetDecoder decoder = charset.newDecoder();

            RandomAccessFile file = new RandomAccessFile("src/nio/charset/data-utf-8", "rw");
            FileChannel fileChannel = file.getChannel();

            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            CharBuffer charBuffer = CharBuffer.allocate(1024);

            int byteread = fileChannel.read(byteBuffer);

            while (-1 != byteread) {

                System.out.println("read" + byteread);

                byteBuffer.flip();

                while (byteBuffer.hasRemaining()) {

                    decoder.decode(byteBuffer, charBuffer, false);
                    charBuffer.flip();

                    System.out.print(charBuffer);
                }

                byteBuffer.clear();
                charBuffer.clear();

                byteread = fileChannel.read(byteBuffer);

            }

            fileChannel.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
