package com.project.springboot.todoWebApp.login;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class WelcomeController {
	
	
	//http://localhost:8081/gotologin
		@RequestMapping(value="/",method=RequestMethod.GET)
		public String goToWelcomePage(ModelMap model) {
			model.put("name", getLoggedinUsername());
			return "welcome";
		}
		private String getLoggedinUsername() {
       org.springframework.security.core.Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			return authentication.getName();
		}
		
}
