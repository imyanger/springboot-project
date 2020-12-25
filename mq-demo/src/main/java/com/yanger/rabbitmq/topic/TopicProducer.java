package com.yanger.rabbitmq.topic;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yanger.rabbitmq.direct.DirectConfig;

@Component
public class TopicProducer {
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
	
	public void send(String msg) {
		System.out.println("topic策略消息生产者发送消息：" + msg);
		// 参数：交换机、路由、消息，这里的路由中all表示任意一个或多个字符
        rabbitTemplate.convertAndSend("topic", "routingkey.all", "routingkey.all路由的的消息-" + msg);
        rabbitTemplate.convertAndSend("topic", "all.topic", "all.topic路由的的消息-" + msg);
        rabbitTemplate.convertAndSend("topic", "all.all", "all.all路由的的消息-" + msg);
    }

}
