package com.yanger.rabbitmq.headers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.HeadersExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeadersConfig {
	
	/**
	 	headers是一个自定义匹配规则的类型，在队列与交换器绑定时，会设定一组键值对规则, 
	 	消息中也包括一组键值对( headers 属性), 当这些键值对有一对, 或全部匹配时, 消息被投送到对应队列
	 */
	
	public static final String QUEUE1 = "headers_queue_1";
	
	public static final String QUEUE2 = "headers_queue_2";
	
	@Bean
	public Queue headersQueue1() {
		return new Queue(QUEUE1);
	}
	
	@Bean
	public Queue headersQueue2() {
		return new Queue(QUEUE2);
	}

	// headers策略的交换机
	@Bean
	public HeadersExchange headersExchange(){       
		return new HeadersExchange("headers");
	}
	
	// 绑定headersQueue1到headers交换机上，并指定当type和key全匹配
	@Bean
	public Binding headersBinding1(){ 
		Map<String, Object> allMap = new HashMap<>();
		allMap.put("type", "headers");
		allMap.put("key", "1234");
		return BindingBuilder.bind(headersQueue1()).to(headersExchange()).whereAll(allMap).match();
	}
		
	// 绑定headersQueue2到headers交换机上，并指定当type和key任意匹配一个
	@Bean
	public Binding headersBinding2(){ 
		Map<String, Object> allMap = new HashMap<>();
		allMap.put("type", "headers");
		allMap.put("key", "1234");
		return BindingBuilder.bind(headersQueue2()).to(headersExchange()).whereAny(allMap).match();
	}
	
}
