package com.sterlite.bsnl.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sterlite.bsnl.entity.Book;
import com.sterlite.bsnl.services.IBookStoreService;

@Controller
public class HomeController {

	@Autowired
	private IBookStoreService service;

	@RequestMapping("/home")
	public ModelAndView index() {
		List<Book> books = service.getBooks();
		return new ModelAndView("home","books",books);
	}
}
