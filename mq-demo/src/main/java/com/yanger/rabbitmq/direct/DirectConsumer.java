package com.yanger.rabbitmq.direct;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// 消费者，direct类型根据routingkey完全匹配
@Component
public class DirectConsumer {

	// 监听Queue的消息：direct_queue_1
	@RabbitListener(queues = DirectConfig.QUEUE1)
	public void directReceiv1(String msg) {
		System.out.println(DirectConfig.QUEUE1 + "接收消息：" + msg);
	}

	// 监听Queue的消息：direct_queue_2
	@RabbitListener(queues = DirectConfig.QUEUE2)
	public void directReceiv2(String msg) {
		System.out.println(DirectConfig.QUEUE2 + "接收消息：" + msg);
	}
	
}
