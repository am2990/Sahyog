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
		
		new AnnotationConfigApplicationContext(ProducerConfiguration.class);
		return 0;
		
	}

}
