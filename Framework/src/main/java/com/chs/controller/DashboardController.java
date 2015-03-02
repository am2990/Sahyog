package com.chs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chs.entity.ConceptDictionary;
import com.chs.entity.Topic;
import com.chs.service.ConceptService;
import com.chs.service.DissagregationService;
import com.chs.service.TopicService;
import com.chs.service.UserService;

@Controller
public class DashboardController {

	@Autowired
    private UserService userManager;
	private ConceptService conceptService;
	private DissagregationService dissagService;
	private TopicService topicService;
	
	
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
	
	@Autowired(required=true)
    @Qualifier(value="topicService")
    public void setTopicService(TopicService ts){
        this.topicService = ts;
    }
	
	
    @RequestMapping(value = "/dashboard/newtopic", method = RequestMethod.GET)
    public String newTopic(ModelMap map)
    {
    	List<ConceptDictionary> cd = conceptService.getAllConcepts();
    	Topic topic = null;
        map.addAttribute("conceptList", cd);
        map.addAttribute("dissagList", dissagService.getAllDissagregations());
        map.addAttribute("topic", topic);
        return "new_topic";
    }
    
    //TODO instead of retrieving individual parameters get Topic object from jsp
    @RequestMapping(value = "/dashboard/newtopic", method = RequestMethod.POST)
    public String addNewTopic(HttpServletRequest request,
    		@RequestParam(value="topicname", required=false) String topicname,
            @RequestParam(value="concept_id", required=false) String concept_id, 
            @RequestParam(value="topic_dissag", required=false) String dissag_name,
            ModelMap map)
    {
    	System.out.println(topicname+","+concept_id+","+dissag_name);
    	Topic t = new Topic();
    	t.setTopicName(topicname);
    	t.setConcept(conceptService.getConceptByName(concept_id));
    	t.setDisagregation(this.dissagService.getDissagregationByName(dissag_name));
    	System.out.println(topicname+","+t.getConcept()+","+t.getDissagreagtion());
    	topicService.addTopic(t);
        
        return "redirect:";
    }
    
    
}
