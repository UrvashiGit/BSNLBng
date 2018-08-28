package com.sterlite.bsnl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CircularController {

	
	@RequestMapping("/circular")
	public ModelAndView circular() {
		return new ModelAndView("circular");
	}
}
