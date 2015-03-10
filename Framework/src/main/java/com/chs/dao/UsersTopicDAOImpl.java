package com.chs.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chs.entity.UserEntity;
import com.chs.entity.UsersTopic;

@Transactional 
@Repository
public class UsersTopicDAOImpl implements UsersTopicDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void save(UsersTopic userstopic) {
		System.out.println("inside save userstopic");
        this.sessionFactory.getCurrentSession().save(userstopic);
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersTopic> getAllMappings() {
        return this.sessionFactory.getCurrentSession().createQuery("from UsersTopic").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UsersTopic> getUserMappings(UserEntity user) {
	    
		Session session = this.sessionFactory.getCurrentSession();
	    Criteria cr = session.createCriteria(UsersTopic.class);
	    cr.add(Restrictions.eq("user", user));
	    List<UsersTopic> usersTopicList = cr.list();
	    
	    return usersTopicList;
	}


}