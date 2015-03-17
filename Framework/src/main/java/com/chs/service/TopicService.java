package com.chs.service;

import java.util.List;

import com.chs.entity.Topic;
import com.chs.entity.UserEntity;

public interface TopicService {
	
	public void addTopic(Topic topic);
	
	public List<Topic> getAllTopics();
	public Topic getTopicByName(String topicname);
		
	public void deleteTopic(Integer topicId);
		
}
