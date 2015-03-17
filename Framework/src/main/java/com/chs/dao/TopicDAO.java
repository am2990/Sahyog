package com.chs.dao;

import java.util.List;

import com.chs.entity.Topic;
import com.chs.entity.UserEntity;

public interface TopicDAO {
	
	 public void addTopic(Topic topic);
	 
	 public List<Topic> getAllTopics();
     public Topic getTopicByName(String topicname);

	 public void deleteTopic(Integer topicId);

	 
}
