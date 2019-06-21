package com.chun.amqdemo.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @Author chun
 * @Date 2019/6/21 0:10
 */
@Component
public class TopicProducer {

    @Autowired
    Topic topic1;
    @Autowired
    Topic topic2;
    @Autowired
    JmsTemplate jmsTemplate;

    public void send2Topic1(String msg){
        jmsTemplate.convertAndSend(topic1, msg);
    }

    public void send2Topic2(String msg){
        jmsTemplate.convertAndSend(topic2, msg);
    }
}
