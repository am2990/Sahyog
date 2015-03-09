package com.chs.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.chs.amqp.ProducerConfiguration;

public class PublishServiceImpl implements PublishService{

	ApplicationContext applicationContext;
	@Override
	public boolean createTopic(String topicName) {
		// TODO create queue with the topicName and associated one time configuration.
		System.out.println("inside create topic with topicname:" + topicName);
		try {
			applicationContext = new AnnotationConfigApplicationContext(ProducerConfiguration.class);
			ProducerConfiguration producerConfig = (ProducerConfiguration)applicationContext.getBean(ProducerConfiguration.class);
			producerConfig.setQueueName(topicName);
			producerConfig.sendMessage("wtf");
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean publishData(String topicname, String data) {
		
		
		return false;
	}

}