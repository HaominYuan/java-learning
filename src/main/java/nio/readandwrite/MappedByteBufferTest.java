package nio.readandwrite;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class MappedByteBufferTest {
    public static void main(String[] args) throws IOException {
        FileInputStream inputStream = new FileInputStream("src/nio/readandwrite/nio-data.txt");
        FileChannel fileChannel = inputStream.getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileChannel.size());
        while (mappedByteBuffer.hasRemaining()) {
            System.out.print((char) mappedByteBuffer.get());
        }
    }
}
