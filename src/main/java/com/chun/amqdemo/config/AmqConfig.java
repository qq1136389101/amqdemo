package com.chun.amqdemo.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * @Author chun
 * @Date 2019/6/20 23:43
 */
@Configuration
@EnableJms
public class AmqConfig {

    @Value("${application.queueName1}")
    public String queue1;

    @Value("${application.queueName2}")
    public String queue2;

    @Value("${application.topicName1}")
    public String topic1;

    @Value("${application.topicName2}")
    public String topic2;

    @Bean
    public Queue queue1(){
        return new ActiveMQQueue(queue1);
    }

    @Bean
    public Queue queue2(){
        return new ActiveMQQueue(queue2);
    }

    @Bean
    public Topic topic1(){
        return new ActiveMQTopic(topic1);
    }

    @Bean
    public Topic topic2(){
        return new ActiveMQTopic(topic2);
    }

    /**
     * topic模式的ListenerContainer
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        ActiveMQConnectionFactory connectionFactor=new ActiveMQConnectionFactory();
        factory.setPubSubDomain(true);
        factory.setConnectionFactory(connectionFactor);
        return factory;
    }

    /**
     * queue模式的ListenerContainer
     * @return
     */
    @Bean
    public JmsListenerContainerFactory<?> queueListenerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        ActiveMQConnectionFactory connectionFactor=new ActiveMQConnectionFactory();
        factory.setPubSubDomain(false);
        factory.setConnectionFactory(connectionFactor);
        return factory;
    }
}
