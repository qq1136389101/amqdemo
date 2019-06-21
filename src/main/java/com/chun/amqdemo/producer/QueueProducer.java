package com.chun.amqdemo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

/**
 * queue生产者
 * @Author chun
 * @Date 2019/6/21 0:07
 */
@Component
public class QueueProducer {

    @Autowired
    Queue queue1;
    @Autowired
    Queue queue2;
    @Autowired
    JmsTemplate jmsTemplate;

    public void send2Queue1(String msg){
        jmsTemplate.convertAndSend(queue1, msg);
    }

    public void send2Queue2(String msg){
        jmsTemplate.convertAndSend(queue2, msg);
    }
}
