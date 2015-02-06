package com.chs.service;

import java.util.List;

import com.chs.entity.Topic;

public interface TopicService {
	
	public void addTopic(Topic topic);
	public List<Topic> getAllTopics();
	public void deleteTopic(Integer topicId);
		
}
