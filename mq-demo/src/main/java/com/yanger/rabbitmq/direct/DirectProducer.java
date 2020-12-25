package com.yanger.rabbitmq.direct;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// 生产者
@Component
public class DirectProducer {
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
	
	public void send(String msg) {
        System.out.println("direct策略消息生产者发送消息：" + msg);
        // 参数：路由、消息，这里我们指定路由与队列的路由规则完全匹配
        rabbitTemplate.convertAndSend("direct_queue_1", "direct_queue_1路由的的消息-" + msg);
        rabbitTemplate.convertAndSend("direct_queue_2", "direct_queue_2路由的的消息-" + msg);
    }

}
