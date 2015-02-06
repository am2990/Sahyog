package com.chs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chs.entity.DissagregationDictionary;
import com.chs.service.ConceptService;
import com.chs.service.DissagregationService;
import com.chs.service.UserService;

@Controller
public class DashboardController {

	@Autowired
    private UserService userManager;
	private ConceptService conceptService;
	private DissagregationService dissagService;
	
	@Autowired(required=true)
    @Qualifier(value="conceptService")
    public void setConceptService(ConceptService cs){
        this.conceptService = cs;
    }
	
	@Autowired(required=true)
    @Qualifier(value="dissagregationService")
    public void setDissagService(DissagregationService ds){
        this.dissagService = ds;
    }
	
    @RequestMapping(value = "/dashboard/newtopic", method = RequestMethod.GET)
    public String newTopic(ModelMap map)
    {
    	List<DissagregationDictionary> dissaglist= dissagService.getAllDissagregations();
        map.addAttribute("conceptList", conceptService.getAllConcepts());
        map.addAttribute("dissagList", dissaglist);
        return "new_topic";
    }
    
    
}
