package io.blocking;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * https://javadoop.com/post/nio-and-aio
 *
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/11 5:11 下午
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));

        while (true) {
            // 阻塞
            SocketChannel socketChannel = serverSocketChannel.accept();

            SocketHandler handler = new SocketHandler(socketChannel);
            new Thread(handler).start();
        }
    }

}
