package nio.charset;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class Temp {
    public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("src/nio/charset/data-utf-8", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        Charset charset = Charset.forName("utf-8");
        CharsetDecoder decoder = charset.newDecoder();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        CharBuffer charBuffer;
        while (channel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            charBuffer = decoder.decode(byteBuffer);
            System.out.println(charBuffer);
            byteBuffer.clear();
        }
        channel.close();
    }
}
