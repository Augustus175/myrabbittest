package com.rabbitmq.myrabbit;

import com.rabbitmq.client.*;

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


//        factory.setHost("localhost");
//        factory.setPort(5672);
//        factory.setUsername("test");
//        factory.setPassword("123456");
//        factory.setVirtualHost("vhost_test");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // 声明队列，主要为了防止消息接收者先运行此程序，队列还不存在时创建队列。
        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
//        channel.queueDeclare();
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        // 创建队列消费者
        QueueingConsumer consumer = new QueueingConsumer(channel);
        // 指定消费队列
        channel.basicConsume(QUEUE_NAME, true, consumer);

        while (true) {
            // nextDelivery是一个阻塞方法（内部实现其实是阻塞队列的take方法）
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println(" [x] Received '" + message + "'");
        }
    }
}
