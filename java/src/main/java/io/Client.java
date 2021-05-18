package io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/11 5:24 下午
 */
public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        ByteBuffer buffer = ByteBuffer.wrap("123435566766".getBytes());
        socketChannel.write(buffer);

        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num;
        if ((num = socketChannel.read(readBuffer)) > 0) {
            readBuffer.flip();

            byte[] bytes = new byte[num];
            readBuffer.get(bytes);

            String str = new String(bytes, "UTF-8");
            System.out.println("返回值：" + str);
        }
    }

}
