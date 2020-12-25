package com.yanger.rabbitmq.fanout;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//fanout策略，队列绑定到交换机即可
@Component
public class FanoutConsumer {
	
	// 监听Queue的消息：fanout_queue_1
	@RabbitListener(queues = FanoutConfig.QUEUE1)
	public void fanoutReceiv1(String msg) {
		System.out.println(FanoutConfig.QUEUE1 + "接收消息：" + msg);
	}

	// 监听Queue的消息：fanout_queue_2
	@RabbitListener(queues = FanoutConfig.QUEUE2)
	public void fanoutReceiv2(String msg) {
		System.out.println(FanoutConfig.QUEUE2 + "接收消息：" + msg);
	}

}
