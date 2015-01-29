package com.chs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chs.service.UserService;

@Controller
public class DashboardController {

	
	@Autowired
    private UserService userManager;
    @RequestMapping(value = "/dashboard/newtopic", method = RequestMethod.GET)
    public String newTopic(ModelMap map)
    {
//        map.addAttribute("user", new UserEntity());
//        map.addAttribute("userList", userManager.getAllUsers());
        return "new_topic";
    }
    
    
}
