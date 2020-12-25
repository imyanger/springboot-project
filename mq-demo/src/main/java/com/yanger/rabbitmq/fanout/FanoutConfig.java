package com.yanger.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FanoutConfig {
	
	/*
	 	转发消息到所有绑定队列，消息广播的模式，不管路由键或者是路由模式，
	 	会把消息发给绑定给它的全部队列，如果配置了routing_key会被忽略。
	 */

	public static final String QUEUE1 = "fanout_queue_1";
	
	public static final String QUEUE2 = "fanout_queue_2";
	
	@Bean
	public Queue fanoutQueue1() {
		return new Queue(QUEUE1);
	}
	
	@Bean
	public Queue fanoutQueue2() {
		return new Queue(QUEUE2);
	}
	
	// fanout策略的交换机
	@Bean
	public FanoutExchange fanoutExchange(){       
		return new FanoutExchange("fanout");
	}
	
	
	// 绑定fanoutQueue2到fanout交换机上，不需要指定路由
	@Bean
	public Binding fanoutBinding2(){ 
		return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
	}
		
	// 绑定fanoutQueue3到fanout交换机上，不需要指定路由
	@Bean
	public Binding fanoutBinding3(){ 
		return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
	}
}
