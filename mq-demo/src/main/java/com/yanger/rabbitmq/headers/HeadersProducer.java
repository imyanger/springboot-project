package com.yanger.rabbitmq.headers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HeadersProducer {
	
	@Autowired
    private AmqpTemplate rabbitTemplate;
	
	public void send(String msg) {
		System.out.println("headers策略消息生产者发送消息：" + msg);
		MessageProperties allProp = new MessageProperties();
		allProp.setHeader("type", "headers");
		allProp.setHeader("key", "1234");
		Message allMsg = new Message(("headers全匹配的消息-" + msg).getBytes(), allProp);
        rabbitTemplate.convertAndSend("headers", "", allMsg);
        
        // headers属性type匹配
        MessageProperties anyProp1 = new MessageProperties();
        anyProp1.setHeader("type", "headers");
        anyProp1.setHeader("key", "xxx");
		Message anyMsg1 = new Message(("headers属性type匹配的的消息-" + msg).getBytes(), anyProp1);
        rabbitTemplate.convertAndSend("headers", "", anyMsg1);
        
        // headers属性key匹配
        MessageProperties anyProp2 = new MessageProperties();
        anyProp2.setHeader("type", "xxx");
        anyProp2.setHeader("key", "1234");
		Message anyMsg2 = new Message(("headers属性key匹配的的消息-" + msg).getBytes(), anyProp2);
        rabbitTemplate.convertAndSend("headers", "", anyMsg2);
    }

}
