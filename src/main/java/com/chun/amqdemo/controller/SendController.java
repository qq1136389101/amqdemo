package com.chun.amqdemo.controller;

import com.chun.amqdemo.producer.QueueProducer;
import com.chun.amqdemo.producer.TopicProducer;
import org.apache.activemq.broker.region.Queue;
import org.apache.activemq.broker.region.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Destination;

/**
 * @Author chun
 * @Date 2019/6/20 22:52
 */
@RestController
@RequestMapping("/send")
public class SendController {

    @Autowired
    QueueProducer queueProducer;
    @Autowired
    TopicProducer topicProducer;

    @RequestMapping("/queue1")
    public String queue1(){
        queueProducer.send2Queue1("发给消息队列1");
        return "发送成功";
    }

    @RequestMapping("/queue2")
    public String queue2(){
        queueProducer.send2Queue2("发给消息队列2");
        return "发送成功";
    }

    @RequestMapping("/topic1")
    public String topic1(){
        topicProducer.send2Topic1("发给订阅组1");
        return "发送成功";
    }

    @RequestMapping("/topic2")
    public String topic2(){
        topicProducer.send2Topic2("发给订阅组2");
        return "发送成功";
    }
}
