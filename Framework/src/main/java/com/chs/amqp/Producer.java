package com.chs.amqp;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Producer {
	
	private String message; 
	
	public Producer(String message){
		this.message = message;
	}

	public int publish() {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
		AmqpTemplate amqpTemplate = context.getBean(AmqpTemplate.class);
		amqpTemplate.convertAndSend(message);
		System.out.println("Sent:" + message);
		return 0;
		
	}

}
