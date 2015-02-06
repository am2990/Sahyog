package com.chs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chs.dao.ConceptDictionaryDAO;
import com.chs.entity.ConceptDictionary;

@Service
public class ConceptServiceImpl implements ConceptService{

	
	@Autowired
    private ConceptDictionaryDAO conceptDAO;
    
    
	@Override
	@Transactional
	public List<ConceptDictionary> getAllConcepts() {
		
		return this.conceptDAO.getAllConcepts();
		
	}

}
