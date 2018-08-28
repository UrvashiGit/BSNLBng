package com.sterlite.bsnl.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sterlite.bsnl.entity.Book;
import com.sterlite.bsnl.services.IBookStoreService;


@Controller
public class ReportController {

	@Autowired
	private IBookStoreService service;
	
	
	@RequestMapping(value="/report", method=RequestMethod.GET)
	 public ModelAndView bookListReport(HttpServletRequest req, HttpServletResponse res){
		List<Book> books = service.getBooks();	
		System.out.println("INIDE REPORT CONTROLLER");
		return new ModelAndView(new ExcelViewReport(), "bookList", books);
	
	}

	@RequestMapping(value="/zoneWiseSummeryReport", method=RequestMethod.GET)
	 public ModelAndView zoneWiseSummeryReport(HttpServletRequest req, HttpServletResponse res){
		List<Book> books = service.getBooks();	
		System.out.println(">>>>>>>>>> zoneWiseSummeryReport >>>>>>>>>>>>>>>>>>>>>>");
		return new ModelAndView("zoneWiseSummeryReportView", "bookList", books);
	
	}
	
	
	@RequestMapping(value="/circleWiseSummeryReport", method=RequestMethod.GET)
	 public ModelAndView circleWiseSummeryReport(HttpServletRequest req, HttpServletResponse res){
		List<Book> books = service.getBooks();	
		System.out.println(">>>>>>>>>> circleWiseSummeryReportView >>>>>>>>>>>>>>>>>>>>>>");
		return new ModelAndView("circleWiseSummeryReportView", "bookList", books);
	
	}
	
	@RequestMapping(value="/zoneWiseDetailedReport", method=RequestMethod.GET)
	 public ModelAndView zoneWiseDetailedReport(HttpServletRequest req, HttpServletResponse res){
		List<Book> books = service.getBooks();	
		System.out.println(">>>>>>>>>> zoneWiseDetailedReportView >>>>>>>>>>>>>>>>>>>>>>");
		return new ModelAndView("zoneWiseDetailedReportView", "bookList", books);
	
	}
	
	@RequestMapping(value="/circleWiseDetailedReport", method=RequestMethod.GET)
	 public ModelAndView circleWiseSummeryReportView(HttpServletRequest req, HttpServletResponse res){
		List<Book> books = service.getBooks();	
		System.out.println(">>>>>>>>>> circleWiseDetailedReportView >>>>>>>>>>>>>>>>>>>>>>");
		return new ModelAndView("circleWiseDetailedReportView", "bookList", books);
	
	}
	

}
