package com.rabbitmq.myrabbit.chap01_simple;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * Created by zhangzhibo-dell on 17-10-29.
 */
public class Recv2 {
    // 队列名称
    private final static String QUEUE_NAME = "java";

    public static void main(String[] argv) throws Exception,
            ShutdownSignalException, ConsumerCancelledException,
            InterruptedException {

        // 打开连接和创建频道，与发送端一样
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.3.110");
        factory.setUsername("hadoop");
        factory.setPassword("123456");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        channel.queueDeclare();
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");
        //      DefaultConsumer类实现了Consumer接口，通过传入一个频道，告诉服务器我们需要那个频道的消息，如果频道中有消息，就会执行回调函数handleDelivery
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, "UTF-8");
                System.out.println("C [x] Received '" + message + "'");
            }
        };
//      自动回复队列应答 -- RabbitMQ中的消息确认机制，后面章节会详细讲解
        channel.basicConsume(QUEUE_NAME, true, consumer);

    }
}
