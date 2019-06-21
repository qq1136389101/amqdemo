package com.chun.amqdemo.concumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @Author chun
 * @Date 2019/6/20 22:58
 */
@Component
public class QueueConsumer1 {

    @JmsListener(destination = "${application.queueName1}", containerFactory = "queueListenerFactory")
    public void readMsg(String msg){
        System.out.println("队列1接收到的消息:" + msg);
    }
}
