package cn.bcf.rabbitmq.demo.sample;

import cn.bcf.rabbitmq.demo.ConnUtil;
import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer implements Basic{

    public static void getMessage(String queueName) throws IOException, TimeoutException {
        Connection conn = ConnUtil.getConn();
        Channel channel = conn.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        Consumer consumer = new DefaultConsumer(channel) {

            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body,"UTF-8");
                System.out.println("接收：" + message);
            }
        };

        channel.basicConsume(queueName,true,consumer);
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Customer.getMessage(QUEUE_NAME);
    }
}
