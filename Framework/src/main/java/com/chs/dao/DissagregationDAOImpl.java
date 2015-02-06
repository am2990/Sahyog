package com.chs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chs.entity.DissagregationDictionary;

@Transactional 
@Repository
public class DissagregationDAOImpl implements DissagregationDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<DissagregationDictionary> getAllDissags() {
		
		return this.sessionFactory.getCurrentSession().createQuery("from DissagregationDictionary").list();
		
	}

}
