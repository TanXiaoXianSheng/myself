package io.asyn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;

import static java.lang.System.*;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/12 10:48 上午
 */
public class Server {

    public static void main(String[] args) throws IOException {
        AsynchronousServerSocketChannel asynServerSocketChannel = AsynchronousServerSocketChannel.open();
        asynServerSocketChannel.bind(new InetSocketAddress(8080));

        Attachment attachment = new Attachment();
        attachment.setServer(asynServerSocketChannel);

        asynServerSocketChannel.accept(attachment, new CompletionHandler<AsynchronousSocketChannel, Attachment>() {

            @Override
            public void completed(AsynchronousSocketChannel client, Attachment attachment) {
                try {
                    SocketAddress clientAddr = client.getRemoteAddress();
                    out.println("接收新的连接:" + clientAddr);

                    attachment.getServer().accept(attachment, this);

                    Attachment newAttachment = new Attachment();
                    newAttachment.setServer(asynServerSocketChannel);
                    newAttachment.setClient(client);
                    newAttachment.setReadMode(true);
                    newAttachment.setBuffer(ByteBuffer.allocate(2048));

                    client.read(newAttachment.getBuffer(), newAttachment, new ChannelHandler());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Attachment attachment) {

            }

        });

    }

}
