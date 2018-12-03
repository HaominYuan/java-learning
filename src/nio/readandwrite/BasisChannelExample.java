package nio.readandwrite;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class BasisChannelExample {

    public static void main(String[] args) throws IOException {
        copyFile();
    }


    private static void copyFile() throws IOException {
        // 获取通道
        FileInputStream fileInputStream = new FileInputStream("src/nio/nio-data.txt");
        FileChannel read = fileInputStream.getChannel();
        FileOutputStream fileOutputStream = new FileOutputStream("src/nio/nio-data2.txt");
        FileChannel write = fileOutputStream.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(512);
        // 将数据从通道输入缓冲区
        while (read.read(buffer) != -1) {
            buffer.flip();
            write.write(buffer);
            buffer.clear();
        }
        read.close();
        write.close();
    }

    private static void read() throws IOException {
        // 获取通道
        FileInputStream fileInputStream = new FileInputStream("src/nio/nio-data.txt");
        FileChannel channel = fileInputStream.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        // 将数据从通道读入缓冲区
        channel.read(buffer);
        channel.close();
    }

    private static void write() throws IOException {
        // 获取通道
        FileOutputStream fileOutputStream = new FileOutputStream("src/nio/nio-data2.txt");
        FileChannel channel = fileOutputStream.getChannel();
        // 创建缓冲区
        ByteBuffer buffer = ByteBuffer.allocate(8);
        // 编辑缓冲区
        byte b = 1;
        for (int i = 0; i < 8; i++) {
            buffer.put(b);
        }
        buffer.flip();
        channel.write(buffer);
        channel.close();
    }
}
