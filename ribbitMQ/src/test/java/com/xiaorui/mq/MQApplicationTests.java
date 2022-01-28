package com.xiaorui.mq;

import com.xiaorui.mq.constants.RabbitMQConstant;
import com.xiaorui.mq.queue.QueueConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = MQApplication.class)
@RunWith(SpringRunner.class)
public class MQApplicationTests {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Test
    public void testMQ() {
        amqpTemplate.convertAndSend(RabbitMQConstant.QUEUE_EASY, "测试简单mq");
    }

}
