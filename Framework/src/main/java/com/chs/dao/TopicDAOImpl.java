package com.chs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chs.entity.Topic;
import com.chs.entity.UserEntity;

@Transactional
@Repository
public class TopicDAOImpl implements TopicDAO{
	@Autowired
    private SessionFactory sessionFactory;
    
    
    
    public void deleteUser(Integer userId) {
        UserEntity user = (UserEntity) sessionFactory.getCurrentSession().load(
                UserEntity.class, userId);
        if (null != user) {
            this.sessionFactory.getCurrentSession().delete(user);
        }
    }
	

	@Override
	public void addTopic(Topic topic) {
		
		this.sessionFactory.getCurrentSession().save(topic);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Topic> getAllTopics() {
		return this.sessionFactory.getCurrentSession().createQuery("from Topic").list();
	}

	@Override
	public void deleteTopic(Integer topicId) {
		Topic topic = (Topic) sessionFactory.getCurrentSession().load(
                Topic.class, topicId);
        if (null != topic) {
            this.sessionFactory.getCurrentSession().delete(topic);
        }
	}


	@Override
	public Topic getTopicByName(String topicname) {
		
		Session session = this.sessionFactory.getCurrentSession();
	    Criteria cr = session.createCriteria(Topic.class);
	    cr.add(Restrictions.eq("topic_name", topicname));
	    Topic result = (Topic) cr.uniqueResult();
	    return result;
	    
	}

}
