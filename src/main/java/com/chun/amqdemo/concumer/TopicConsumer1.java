package com.chun.amqdemo.concumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author chun
 * @Date 2019/6/20 22:58
 */
@Component
public class TopicConsumer1 {

    @JmsListener(destination = "${application.topicName1}", containerFactory = "topicListenerFactory")
    public void readMsg(String msg){
        System.out.println("订阅组1接收到的消息:" + msg);
    }
}
