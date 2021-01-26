package cn.bcf.rabbitmq.demo.work;

import cn.bcf.rabbitmq.demo.ConnUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class Producer implements Basic{

    public static void sendMessage(String queueName) throws IOException, TimeoutException {
        Connection conn = ConnUtil.getConn();
        Channel channel = conn.createChannel();
        channel.queueDeclare(queueName,false,true,false,null);

        for (int i = 0;i < 50;i ++) {
            channel.basicPublish("",queueName,null,(String.valueOf(System.currentTimeMillis())).getBytes(StandardCharsets.UTF_8));
        }

        channel.close();
        conn.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Producer.sendMessage(QUEUE_NAME);
    }
}
