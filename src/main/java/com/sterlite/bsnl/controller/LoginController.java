package com.sterlite.bsnl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sterlite.bsnl.entity.User;
import com.sterlite.bsnl.services.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/authenticateUser", method = RequestMethod.POST)
	public ModelAndView authenticateUser() {
		List<User> books = null;
		return new ModelAndView("home","books",books);
	}
/*	
	@RequestMapping(value = "/login")
	public ModelAndView login() {
		List<User> books = null;
		return new ModelAndView("home","books",books);
	}*/
	
}
