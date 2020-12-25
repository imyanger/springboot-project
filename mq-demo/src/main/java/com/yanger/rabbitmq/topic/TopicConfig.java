package com.yanger.rabbitmq.topic;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfig {

	/*
		按规则转发消息（最灵活） 转发消息主要是根据通配符。 在这种交换机下，队列和交换机的绑定会定义一种路由模式，那么，通配符就要在这种路由模式和路由键之间匹配后交换机才能转发消息。
		路由键必须是一串字符，用句号（.） 隔开，
		路由模式必须包含一个 星号（*），主要用于匹配路由键指定位置的一个单词， 井号（#）就表示相当于一个或者多个单词
	*/
	
	public static final String QUEUE1 = "topic_queue_1";
	
	public static final String QUEUE2 = "topic_queue_2";
	
	public static final String QUEUE3 = "topic_queue_3";
	
	@Bean
	public Queue topicQueue1() {
		return new Queue(QUEUE1);
	}
	
	@Bean
	public Queue topicQueue2() {
		return new Queue(QUEUE2);
	}
	
	@Bean
	public Queue topicQueue3() {
		return new Queue(QUEUE3);
	}
	
	// topic策略的交换机
	@Bean
	public TopicExchange topicExchange(){       
		return new TopicExchange("topic");
	}
	
	// 绑定topicQueue1到topic交换机上，并指定路由匹配规则为routingkey.#，即路由以routingkey.开头的消息都将被topicQueue1接收
	@Bean
	public Binding topicBinding1(){ 
		return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("routingkey.#");
	}
	
	// 绑定topicQueue2到topic交换机上，并指定路由匹配规则为#.topic，即路由以.topic结尾的消息都将被topicQueue2接收
	@Bean
	public Binding topicBinding2(){ 
		return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("#.topic");
	}
		
	// 绑定topicQueue3到topic交换机上，并指定路由匹配规则为路由#，即任意路由消息都将被topicQueue3接收
	@Bean
	public Binding topicBinding3(){ 
		return BindingBuilder.bind(topicQueue3()).to(topicExchange()).with("#");
	}
}
