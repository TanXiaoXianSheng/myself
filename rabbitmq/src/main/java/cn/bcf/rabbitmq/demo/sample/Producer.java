package cn.bcf.rabbitmq.demo.sample;

import cn.bcf.rabbitmq.demo.ConnUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Producer implements Basic{

    public static void sendMessage(String queueName) throws IOException, TimeoutException {
        Connection conn = ConnUtil.getConn();
        Channel channel = conn.createChannel();
        channel.queueDeclare(queueName,false,false,false,null);

        String msg = "hello hello";

        channel.basicPublish("",queueName,null,msg.getBytes());

        channel.close();
        conn.close();
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Producer.sendMessage(QUEUE_NAME);
    }
}
