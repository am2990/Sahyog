package com.chs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chs.dao.TopicDAO;
import com.chs.dao.UserDAO;
import com.chs.entity.Topic;

@Service
public class TopicServiceImpl implements TopicService{

    @Autowired
    private TopicDAO topicDAO;
    
	@Override
	public void addTopic(Topic topic) {
		topicDAO.addTopic(topic);
	}

	@Override
	public List<Topic> getAllTopics() {
		return topicDAO.getAllTopics();
	}

	@Override
	public void deleteTopic(Integer topicId) {
		topicDAO.deleteTopic(topicId);
	}

	@Override
	public Topic getTopicByName(String topicname) {
		return topicDAO.getTopicByName(topicname);
	}

}
