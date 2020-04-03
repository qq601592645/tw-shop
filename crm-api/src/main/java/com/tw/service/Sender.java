package com.tw.service;



import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by aisiA on 2019/5/6.
 */
@Component
public class Sender {
    @Autowired
  private RabbitTemplate rabbitTemplate;

    public void send() {
        String context = "hello " + new Date();
        System.out.println("Sender : " + context);
        rabbitTemplate.convertAndSend("hello", context);
    }

    public void sendMsg(String queueName,String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:"+sdf.format(new Date()));
        rabbitTemplate.convertAndSend("test_exchange_1", queueName, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                //message.getMessageProperties().setHeader("x-delay",60000);
                return message;
            }
        });
    }

    public void sendMsg(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:"+sdf.format(new Date()));
        rabbitTemplate.convertSendAndReceive(msg.getBytes(), new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("x-delay", 60000);
                return message;
            }
        });
    }

    public void sendMsgFanout(String msg) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("消息发送时间:"+sdf.format(new Date()));
        System.out.println("消息发送时间:"+msg);
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        rabbitTemplate.convertAndSend("amq.fanout", "", msg, correlationData);
    }



}
