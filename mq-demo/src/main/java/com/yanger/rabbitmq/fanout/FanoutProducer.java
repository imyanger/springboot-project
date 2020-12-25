package com.yanger.rabbitmq.fanout;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FanoutProducer {
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
	
	public void send(String msg) {
		System.out.println("fanout策略消息生产者发送消息：" + msg);
        rabbitTemplate.convertAndSend("fanout", "", "fanout的的消息-" + msg);
    }

}
