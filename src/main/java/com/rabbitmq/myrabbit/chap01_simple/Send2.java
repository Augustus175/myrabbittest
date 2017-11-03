package com.rabbitmq.myrabbit.chap01_simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * Created by zhangzhibo-dell on 17-10-29.
 */
public class Send2 {
    // 队列名称
    private final static String QUEUE_NAME = "java";

    public static void main(String[] argv) throws Exception {
        /**
         * 创建连接连接到MabbitMQ
         */
        ConnectionFactory factory = new ConnectionFactory();
        // 设置MabbitMQ所在主机ip或者主机名
        factory.setHost("192.168.3.110");
        factory.setUsername("hadoop");
        factory.setPassword("123456");

        // 创建一个连接
        Connection connection = factory.newConnection();
        // 创建一个频道
        Channel channel = connection.createChannel();
        // 指定一个队列
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        // 发送的消息
        String message = "hello world!";
        StringBuilder sb = new StringBuilder(message);
        // 往队列中发出一条消息
        System.out.println(" [x] Sent '" + message + "'");
        for (int i = 0; i < 10000; i++) {
            Thread.sleep(1000);
            sb.append(" " + i);
            channel.basicPublish("", QUEUE_NAME, null, sb.toString().getBytes());
        }
        // 关闭频道和连接
        channel.close();
        connection.close();
    }
}