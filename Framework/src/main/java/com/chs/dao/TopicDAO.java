package com.chs.dao;

import java.util.List;

import com.chs.entity.Topic;

public interface TopicDAO {
	
	 public void addTopic(Topic topic);
	 public List<Topic> getAllTopics();
	 public void deleteTopic(Integer topicId);
	 
}
