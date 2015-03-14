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
import com.chs.service.PublishService;
import com.chs.service.TopicService;
import com.chs.service.UserService;
import com.chs.service.UsersTopicService;

@Controller
public class AmqpController {

	@Autowired
    private UserService userManager;
	private ConceptService conceptService;
	private DissagregationService dissagService;
	private TopicService topicService;
	private UsersTopicService usersTopicService;
	private PublishService publishService;
	
	
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
    public void setUsersTopicService(PublishService ps){
        this.publishService = ps;
    }
	
	@Autowired(required=true)
    @Qualifier(value="usersTopicService")
    public void setUsersTopicService(UsersTopicService uts){
        this.usersTopicService = uts;
    }
	
	
	//TODO: The function will receive the data to be published as a post request. Data will have topicname, values apart from username and password.
    @RequestMapping(value = "/publish", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.OK) 
    public void Publish(HttpServletRequest request, 
            @RequestParam(value="username", required=true) String email, 
            @RequestParam(value="pass", required=true) String password,
            @RequestParam(value="topicname", required=true) String topicname,
            @RequestParam(value="value", required=true) String data)
    {
    	UserEntity user = userManager.isUser(email,password);
    	if(user != null){
			System.out.println("Recived Params:username"+email+".Pass"+password+".topicname:"+topicname+".value"+data);

    		Topic t = topicService.getTopicByName(topicname);
    		if(t != null) {
    			
    			publishService.publishData(topicname, data);
    			
    		}
    	}

    }
        
    
}
