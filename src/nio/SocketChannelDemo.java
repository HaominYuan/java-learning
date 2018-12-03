package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class SocketChannelDemo {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("172.31.234.14", 80));
        System.out.println(socketChannel.isConnected());
        System.out.println(socketChannel.finishConnect());
        ByteBuffer buf = ByteBuffer.allocate(48);
        System.out.println(socketChannel.read(buf));
        while (socketChannel.read(buf) == -1) {
            System.out.println(2);
            buf.flip();
            System.out.println(buf);
            buf.clear();
        }
        socketChannel.close();
    }
}
