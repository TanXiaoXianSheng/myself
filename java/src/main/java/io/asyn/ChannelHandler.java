package io.asyn;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.CompletionHandler;
import java.nio.charset.StandardCharsets;

/**
 * @Description：TODO
 * @Author：bichengfei
 * @Date：2021/5/12 10:57 上午
 */
public class ChannelHandler implements CompletionHandler<Integer, Attachment> {

    @Override
    public void completed(Integer result, Attachment attachment) {
        if (attachment.isReadMode()) {
            ByteBuffer buffer = attachment.getBuffer();
            buffer.flip();
            byte[] bytes = new byte[buffer.limit()];
            buffer.get(bytes);
            String msg = buffer.array().toString().trim();
            System.out.println("收到来自客户端的数据:" + msg);

            buffer.clear();
            buffer.put("服务端返回:".getBytes(StandardCharsets.UTF_8));
            attachment.setReadMode(false);
            buffer.flip();

            attachment.getClient().write(buffer, attachment, this);
        } else {
            try {
                attachment.getClient().close();
            } catch (IOException e) {

            }
        }
    }

    @Override
    public void failed(Throwable exc, Attachment attachment) {
        System.out.println("连接断开");
    }
}
