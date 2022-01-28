package com.xiaorui.mq.config;

import com.xiaorui.mq.constants.RabbitMQConstant;
import com.xiaorui.mq.exchange.ExchangeConfig;
import com.xiaorui.mq.queue.QueueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description 功能概述
 * @Author xp
 * @Date 2022/1/25 15:58
 * @Version V1.0
 **/
@Configuration
@Slf4j
public class RabbitMQConfig {

    @Autowired
    private QueueConfig queueConfig;

    @Autowired
    private ExchangeConfig exchangeConfig;

    @Bean
    public Binding bindingDirest() {
        return BindingBuilder.bind(queueConfig.easyQueue()).to(exchangeConfig.directExchange()).with(RabbitMQConstant.QUEUE_EASY);
    }

    @Bean
    public Binding bindingWork() {
        return BindingBuilder.bind(queueConfig.workQueue()).to(exchangeConfig.workExchange()).with(RabbitMQConstant.QUEUE_WORK);
    }

    @Bean
    public Binding bindTopic() {
        return BindingBuilder.bind(queueConfig.topicQueue()).to(exchangeConfig.topicExchange()).with(RabbitMQConstant.ROUTING_KEY_TOPIC_FIRST);
    }

    @Bean
    public Binding bindTopicSecond() {
        return BindingBuilder.bind(queueConfig.topicQueueSecond()).to(exchangeConfig.topicExchange()).with(RabbitMQConstant.ROUTING_KEY_TOPIC_SECOND);
    }

    @Bean
    public Binding bindingFanout() {
        return BindingBuilder.bind(queueConfig.fanoutQueue()).to(exchangeConfig.fanoutExchange());
    }

    @Bean
    public Binding bindingFanoutSecond() {
        return BindingBuilder.bind(queueConfig.fanoutQueueSecond()).to(exchangeConfig.fanoutExchange());
    }

}
