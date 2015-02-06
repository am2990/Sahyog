package com.chs.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chs.entity.ConceptDictionary;

@Transactional 
@Repository
public class ConceptDictionaryDAOImpl implements ConceptDictionaryDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ConceptDictionary> getAllConcepts() {
		
		return this.sessionFactory.getCurrentSession().createQuery("from ConceptDictionary").list();
		
	}

}
