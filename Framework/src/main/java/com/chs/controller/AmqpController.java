package com.chs.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.chs.entity.Topic;
import com.chs.entity.UserEntity;
import com.chs.service.ConceptService;
import com.chs.service.DissagregationService;
import com.chs.service.TopicService;
import com.chs.service.UserService;

@Controller
public class AmqpController {

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
	
	//TODO: The function will receive the data to be published as a post request. Data will have topicname, values apart from username and password.
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK) 
    public void Publish(HttpServletRequest request, 
            @RequestParam(value="username", required=true) String email, 
            @RequestParam(value="pass", required=true) String password,
            @RequestParam(value="topicname", required=true) String topicname,
            @RequestParam(value="value", required=true) String value)
    {
    	UserEntity user = userManager.isUser(email,password);
    	if(user != null){
			System.out.println("Recived Params:username"+email+".Pass"+password+".topicname:"+topicname+".value"+value);

    		Topic t = topicService.getTopicByName(topicname);
    		if(t != null) {
    			//TODO	publish the values to the topic
    		}
    	}

    }
        
    
}
