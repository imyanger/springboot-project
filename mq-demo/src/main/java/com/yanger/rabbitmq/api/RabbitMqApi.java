package com.yanger.rabbitmq.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yanger.rabbitmq.direct.DirectProducer;
import com.yanger.rabbitmq.fanout.FanoutProducer;
import com.yanger.rabbitmq.headers.HeadersProducer;
import com.yanger.rabbitmq.topic.TopicProducer;

import io.swagger.annotations.Api;

@Api
@RestController
@RequestMapping("send")
public class RabbitMqApi {

	@Autowired
	private DirectProducer directProducer;

	/**
	 * @description direct策略发送消息
	 * @author YangHao  
	 * @time 2019年3月2日-下午6:24:10
	 * @param msg
	 */
	@GetMapping("direct")
	public void direct(@RequestParam String msg) {
		directProducer.send(msg);
	}
	
	
	@Autowired
	private TopicProducer topicProducer;
	
	/**
	 * @description topic策略发送消息
	 * @author YangHao  
	 * @time 2019年3月2日-下午6:24:30
	 * @param msg
	 */
	@GetMapping("topic")
	public void topic(@RequestParam String msg) {
		topicProducer.send(msg);
	}

	
	@Autowired
	private HeadersProducer headersProducer;
	
	/**
	 * @description headers策略发送消息
	 * @author YangHao  
	 * @time 2019年3月2日-下午6:24:30
	 * @param msg
	 */
	@GetMapping("headers")
	public void headers(@RequestParam String msg) {
		headersProducer.send(msg);
	}
	
	
	@Autowired
	FanoutProducer fanoutProducer;
	
	/**
	 * @description fanout策略发送消息
	 * @author YangHao  
	 * @time 2019年3月2日-下午6:24:30
	 * @param msg
	 */
	@GetMapping("fanout")
	public void fanout(@RequestParam String msg) {
		fanoutProducer.send(msg);
	}
	
}
