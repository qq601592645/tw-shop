package com.tw.service;


import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by aisiA on 2019/5/6.
 */
@Component

public class Receiver {

//    @RabbitHandler
//    @RabbitListener(queues = "hello")
//    public void process(String hello) {
//        System.out.println("Receiver : " + hello);
//    }

    @RabbitListener(queues = "test_queue_2")
    public void receive2(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息接收时间2:"+sdf.format(new Date()));
        System.out.println("接收到的消息2:"+msg);
    }

//    @RabbitListener(queues = "test_queue_1")
//         public void receive1(String msg) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println("消息接收时间1:"+sdf.format(new Date()));
//        System.out.println("接收到的消息:"+msg);
//    }

    @RabbitListener(queues = "test_queue_1")
    public void process(Message message, Channel channel) throws IOException, InterruptedException {
        // 采用手动应答模式, 手动确认应答更为安全稳定
        //Thread.sleep(30000);
        //channel.basicAck(message.getMessageProperties().getDeliveryTag(), true);

       channel.basicNack(message.getMessageProperties().getDeliveryTag(), false,true);
        System.out.println("接收到的消息1:"+message.toString());
    }
}
