package com.chs.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chs.dao.DissagregationDAO;
import com.chs.entity.DissagregationDictionary;

@Service
public class DissagregationServiceImpl implements DissagregationService{

	@Autowired
	private DissagregationDAO dissagregationDAO;
	@Override
	public List<DissagregationDictionary> getAllDissagregations() {
		// TODO Auto-generated method stub
		return this.dissagregationDAO.getAllDissags();
	}

	
}
