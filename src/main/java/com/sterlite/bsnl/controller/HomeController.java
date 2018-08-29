package com.sterlite.bsnl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sterlite.bsnl.entity.BngMaster;
import com.sterlite.bsnl.entity.Book;
import com.sterlite.bsnl.services.IBngService;
import com.sterlite.bsnl.services.IBookStoreService;

@Controller
public class HomeController {

	@Autowired
	private IBookStoreService service;
	
	@Autowired
	private IBngService bngMasterService;

	@RequestMapping("/home")
	public ModelAndView index() {
		List<BngMaster> bngMasterList = bngMasterService.getBngMasterList();
		return new ModelAndView("home","bngList",bngMasterList);
	}
}
