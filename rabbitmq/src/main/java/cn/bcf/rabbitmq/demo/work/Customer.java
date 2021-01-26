package cn.bcf.rabbitmq.demo.work;

import cn.bcf.rabbitmq.demo.ConnUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Customer implements Basic{

    public static void getMessage(String queueName) throws IOException, TimeoutException {
        Connection conn = ConnUtil.getConn();
        Channel channel = conn.createChannel();
        channel.queueDeclare(queueName,false,true,);
    }
}
