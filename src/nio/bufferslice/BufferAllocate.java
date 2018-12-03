package nio.bufferslice;

import java.nio.ByteBuffer;

public class BufferAllocate {
    public static void main(String[] args) {
        // 静态分配
        ByteBuffer buffer1 = ByteBuffer.allocate(1024);
        // 可以把数组转换为缓冲区
        byte[] array = new byte[1024];
        ByteBuffer buffer2 = ByteBuffer.wrap(array);
    }
}
