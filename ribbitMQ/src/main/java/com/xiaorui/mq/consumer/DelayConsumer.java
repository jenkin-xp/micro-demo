package com.xiaorui.mq.consumer;

import com.rabbitmq.client.Channel;
import com.xiaorui.common.util.DateUtils;
import com.xiaorui.mq.constants.RabbitMQConstant;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Date;


/**
 * @Description 延迟队列接收
 * @Author xp
 * @Date 2022/1/26 15:12
 * @Version V1.0
 **/
@Component
public class DelayConsumer {

    @RabbitListener(queues = RabbitMQConstant.QUEUE_DELAY)
    public void delayReceive(Message message, Channel channel) {
        long tagId = message.getMessageProperties().getDeliveryTag();
        try {
            String msg = new String(message.getBody());
            System.out.println(DateUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss") + "收到的消息：" + msg);
            channel.basicAck(tagId, false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
