package com.yanger.rabbitmq.topic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// topic策略，根据#路由模糊匹配
@Component
public class TopicConsumer {
	
	// 监听Queue的消息：topic_queue_1，路由规则routingkey.#
	@RabbitListener(queues = TopicConfig.QUEUE1)
	public void topicReceiv1(String msg) {
		System.out.println(TopicConfig.QUEUE1 + "规则routingkey.#接收消息：" + msg);
	}

	// 监听Queue的消息：topic_queue_2，路由规则#.topic
	@RabbitListener(queues = TopicConfig.QUEUE2)
	public void topicReceiv2(String msg) {
		System.out.println(TopicConfig.QUEUE2 + "规则#.topic接收消息：" + msg);
	}
	
	// 监听Queue的消息：topic_queue_3，路由规则#
	@RabbitListener(queues = TopicConfig.QUEUE3)
	public void topicReceiv3(String msg) {
		System.out.println(TopicConfig.QUEUE3 + "规则#接收消息：" + msg);
	}

}
