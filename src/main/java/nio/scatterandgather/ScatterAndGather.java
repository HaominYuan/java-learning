package nio.scatterandgather;

import java.nio.ByteBuffer;

public class ScatterAndGather {
    public static void main(String[] args) {
//         读取时，仅在前一个数组的容量满了以后在将字符存入后一个数组
//        写入channel时，仅仅写开始到postion之间的内容
        ByteBuffer header = ByteBuffer.allocate(128);
        ByteBuffer body = ByteBuffer.allocate(1024);
        ByteBuffer[] buffers = {header, body};
//        channel.read(buffers);
//        channel.write(buffers);
    }
}
