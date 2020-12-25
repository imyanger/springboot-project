package com.yanger.rabbitmq.direct;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfig {
	
	/*
		direct 类型的行为是"先匹配, 再投送". 即在绑定时设定一个 routingkey, 消息的routingkey 匹配时, 
		才会被交换器投送到绑定的队列中去.是RabbitMQ默认的交换机模式，也是最简单的模式，根据key全文匹配去寻找队列。
	*/

	public static final String QUEUE1 = "direct_queue_1";
	
    public static final String QUEUE2 = "direct_queue_2";
	
	@Bean
	public Queue directQueue1() {
		return new Queue(QUEUE1);
	}

	@Bean
	public Queue directQueue2() {
		// true声明持久队列，队列在服务器重启后存活
		return new Queue(QUEUE2, true);
	}

}
