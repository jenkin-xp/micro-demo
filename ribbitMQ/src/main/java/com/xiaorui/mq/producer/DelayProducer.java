package com.xiaorui.mq.producer;

import com.xiaorui.mq.constants.RabbitMQConstant;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.text.MessageFormat;

/**
 * @Description 延迟队列
 * @Author xp
 * @Date 2022/1/26 14:33
 * @Version V1.0
 **/
@Component
public class DelayProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    /**
     * PS：安装rabbitmq_delayed_message_exchange插件，使用延迟队列
     * 使用场景：
     *   1、淘宝七天自动确认收货扣款
     *   2、下单后30分钟内未支付自动取消订单
     */
    public void send(int minutes) {
        String msg = MessageFormat.format("此任务将在{0}分钟后执行", minutes);
        Message message = MessageBuilder.withBody(msg.getBytes()).build();
        MessageProperties messageProperties = message.getMessageProperties();
        messageProperties.setDelay(minutes);
        amqpTemplate.convertAndSend(RabbitMQConstant.EXCHANGE_DIRECT, RabbitMQConstant.ROUTING_KEY_DELAY, message);
    }

}
