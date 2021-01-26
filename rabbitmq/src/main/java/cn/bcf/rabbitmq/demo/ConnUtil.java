package cn.bcf.rabbitmq.demo;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class ConnUtil {

    private ConnUtil() {

    }

    private static String HOST = "127.0.0.1";
    private static int PORT = 5672;
    private static String VHOST = "my_vhost";
    private static String USERNAME = "admin";
    private static String PASSWORD = "admin";

    public static Connection getConn() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setPort(PORT);
        factory.setVirtualHost(VHOST);
        factory.setUsername(USERNAME);
        factory.setPassword(PASSWORD);

        Connection conn = factory.newConnection();
        return conn;
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        System.out.println(ConnUtil.getConn());
    }
}
