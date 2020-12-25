package com.yanger.rabbitmq.headers;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

//headers策略，根据headers中map属性一个或全部匹配
@Component
public class HeadersConsumer {
		
	// 监听Queue的消息：headers_queue_1，headers属性全部匹配
	@RabbitListener(queues = HeadersConfig.QUEUE1)
	public void headersReceiv1(byte[] msg) {
		System.out.println(HeadersConfig.QUEUE1 + "规则headers属性全部匹配接收消息：" + new String(msg));
	}

	// 监听Queue的消息：headers_queue_2，路由规则#.headers
	@RabbitListener(queues = HeadersConfig.QUEUE2)
	public void headersReceiv2(byte[] msg) {
		System.out.println(HeadersConfig.QUEUE2 + "规则headers属性任意一个匹配接收消息：" + new String(msg));
	}
	
}
