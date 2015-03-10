package com.chs.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chs.entity.ConceptDictionary;
import com.chs.entity.Topic;
import com.chs.entity.UserEntity;
import com.chs.entity.UsersTopic;
import com.chs.service.ConceptService;
import com.chs.service.DissagregationService;
import com.chs.service.PublishService;
import com.chs.service.TopicService;
import com.chs.service.UserService;
import com.chs.service.UsersTopicService;

@Controller
public class DashboardController {

	@Autowired
    private UserService userManager;
	private ConceptService conceptService;
	private DissagregationService dissagService;
	private TopicService topicService;
	private PublishService publishService;
	private UsersTopicService userTopicService; 
	
	
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
	
	@Autowired(required=true)
    @Qualifier(value="publishService")
    public void setPublishService(PublishService ps){
        this.publishService = ps;
    }
	
	@Autowired(required=true)
    @Qualifier(value="usersTopicService")
    public void setUsersTopicService(UsersTopicService uts){
        this.userTopicService = uts;
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
    	
    	publishService.createTopic(topicname.replace(' ', '.'));
        
        return "redirect:";
    }
    
    @RequestMapping(value = "/dashboard/subscribe", method = RequestMethod.GET, params = {"topicName" , "User"})
    @ResponseStatus(value = HttpStatus.OK) 
    public void topicSubscribe(@RequestParam(value = "topicName") String topicName,
    						   @RequestParam(value = "User") String userId,
    						   ModelMap map)
    {
    	System.out.println("got the topicname-"+topicName);
    	UserEntity user = userManager.getUserById(userId);
    	System.out.println("got the user-"+user.getFirstname());
    	
    	UsersTopic ut = new UsersTopic();
    	ut.setTopic(topicService.getTopicByName(topicName));
    	ut.setUser(user);
    	userTopicService.save(ut);
//    	List<ConceptDictionary> cd = conceptService.getAllConcepts();
//    	Topic topic = null;
//        map.addAttribute("conceptList", cd);
//        map.addAttribute("dissagList", dissagService.getAllDissagregations());
//        map.addAttribute("topic", topic);
        //return "sexy success 1";
    }
    
}
